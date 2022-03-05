import java.util.*
import kotlin.collections.HashMap

class Database {

    var test: HashMap<String, Customers> = HashMap<String, Customers>()
    companion object{
        var currentCustomers: HashMap<String, Customers> = HashMap<String, Customers>() //Current approved Customers

        var appCustomers: HashMap<String, Customers> = HashMap<String, Customers>() //Customers waiting for approval

        var employees: HashMap<String, Employees> = HashMap<String, Employees>() //Customers waiting for approval

    }
    fun findCustomers(userName:String):Customers?{
        return currentCustomers[userName.uppercase()]
    }

    fun customerVerify(userName:String):Boolean{
        return currentCustomers[userName.uppercase()]!=null
    }


}

