import kotlin.math.abs

class Transactions (c:Customers){
    val c = c

    fun deposit(depos:Double):Boolean{

        if(depos < 0)
        {
            println("Illegal deposit:negative Numbers $depos")
            return false
        }
        c.balance += depos
        println("${c.userName}: Deposited $depos")
        println("${c.userName}: Total balance ${c.balance}")
        c.transHistory.add("1$depos")
        return true
    }

    fun viewBalance():Double{
        return c.balance
    }

    fun withDraw(withdrawAmount:Double):Boolean{

        if(withdrawAmount < 0)
        {
            println("Illegal Withdrawal:negative Numbers $withdrawAmount")
            return false
        }
        else if(withdrawAmount > c.balance)
        {
            println("Illegal Withdrawal:Overdrafted balance by ${abs(withdrawAmount-c.balance)}")
            return false
        }
        else {
            c.balance -= withdrawAmount
            println("${c.userName}: Withdraw $withdrawAmount")
            println("${c.userName}: Total balance ${c.balance}")
            c.transHistory.add("2$withdrawAmount")
            return true
        }
    }

    fun transfer(amount:Double, destUserName:String):Boolean{

        if(amount<0)
        {
            println("Transfer failed: Negative Number")
            return false
        }

        if(withDraw(amount)){
            val dc = Main.data.findCustomers(destUserName)
            return if( dc != null) {
                val dest: Transactions = Transactions(dc)
                dest.deposit(amount)
                println("Status report: Original Owner");
                c.printC();
                println("Status report: Target");
                dest.c.printC();
                true
            } else false
        }
        else{
            println("Transfer failed")
            return false
        }

    }

}
