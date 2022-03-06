import java.util.*

class Database {

    var test: HashMap<String, Customers> = HashMap<String, Customers>()
    companion object{
        val currentCustomers: HashMap<String, Customers> = HashMap<String, Customers>() //Current approved Customers

        val appCustomers: HashMap<String, Customers> = HashMap<String, Customers>() //Customers waiting for approval

        val employees: HashMap<String, Employees> = HashMap<String, Employees>() //Customers waiting for approval

    }

    fun findApplicant(userName: String): Customers? {
        return appCustomers[userName.uppercase()]
    }
    fun findCustomers(userName:String):Customers? {
        return currentCustomers[userName.uppercase()]
    }

    fun findEmployees(userName: String): Employees? {
        return employees[userName.uppercase()]
    }

    fun applications(userName:String, password:String, accountType:Int, balance:Double)
    {
        if(!customerVerify(userName) && !appVerify(userName)) {
            val c: Customers = Customers(userName.uppercase(), password, accountType, balance)
            appCustomers[userName.uppercase()] = c
        }
        else println("User name $userName has already been taken")
    }

    fun applications(c:Customers){println("Not yet implemented")} //	appCustomers.put(c.getUserName().toUpperCase(), c);

    fun newCustomers(userName:String, password:String, accountType:Int, balance:Double){
        var c:Customers = Customers(userName.uppercase(), password, accountType, balance)
        currentCustomers[userName.uppercase()] = c
    }

    fun newCustomers(c:Customers){
        currentCustomers[c.userName.uppercase()] = c}

    fun newEmployee(userName:String, password: String, accessLevel:Int){

        var e:Employees = Employees(userName.uppercase(),password,accessLevel)
        employees[userName.uppercase()]=e
    }

    fun newEmployee(e:Employees){ println("Not yet implemented") }


    fun newAdmin(userName: String,password: String,accessLevel: Int)
    {
        var e:Admin = Admin(userName.uppercase(),password, accessLevel)
        employees[userName.uppercase()]=e
    }

    //deny application given username, delete from appcustomers
    fun removeApplication(userName:String)
    {
        if(appVerify(userName))
        {
            appCustomers.remove(userName.uppercase())
        }
        else println("Applicant Does Not Exist")
    }
    //remove customer
    fun removeCustomer(userName:String)
    {
        if(customerVerify(userName))
        {
            currentCustomers.remove(userName.uppercase())
        }
        else println("Customer Does Not Exist")
    }

    fun appVerify(userName: String):Boolean
    {
        return appCustomers[userName.uppercase()]!=null
    }
    fun customerVerify(userName:String):Boolean
    {
        return currentCustomers[userName.uppercase()]!=null
    }

    fun customerVerify(userName: String, password: String):Boolean{
        if(customerVerify(userName)){
            var c:Customers? = getCustomer(userName)
            return c!!.password.equals(password)
        }
        return false
    }

    fun appVerify(userName: String, password: String):Boolean{
        if(appVerify(userName)){
            var c:Customers? = getApplicant(userName)
            return c!!.password.equals(password)
        }
        return false
    }

    //get customer in current, returns null if object don't exist
    fun getCustomer(userName:String):Customers?
    {
        return currentCustomers[userName.uppercase()]
    }
    //get customer in app
    fun getApplicant(userName:String):Customers?
    {
        return appCustomers[userName.uppercase()]
    }
    //get employee
    fun getEmployee(userName:String):Employees?
    {
        return employees[userName.uppercase()]
    }

    fun employeeVerify(userName:String, password: String):Boolean
    {
        var e:Employees? = employees[userName.uppercase()]
        return when (e) {
            null -> { println("No Such Employees")
                        return false
                    }
            else -> {
                    return e.password.equals(password)
            }
        }

    }

    fun appPrint(userName: String){
        var c:Customers? = appCustomers.get(userName.uppercase())
        c?.printC()

    }

    fun customerPrint(userName: String){
        var c:Customers? = currentCustomers.get(userName.uppercase())
        c?.printC()

    }

}
