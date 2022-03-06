import java.util.InputMismatchException

class MenuCustomers {

    val scan = Main.scan
    var name:String = ""
    var accountType:Int = 0
    var balance:Double=0.0

    fun pickAcountType():Int{
        do{
            println("Please Select Account Type.")
            println("1. Checking");
            println("2. Savings");
            println("3. Joint");
            try{
                accountType = scan.nextInt()
                scan.nextLine()
                if(accountType != 1 && accountType != 2 && accountType != 3)
                    println("not a valid option, please try again")
            }
            catch(e:InputMismatchException)
            {
               println("Not a number, please try again")
               scan.nextLine()
            }
        }while(accountType != 1 && accountType != 2 && accountType != 3)

        return accountType;
    }

    fun depositBalance():Double{
        do{
            println("Deposit amount?");
            balance=-1.0 //default check case
            try{
                balance=scan.nextDouble()
                scan.nextLine()
            }catch (e:InputMismatchException){
                println("Not a Number")
                scan.nextLine()
            }
            if(balance <0) println("Can't deposit negative number")
        }while(balance<0)

        return balance
    }

    fun withDrawMenu(t:Transactions){
        var wd:Double = 0.0 //withdraw amount
        println("Enter Withdraw Amount")
        try{
            wd = Main.scan.nextDouble()
            Main.scan.nextLine()
            t.withDraw(wd);
        }
        catch(e:InputMismatchException)
        {
            println("Cannot withdrawl: Not a number")
        }
    }

    fun depositMenu(t:Transactions){
        var depos:Double = 0.0  //withdraw amount
        println("Enter Deposit Amount")
        try{
            depos = Main.scan.nextDouble()
            Main.scan.nextLine()
            t.deposit(depos);
        }
        catch(e:InputMismatchException)
        {
            println("Cannot Deposit: Not a number")
        }
    }

    fun viewBalanceMenu(t:Transactions ){
        println("Total Balance = ${t.viewBalance()}")
    }

    fun transferMenu(t:Transactions) {
        var amount: Double = 0.0
        var destUserName: String = ""

        println("Enter Destination User name")
        destUserName = Main.scan.nextLine()
        val target = Main.data.findCustomers(destUserName)
        if (target != null) {
            val dest: Transactions = Transactions(target!!)
            println("Enter Transfer Amount")

            try{
                amount = Main.scan.nextDouble()
            }
            catch(e:InputMismatchException){
                println("Not a Number")
            }

            t.transfer(amount, destUserName)
        }
        else {
            System.out.println("Transfer failed: Destination UserName: $destUserName do not exist.");
            return;
        }


    }
}
