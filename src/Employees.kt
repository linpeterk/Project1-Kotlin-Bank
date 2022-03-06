open class Employees(
    override var userName:String, override var password:String,
    open var accessLevel:Int=1)   : Person {

    constructor() : this("default", "default", 1)

    fun listAllCustomer(){
        if(Database.currentCustomers.isEmpty())
        {
            println("No Customers")
        }
        println("+------------------+")
        println("|List of Customers |")
        println("+------------------+")

        Database.currentCustomers.forEach { (k, v) ->  println(v.printC())}

        println("+------------------+")
        println("|List of Customers |")
        println("+------------------+")

    }

    fun listAllApplicants(){
        if(Database.appCustomers.isEmpty())
        {
            println("No Applicants")
        }
        println("+------------------+")
        println("|List of Applicants|")
        println("+------------------+")

        Database.appCustomers.forEach { (k, v) ->  println(v.printC())}

        println("+------------------+")
        println("|List of Applicants|")
        println("+------------------+")

    }

    fun searchCustomers(customerName:String):Customers?{
        if(Main.data.customerVerify(customerName))
        {
            var c = Database.currentCustomers[customerName.uppercase()]
            c!!.printC()
            return c
        }
        else {
            println("No customer with user name $customerName")
            return null
        }
    }
    override fun printC(){

        println("Username= $userName Password= $password Account Type= $accessLevel")

    }

    fun acceptApplicants(customerName:String){
        var c:Customers
        if(!Main.data.customerVerify(customerName))
        {
            if(Main.data.appVerify(customerName))
            {
                c= Main.data.findCustomers(customerName)!!
                Main.data.newCustomers(c)
                Main.data.removeApplication(customerName)
            }
            else{
                println("Applicant don't Exist")
            }
        }
        else{
            println("Applicant is already a customer")
        }
    }

    fun denyApplicants(customerName:String){

        if(Main.data.appVerify(customerName)){
            Main.data.removeApplication(customerName)
        }
        else{
            println("Applicant name doesn't exist")
        }
    }
}

