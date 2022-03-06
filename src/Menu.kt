import java.util.*

class Menu {
    var name:String =""
    var password:String=""
    var accountType:Int = 0
    var balance:Double = 0.0
    val veri= LoginVerification(Main.scan)
    val menuC = MenuCustomers()


    //start new customer application into appcustomer
    fun startApplication(){
        println("Welcome New Customer")
        do{
            name= veri.enterUserName() //enter username
            if(Main.data.appVerify(name) || Main.data.customerVerify(name)) //Check name not taken
            {
                println("User name taken, please try another name")
            }

        }while(Main.data.appVerify(name)||Main.data.customerVerify(name))

            password = veri.enterPassword() // enter password
            accountType = menuC.pickAcountType()
            balance = menuC.depositBalance()
            Main.data.applications(name, password, accountType, balance)
            Main.data.appPrint(name)
            println("Application successful!")
            println("Your application is in review, thank you for choosing us and we will get back to you shortly")
    }

    fun customerOptions(c:Customers){

        val t:Transactions = Transactions(c)
        var choice:Int = 500
        println();
        println("*********** CUSTOMER MENU ***********");
        println("Please select the following options");
        println("1. Withdrawal");
        println("2. Deposit");
        println("3. View Balance");
        println("4. Transfer");
        println("5. View History");
        println("0. EXIT");
        println("*************************************");

            try{
                choice = Main.scan.nextInt()
                Main.scan.nextLine()
            }
        catch(e:InputMismatchException)
        {
            System.out.println("Not a number");
            Main.scan.nextLine()
        }
        when(choice){
            1-> {menuC.withDrawMenu(t)
                customerOptions(c)
            }
            2-> {menuC.depositMenu(t)
                customerOptions(c)
            }
            3-> {menuC.viewBalanceMenu(t)
                customerOptions(c)
            }
            4-> {menuC.transferMenu(t)
                customerOptions(c)
            }
            5-> {
                c.printHistory()
                customerOptions(c)
            }

            0-> {}

            else-> {
                println("No valid selection")
                customerOptions(c)
            }
        }
    }

    //One of the employees menu option - Print all customer
    fun viewAllCUstomerMenu(e:Employees){
        e.listAllCustomer()
    }

    //employee menu option - search and print 1 customer
    fun searchCustomerMenu(e:Employees) {
        println("Please Enter Customer's Name")
        try {
            name = Main.scan.nextLine()
            e.searchCustomers(name)
        } catch (e: InputMismatchException) {
            println("Input Mismatched")
        }
        catch (e: Exception) {
            println("Some sort of errors")
        }
    }

    //Admin menu options Find customers, print it, and allow customers function such as deposit, withdraw etc
    fun searchCustomerAdminMenu(e:Employees) {
        println("Please enter Customer's Name")
        try {
            name = Main.scan.nextLine()
            var c: Customers? = e.searchCustomers(name)
            if (c != null) //customer exist
            {
                c.printC()
                customerOptions(c)
            }
        } catch (e: InputMismatchException) {
            println("Input Mismatched")
        } catch (e: Exception) {
            println("Some sort of errors")
        }
    }

    fun acceptDenyApplicantMenu(e:Employees){
        e.listAllApplicants() //list all applicants
        var c:Customers
        println("Enter Applicant's Name")
        name= Main.scan.nextLine()
        if(!Main.data.appVerify(name))
        {
            println("No Applicant Found")
            return
        }
        c=Main.data.findApplicant(name)!!
        c.printC()

        //Start choice selections to accept or Deny
        var choice:Int = 1000
        println("Accept or Deny?");
        println("1. Accept");
        println("2. Deny?");
        try{
            choice = Main.scan.nextInt()
            Main.scan.nextLine()
            when(choice){
                1->{
                    println("Applicant ${c.userName} Accepted!")
                    e.acceptApplicants(name)
                    return
                }
                2->{
                    println("Applicant ${c.userName} Denied!")
                    e.denyApplicants(name)
                    return
                }
                else->{
                    println("Denied operation: Invalid number")
                    return
                }
            }
        }
        catch(e:InputMismatchException){
            println("Invalid input ${e.message}")
            Main.scan.nextLine()
        }
    }
//CHECKER HERE
    fun employeeMenu(e: Employees?) {
        var choice = 500 // pointless number
        println()
        println("*********** EMPLOYEE MENU *************")
        println("Please select the following options")
        println("1. View All Customers")
        println("2. Search Account")
        println("3. Approve/Deny Applications")
        println("0. EXIT")
        println("***************************************")
        if (Main.scan.hasNextInt()) {
            choice = Main.scan.nextInt()
            Main.scan.nextLine() //clear buffer
        } else {
            println("Not a number, ")
            Main.scan.nextLine()
        }
        when (choice) {
            1 -> {
                viewAllCUstomerMenu(e!!)
                employeeMenu(e)
            }
            2 -> {
                searchCustomerMenu(e!!)
                employeeMenu(e)
            }
            3 -> {
                acceptDenyApplicantMenu(e!!)
                employeeMenu(e)
            }
            0 -> {}
            else -> {
                println("No valid selection")
                employeeMenu(e)
            }
        }
    }

    fun cancelAccountMenu() {
        var c: Customers? = null
        println("Enter Customer's Name")
        if (Main.scan.hasNext()) {
            name = Main.scan.nextLine()
            if (!Main.data.customerVerify(name)) {
                println("No Customer Found")
                return
            }
            c = Main.data.findCustomers(name)
        } else {
            println("Scanner Error")
            return
        }
        println("Customer " + c!!.userName + " is Cancelled!")
        Main.data.removeCustomer(name)
    }

    /*
	 * Admin Menu Selection
	 * 1.View all customers, print info only
	 * 2.Search one specific customer given a name, then allow to perform customer function
	 * 3.Approve or deny applicants
	 * 4.Delete one customer given inputted name
	 * 7.View all employees, print info only
	 * 9.Add employees given user input
	 * 0.exit menu
	 *
	 * Parameters obtained after passing verification process, current employee.
	 */
    fun adminMenu(e: Employees) {
        var choice = 500 //pointless number
        println()
        println("************ ADMIN MENU ************")
        println("Please select the following options")
        println("1. View All Customers")
        println("2. Search and Edit Account")
        println("3. Approve/Deny Applications")
        println("4. Cancel Accounts")
        println("7. View ALL Employees")
        println("9. Add Employee")
        println("0. EXIT")
        println("************************************")
        if (Main.scan.hasNextInt()) {
            choice = Main.scan.nextInt()
            Main.scan.nextLine() //clear buffer
        } else {
            println("Not a number, ")
            Main.scan.nextLine()
        }
        when (choice) {
            1 -> {
                viewAllCUstomerMenu(e)
                adminMenu(e)
            }
            2 -> {
                searchCustomerAdminMenu(e)
                adminMenu(e)
            }
            3 -> {
                acceptDenyApplicantMenu(e)
                adminMenu(e)
            }
            4 -> {
                cancelAccountMenu()
                adminMenu(e)
            }
            7 -> {
                if(e is Admin) e.listAllCustomer()
                adminMenu(e)
            }
            9 -> {
               // addEmployee()
                adminMenu(e)
            }
            0 -> {}
            else -> {
                println("No valid selection")
                adminMenu(e)
            }
        }
    }

    //add employee
    fun addEmployee() {
        val e: Employees? = null
        println("Enter Employee Name")
        name = Main.scan.nextLine()
        println("Enter Employee password")
        password = Main.scan.nextLine()
        if (Main.data.findEmployees(name) == null) {
            Main.data.newEmployee(name, password, 1)
            println("Employee $name added!")
        } else println("Employee already exists")
    }

    //Determine access level of employee. 1 for regular employee, 100 for admin
    fun employeeOptions(e: Employees?) {
        when (veri.employeesType(e!!)) {
            1 -> employeeMenu(e)
            100 -> adminMenu(e)
            else -> println("Undeclared employee type")
        }
    }

    fun welcomeScreen(): Int {
        println("	******************************************")
        println("    	*	 Welcome to Bank of Peter        *")
        println("	******************************************")
        return when (choices()) {
            "NCustomer" -> {
                startApplication()
                welcomeScreen()
                1
            }
            "ECustomer" -> {
                customerOptions(veri.customerLoginVer())
                2
            }
            "Employee" -> {
                employeeOptions(veri.employeeLoginVer())
                3
            }
            "Exit" -> 0
            else -> {
                println("No right option selected")
                0
            }
        }
    }

    fun choices(): String {
        var input = 0
        do {
            println("Please Enter 1 for New Customer 2 for Existing Customer 3 for Employee")
            println("1. New Customer")
            println("2. Existing Customer")
            println("3. Employee")
            println("0. Exit")
            if (scan.hasNextInt()) {
                input = scan.nextInt()
                scan.nextLine() //clear buffer
                //System.out.println(input);
                if (input == 1) {
                    return "NCustomer"
                } else if (input == 2) {
                    return "ECustomer"
                } else if (input == 3) {
                    return "Employee"
                } else if (input == 0) {
                    return "Exit"
                } else {
                    println("Not a valid number, please try again")
                    println()
                }
            } else {
                println("Not a number, please enter a number")
                println()
                scan.nextLine()
            }
        } while (input != 1 && input != 2 && input != 3)
        return "Exceptions"
    }
}
 /*





	//Start of screen, selecting type of user
	public int welcomeScreen()
	{
		System.out.println("	******************************************");
		System.out.println("    	*	 Welcome to Bank of Peter        *");
		System.out.println("	******************************************");
		String choice = choices();

		switch(choice)
		{
		case "NCustomer": //System.out.println("It's a new customer");
							startApplication(); welcomeScreen();return 1;

		case "ECustomer": //System.out.println("It's an existing customer");
							customerOptions(veri.customerloginVer());; return 2;
							/*(veri.customerLoginVer is a verification access to make sure credential match.
							 		ONLY RETURNS OBJECT CUSTOMER IF VERIFICATION IS SUCCESSFUL;		*/
		case "Employee":  //System.out.println("It's an employee");
							employeeOptions(veri.employeeloginVer());	return 3;

		case "Exit": return 0;

		default:System.out.println("No right option selected"); return 0;
		}

	}

	public String choices()
	{
		int input = 0;

		do {
		System.out.println("Please Enter 1 for New Customer 2 for Existing Customer 3 for Employee");
		System.out.println("1. New Customer");
		System.out.println("2. Existing Customer");
		System.out.println("3. Employee");
		System.out.println("0. Exit");
		if(scan.hasNextInt())
		{

			input = scan.nextInt();
			scan.nextLine(); //clear buffer
			//System.out.println(input);
			if(input == 1)
			{

				return "NCustomer";
			}
			else if(input == 2)
			{

				return "ECustomer";
			}
			else if(input ==3)
			{

				return "Employee";
			}
			else if(input==0)
			{
				return "Exit";
			}
			else
			{
				System.out.println("Not a valid number, please try again");
				System.out.println();


			}
		}
		else {
			System.out.println("Not a number, please enter a number");
			System.out.println();
			scan.nextLine();
		}
		}while(input !=1 && input != 2 && input != 3);


		return "Exceptions";
	}
}

 */