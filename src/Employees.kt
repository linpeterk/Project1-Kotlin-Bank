open class Employees(var employeeName:String="", var password:String="",
                       var accessLevel:Int=1)   : Person {


    fun listAllCustomer(){
        if(Database.currentCustomers.isEmpty())
        {
            println("No Customers")
        }
        println("+------------------+");
        println("|List of Customers |");
        println("+------------------+");

        Database.currentCustomers.forEach { (k, v) ->  println(v.printCustomer())}

        println("+------------------+");
        println("|List of Customers |");
        println("+------------------+");

    }

    fun listAllApplicants(){
        if(Database.appCustomers.isEmpty())
        {
            println("No Applicants")
        }
        println("+------------------+");
        println("|List of Applicants|");
        println("+------------------+");

        Database.appCustomers.forEach { (k, v) ->  println(v.printCustomer())}

        println("+------------------+");
        println("|List of Applicants|");
        println("+------------------+");

    }

    fun searchCustomers(customerName:String):Customers?{
        if(Main.data.customerVerify(customerName))
        {
            var c = Database.currentCustomers[customerName.uppercase()]
            c!!.printCustomer()
            return c
        }
        else return null
    }

}
/*


		if (Database.customerVerify(customerName))
		{
			Customers c = Database.findCustomers(customerName);
			c.printCustomer();
			return c;
		}
		 else
			 {
			 	System.out.println("No customer with user name " + customerName);
			 	return null;
			 }

	}

	public String getUserName()
	{
		return employeeName;
	}

	// set user name
	public void setUserName(String userName)
	{
		this.employeeName =  userName;
	}


	// get password
	public String getPassword()
	{
		return password;
	}

	// set password
	public void setPassword(String password)
	{
		this.password =  password;
	}

	// get accountType 1=checking 2=saving 3=joint account
	public int getaccessLevel()
	{
		return accessLevel;
	}

		// set accountType
	public void setaccessLevel(int access)
	{
		this.accessLevel =  access;
	}

	public void acceptApplicants(String customerName)
	{
		Customers c;
		if(!Database.customerVerify(customerName))
		{
			if(Database.appVerify(customerName))
			{
				c = Database.findApplicant(customerName);
				data.newCustomer(c);
				data.removeApplication(customerName);
			}
			else {
				System.out.println("Applicants don't exist");
				return;
			}
		}
		else {
			System.out.println("Applicant is already a customer name");
		}
	}

	public void denyApplicants(String customerName)
	{
		if(Database.appVerify(customerName))
		{
			data.removeApplication(customerName);
		}
		else {
			System.out.println("Applicant user name doesn't exist");
		}
	}

	public void printCustomer() // Print employees data

	{
		System.out.println("Username= " + this.employeeName + " Password= "+ this.password + " Account Type= " + this.accessLevel);
	}




}

 */