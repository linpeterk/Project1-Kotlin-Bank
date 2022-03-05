class Customers(var userName:String="Default", var password:String="Default", var accountType:Int=0,
    var balance:Double=0.0) : Person{

    val transHistory:MutableList<String> = mutableListOf()
    //deposit = 1, withdraw = 2, transfer = 3

    fun printHistory()
    {
        var type:String =""
        var rest:String =""

            println("------------TRANSACTIO HISTORY ------------")
        for( history in transHistory)
        {
            type = history.substring(0, 1)
            rest = history.substring(1, history.length)
            when(type)
            {
                "1"-> println("Deposit: $rest")
                "2"-> println("Withdraw: $rest")
                "3"-> println("Transfer: $rest")
            }
        }
    }

    fun printCustomer()
    {
        println("User name= $userName | Password= $password | Account Type= $accountType | Balance= $balance")
    }
/*
    public void printCustomer()
    {
        String temp = "";
        switch(accountType)
        {
            case 1: temp= "Checking";break;
            case 2: temp= "Savings";break;
            case 3: temp= "Joint";break;
            default: temp= "Checking";
        }
        System.out.println("Usernam

    */
}

/*

public class Customers implements Person, java.io.Serializable{

	//print transhistory
	public void printHistory()
	{
		System.out.println("============= TransAction History ==================");

		for(String a:tranHistory)
		{
			String type = a.substring(0, 1); //type of transaction
			String rest = a.substring(1, a.length()-2); //Rest of stuff
			if(type.equals("1")) //deposit
			{
				System.out.println("Deposit: "+ rest);

			}
			else if(type.equals("2")) //withdraw
			{
				System.out.println("Withdraw: "+ rest);
			}
			else if(type.equals("3")) //transfer
			{
				System.out.println("Transfer: "+ rest);
			}

		}
		System.out.println("\"============= TransAction History ==================\"");
	}
	// get user name
	public String getUserName()
	{
		return userName;
	}

	// set user name
	public void setUserName(String userName)
	{
		this.userName =  userName;
	}

	public double getBalance()
	{
		return balance;
	}

	// set user name
	public void setBalance(Double balance)
	{
		this.balance =  balance;
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
	public int getAccountType()
	{
		return accountType;
	}

		// set accountType
	public void setAccountType(int accountType)
	{
		this.accountType =  accountType;
	}

	public void printCustomer()
	{
		String temp = "";
		switch(accountType)
		{
		case 1: temp= "Checking";break;
		case 2: temp= "Savings";break;
		case 3: temp= "Joint";break;
		default: temp= "Checking";
		}
		System.out.println("Username= " + userName + " Password= "+ password + " Account Type= " + temp + " balance= " + balance);
	}
}

 */