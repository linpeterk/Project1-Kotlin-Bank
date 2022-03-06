import java.util.*

fun main(){
    initalize()
    /*
    var v = LoginVerification(Main.scan)
    v.customerLoginVer()
    v.employeeLoginVer()
*/

    var menu = Menu()
    menu.welcomeScreen()
    var menuC = MenuCustomers()
    //menu.startApplication()
    //println(Main.data.appVerify("lope"))

}

fun initalize()
{
    Main.data.newAdmin("admin", "a12345", 100);

    Main.data.newCustomers("Tenny", "a12345", 2, 600.0);
    Main.data.newCustomers("tom", "a12345", 1, 700.0);
    Main.data.newCustomers("Ken", "a12345", 3, 800.0);

    Main.data.applications("Peter", "a12345", 3, 25.0);
    Main.data.applications("Ean", "a12345", 1, 100.0);
    Main.data.applications("Harry", "a12345", 2, 1000.0);

    Main.data.newEmployee("pogo", "a12345", 1);
    Main.data.newEmployee("manny", "a12345", 1);
    Main.data.newEmployee("lori", "a12345", 1);

}
class Main {
    companion object{
        var data = Database() //Customers waiting for approval
        var scan = Scanner(System.`in`)
    }

}