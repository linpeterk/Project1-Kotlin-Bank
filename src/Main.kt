import java.util.*

fun main(){
    println("Hello World")
    var data = Database()

    var c =  Customers("Peter", "a12345", 3, 2000.0)

    var d =  Customers("Dan", "a12345", 2, 1000.0)
    Database.currentCustomers["Peter"] = c
    Database.currentCustomers["Dan"] = d
    var e = Employees()
    e.listAllCustomer()


}

class Main {
    companion object{
        var data = Database() //Customers waiting for approval

    }

}