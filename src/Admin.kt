class Admin(override var employeeName:String, override var password:String, override var accessLevel:Int)
    : Employees(employeeName,password,accessLevel), Person{



}