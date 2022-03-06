class Admin(override var userName:String, override var password:String, override var accessLevel:Int)
    : Employees(userName,password,accessLevel), Person{

    constructor() : this("default", "default", 100)
    {
        println("admin constructed")
    }

    fun listAllEmployees() {
        if (Database.employees.isEmpty()) {
            println("No Employees")
            return
        }
        //loop through map, print it
            Database.employees.forEach { t, u -> println("User Name= $t Password= ${u.password} Access Level= ${u.accessLevel}") }
    }


}