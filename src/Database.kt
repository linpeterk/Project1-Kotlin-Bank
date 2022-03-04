class Database {
    var test: HashMap<String, String> = HashMap<String, String>()
    companion object{
        var currentCustomers: HashMap<String, String> = HashMap<String, String>() //Current approved Customers

        var appCustomers: HashMap<String, String> = HashMap<String, String>() //Customers waiting for approval

        var employees: HashMap<String, String> = HashMap<String, String>() //Customers waiting for approval

    }

}