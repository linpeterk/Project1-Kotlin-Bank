import java.io.IOException
import java.util.*

class LoginVerification (var scan:Scanner){

    var name:String=""
    var password:String=""
    val ADMIN:Int = 100
    val EMPLOYEE:Int = 1

    fun enterUserName(): String {

        try{
            println("Please Enter a User Name")
            name = scan.nextLine()
        }catch (e: IOException){
            println("Not a valid User Name")
            e.printStackTrace()
        }
        return name
    }

    fun enterPassword():String{
        do{
            println("Please enter a password with at least 5 characters")
            try {
                password = scan.nextLine();
                if(password.length<5){
                    println("Password too short, please try again")
                }
            }
            catch (e:IOException)
            {
                e.printStackTrace()
                break;
            }
        }while(password.length<5)

        return password;
    }

    fun customerLoginVer():Customers{
       var verified:Boolean = false
        do{
            name = enterUserName();
            password = enterPassword();
            verified=Main.data.customerVerify(name, password)
            if(!verified)
            {
                println("Credential you provided don't match, please try again")
            }
        }while(!verified)
        println("Login Success, Welcome $name !!")
        return Main.data.getCustomer(name)!!;
    }

    fun employeeLoginVer():Employees{
        var verified:Boolean = false
        do{
            name = enterUserName();
            password = enterPassword();
            verified=Main.data.employeeVerify(name, password)
            if(!verified)
            {
                println("Credential you provided don't match, please try again")
            }
        }while(!verified)
        println("Login Success, Welcome $name !!")
        return Main.data.getEmployee(name)!!;
    }

        fun employeesType(e:Employees):Int{
            return when(e){
                is Admin -> ADMIN
                else -> EMPLOYEE
            }
        }

}
