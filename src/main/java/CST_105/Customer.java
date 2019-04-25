package CST_105;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;





public class Customer {
	

static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
static final String ENDPOINT ="cst235konus.cgbyczvwvuv3.us-east-2.rds.amazonaws.com";
static final String PORT ="3306";
static final String USER ="cst235konus";
static final String PASS ="Narkoncan2831";

static Connection conn;
static Scanner sc = new Scanner (System.in);
int option;


public static Connection getConnection() {
	try {
		Class.forName(JDBC_DRIVER);
		String dbName = "innodb";
		
		String jdbcConnect = "jdbc:mysql://" + ENDPOINT + ":" + PORT+ "/"+ dbName + "?user=" + USER + "&password=" + PASS;
		//System.out.println(jdbcConnect);
		conn = DriverManager.getConnection(jdbcConnect);
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	finally {
		//System.out.println("I got connected");
	}
	return conn;
}

	
	//-------------------------------------------
	
	 
	private static String name;
	
	Bank bankObject = new Bank();
	public Checking checking = new Checking(2500.00, "991773", "");
	public Saving saving = new Saving (500.00, "991723");
	Loan loan = new Loan (-5000, "991753");
	
	
	private String customerInfo = "";
	private String firstName;
	private String lastName;
	private String date;
	
	
	
	
	
	public void customerLoginCheck() {
		getConnection();
		Statement sqlText = null;
		String uname;
		String pass;
	
		try {
			System.out.println("Enter username: ");
			uname = sc.nextLine();
			
			System.out.println("Enter password: ");
			pass = sc.nextLine();
			
			sqlText = conn.createStatement();
			String sql = "SELECT id FROM innodb.banking_login WHERE user_name = \""+uname+"\" AND password= \""+pass+"\"";
			//System.out.println(sql);
			ResultSet results = sqlText.executeQuery(sql);
			
			if (results.next()) {
				
				System.out.println("access granted" );
				customerMenu(checking, saving);
				results.close();
			}
			else {
				System.out.println("Wrong username / password" );
			customerLoginCheck();
			}
				

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Wrong username / password" );
			customerLoginCheck();
		}
		
	}

	public void adminLoginCheck() {
		getConnection();
		Statement sqlText = null;
		String uname;
		String pass;
		
		try {
			System.out.println("Enter username: ");
			uname = sc.nextLine();
	
			System.out.println("Enter password: ");
			pass = sc.nextLine();
			
			sqlText = conn.createStatement();
			String sql = "SELECT id FROM innodb.banking_login WHERE user_name = \""+uname+"\" AND password= \""+pass+"\"";
			//System.out.println(sql);
			ResultSet results = sqlText.executeQuery(sql);
			
			if (results.next()) {
				
				System.out.println("access granted" );
				employeeMenu(checking, saving);
				results.close();
			}
			else {
				System.out.println("Wrong username / password" );
			adminLoginCheck();
			}
				

		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Wrong username / password" );
			adminLoginCheck();
		}
	}
	
	
	
	public void createAnAccount() {
		getConnection();
		String uName;
		String pass;
		
		String sql = "INSERT INTO innodb.banking_login VALUES (Default, ?,?)";
		System.out.println("Create username: ");
		Scanner sc = new Scanner(System.in);
		uName = sc.nextLine();
		
		System.out.println("Create password: ");
		Scanner sc1 = new Scanner(System.in);
		pass = sc1.nextLine();
	
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, uName);
			stmt.setString(2, pass);
			
			stmt.executeUpdate();
		}catch (SQLException e) {
	System.out.println(e.getMessage());
	}
		
		customerMenu(checking, saving);
	}	
		
	public void createSavingsAccount() {
		String uniqueID = UUID.randomUUID().toString();
		uniqueID = uniqueID.substring(24);
		getConnection();
		
	String sql = "INSERT INTO innodb.BankingCustomer VALUES (?,?,?,?)";
	System.out.println("First name: ");
	Scanner sc3 = new Scanner(System.in);
	firstName = sc3.nextLine();
	
	System.out.println("Last name: ");
	Scanner sc1 = new Scanner(System.in);
	lastName = sc1.nextLine();
	
	System.out.println("Date opened: ");
	Scanner sc2 = new Scanner(System.in);
	date = sc2.nextLine();
	
	
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, uniqueID);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		stmt.setString(4, date);
		
		stmt.executeUpdate();
	}catch (SQLException e) {
System.out.println(e.getMessage());
}
	System.out.println(firstName +" "+ lastName+ " "+ "\n Saving Account ID : "+uniqueID );
	employeeMenu(checking, saving);
}	
	

	
	public void createCheckingAccount() {
		String uniqueID = UUID.randomUUID().toString();
		uniqueID = uniqueID.substring(24);

		System.out.println(firstName + lastName+ "\nChecking Account ID : " + uniqueID );
		employeeMenu(checking, saving);
	}
	
	public void createLoanAccount() {
		String uniqueID = UUID.randomUUID().toString();
		uniqueID = uniqueID.substring(24);
		System.out.println(firstName + lastName+ "\nLoan Account ID : " + uniqueID );
		employeeMenu(checking, saving);
	}
	
	
public void displayMenu(Checking checking, Saving saving) {
		
	try {
		System.out.println("   					            " );
		System.out.println("=================================");
		System.out.println("		MAIN MENU 				");
		System.out.println("=================================");
		System.out.println("1: Customer Login / Create an account");
		System.out.println("2: Admin Login");
		System.out.println("3: Exit Bank");
		
		
        	int option;
        	option = sc.nextInt();
        	 sc.nextLine()  ;  
        	 if (option == 1) {
        	System.out.println("Press 1 to Log-in, 0 to create an acccount"  );
        		option = sc.nextInt();
        		sc.nextLine();
        	 }
        	    if (option == 0) {createAnAccount();} 
        		if (option == 1) {customerLoginCheck();}
        	else if (option == 2) {adminLoginCheck();}
        	else if (option == 3) {System.out.println("You have exited");}
        	else { 
            System.out.println("Invalid "); 
            
        	}
        	 
			}catch(Exception e) {
        	
        		System.out.println("Incorrect Entry" );
        		sc.nextLine();
        		displayMenu(checking, saving);
        }
	
}
	

	public void customerMenu(Checking checking, Saving saving) {
		try {
		int option;
		do {
		
	System.out.println("   					                    " );
	System.out.println("============================================");
	System.out.println("	CUSTOMER MAIN MENU 				");
	System.out.println("	  " + customerInfo.toUpperCase());
	//System.out.println("	  " + getCustomerInfo());
	System.out.println(" Pick an option ");
	System.out.println("--------------------------------------------");
	System.out.println("1: Deposit to Checking");
	System.out.println("2: Deposit to Savings");
	System.out.println("3: Write a Check");
	System.out.println("4: Withdraw from Saving");
	System.out.println("5: Get Balance");
	System.out.println("6: Close month");
	System.out.println("7: Make Loan Payment");
	System.out.println("8: Display All Transactions");
	System.out.println("--------------------------------------------");
	System.out.println("0: Exit");
	
	displayDateAndTime();
	option = sc.nextInt();
	this.doAction (option, checking, saving);
		}
		while (option != 0);
		}
		catch (Exception e) {
		System.out.println("Incorrect Entry" );
		sc.nextLine();
		customerMenu( checking, saving);
	}}
	
	
	public void doAction (int option, Checking checking, Saving saving) {
		
		 
        // switch statement with int data type 
        switch (option) { 
        case 1: 
             displayDepositChecking(checking); 
         
            break; 
        case 2: 
             displayDepositSaving(saving);
           
            break; 
        case 3: 
        	displayWithdrawChecking(checking);
           
            break; 
        case 4: 
        	displayWithdrawSaving(saving); 
            break; 
        case 5: 
        	displayBalanceScreen(checking, saving);
            break; 
        case 6: 
            doEndMonth(checking, saving);; 
            break; 
        case 7: 
            loan.payLoan();
            break;
        case 8: 
            displayAllTransactions();
            break;
        case 9: 
            displayExitScreen();
            System.out.println("You have exited!");
            break; 
        default: 
            System.out.println("Invalid "); 
            
        } 
    	
    }
		
	
	public void employeeMenu(Checking checking, Saving saving) {
		try {
		int option;
		
		
	System.out.println("   					            " );
	System.out.println("=================================");
	System.out.println("	   ADMIN MAIN MENU 			 ");
	System.out.println("=================================");
	System.out.println(" Pick an option ");System.out.println("1: Create a saving account");
	System.out.println("2: Create a checking account");
	System.out.println("3: Create a loan account");
	System.out.println("4: Display all costumers");
	System.out.println("5: Return to main menu");
	System.out.println("9: Exit Bank");
	
	displayDateAndTime();
	option = sc.nextInt();
	this.action (option, checking, saving);
		} catch (Exception e) {
			System.out.println("Incorrect Entry" );
			sc.nextLine();
			employeeMenu(checking, saving);
		}
	}
	
	public void action (int option, Checking checking, Saving saving) {
	
//        	System.out.println("Press 1 to create savings account\nPress 2 to create checking account\nPress 3 to create loan account \n ");
//        	 option = sc.nextInt();
//        	
        	 
             	
            	if (option == 1) {createSavingsAccount();}
            	else if (option == 2) {createCheckingAccount();}
            	else if (option == 3) {createLoanAccount();}
            	else if (option == 4) { pickACustomer();}
                
            	else if (option == 5) {displayMenu(checking, saving);}
                   
            	else if (option == 9) { displayExitScreen();
                System.out.println("You have exited!");}
               
                else {
                System.out.println("Invalid "); 
                action (option, checking, saving);
	}}
            
            
       
		

	
	
	private void pickACustomer() {
		getConnection();
		System.out.println("DISPLAYING LIST OF CUSTOMERS");
		
		Statement sqlText = null;
	
		try {
			
			sqlText = conn.createStatement();
			String sql = "SELECT * FROM innodb.BankingCustomer;";
			//System.out.println(sql);
			ResultSet results = sqlText.executeQuery(sql);
		
			while (results.next()) {
				System.out.println(results.getString("acocuntNumber") + " / "+ results.getString("name")+ " / "+ results.getString("lastname")+ " / "+ results.getString("dateopened"));
			}
				results.close();
				

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		employeeMenu(checking, saving);
	}
		
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOpened() {
		return date;
	}

	public void setDateOpened(String dateOpened) {
		this.date = date;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
	
	
	
	public void doEndMonth (Checking checking, Saving saving ) {
		
		
		//System.out.println("Calculate end of month items.");
		loan.doEndOfMonthInterest();
		System.out.println("Your Checking Balance is $" + checking.getBalance());
		
		

		if (saving.getBalance() < saving.getMinBalance()) {
			System.out.println("Your account is below the minimum balance of $200" );
			saving.setBalance(saving.getBalance()- saving.getServiceFee());
			
			System.out.println("$25 Service fee added if balance is below $200" + (saving.getBalance()));
			
		}
	        
        else
        	
        	System.out.println("Your Saving Balance is $" + (saving.getBalance()));
			System.out.println("You earned $" + (saving.balance) * (saving.getAnnualInterestRate() / 12) + " interest in your saving account!");
			saving.setBalance( saving.balance + (saving.balance) * (saving.getAnnualInterestRate()) / 12);
			System.out.println("Your total saving balance is $" + saving.getBalance());
		
			
 		  
 		  }
		


	public void displayExitScreen() {
		System.out.println("displayExitScreen");
		}
	public void displayBalanceScreen(Checking checking, Saving saving ) {
		System.out.println("Your Saving balance is $" + saving.getBalance());
		System.out.println("Your Checking balance is $" + checking.getBalance());
	}
	
	
	public void displaySavingBalance(Saving saving) {
	System.out.println("Your Saving balance is $" + saving.getBalance());
	}
	
	public void displayCheckingBalance (Checking checking) {
	System.out.println("Your Checking balance is $" + checking.getBalance());
}

public void displayWithdrawSaving (Saving saving) {
	
	 System.out.println("Your current saving balance is $" + saving.getBalance());
	 try {
	 System.out.println("Enter amount you would like to withdraw: ");
	 
	 int withdrawAmount = sc.nextInt();
	

		if (withdrawAmount > 0.0)
	        if (withdrawAmount > saving.getBalance())
	            System.out.println("Withdrawal amount exceeded the account balance." );
					
		
	        else
	        	saving.setBalance(saving.getBalance() - withdrawAmount);
		saving.transSaving.add(new Transaction (LocalDate.now(),saving.getAccount(),withdrawAmount, "Withdraw from Saving"));
}catch (Exception e) {
	System.out.println("Incorrect Entry" );
	sc.nextLine();
	customerMenu(checking, saving);
}}


public void displayWithdrawChecking (Checking checking) {
	
	
	System.out.println("Your current checking balance is $" + checking.getBalance());
	 try {
	 System.out.println("Enter amount you would like to withdraw ");
	 int withdrawAmount = sc.nextInt();
		if (withdrawAmount > 0.0 && withdrawAmount > checking.getBalance() ) {
	        
	            System.out.println("Withdrawal amount exceeded account balance. If you continue $45 overdraft fee will be charged. Press 1 to continue.\"");
				Scanner in = new Scanner (System.in);
				int custChoice = in.nextInt();
		
		if (withdrawAmount > checking.getBalance() && custChoice ==1) 
			
	        	 checking.setBalance (checking.balance -= withdrawAmount += checking.getOverdraft());
	        	 System.out.println("Your balance is $ " + checking.getBalance());
	        	 checking.transChecking.add(new Transaction (LocalDate.now(),checking.getAccount(),withdrawAmount, "Overdraft fee"));
		}
	        else 
		System.out.println("Your new balance is: $" +(checking.balance -= withdrawAmount));
		checking.transChecking.add(new Transaction (LocalDate.now(),checking.getAccount(),withdrawAmount, "Withdraw from Checking"));
		}catch(Exception e) {
			System.out.println("Incorrect Entry");
			sc.nextLine();
			customerMenu(checking, saving);
		}}

public void displayDepositSaving (Saving saving) {
	//System.out.println("displayDepositSaving");
	System.out.println("Your current saving balance is " + saving.getBalance());
	try {
	System.out.println("Enter amount you would like to deposit into saving: ");
	 	int depositAmount = sc.nextInt();
	    
	 	if (depositAmount >= 0.00) {
	 	
	 		System.out.println ("Your new balance is: $" + (saving.balance += depositAmount));
	 		saving.transSaving.add(new Transaction (LocalDate.now(),saving.getAccount(),depositAmount, "Deposit to Saving"));
	 	}}catch(Exception e) {
			System.out.println("Incorrect Entry");
			sc.nextLine();
			customerMenu(checking, saving);
	        	
	
	
	 	}
}
public void displayDepositChecking (Checking checking) {
	   
		System.out.println("Your current checking balance is "+checking.getBalance());
		try {
		System.out.println("Enter amount you would like to deposit into checking: ");
		 	int depositAmount = sc.nextInt();
		    
		 	if (depositAmount >= 0.00) {
		 	
		 		System.out.println ("Your new balance is: $" + (checking.balance += depositAmount));
		 		checking.transChecking.add(new Transaction (LocalDate.now(),checking.getAccount(),depositAmount, "Deposit to Checking"));
	
		 	}}catch(Exception e) {
				System.out.println("Incorrect Entry");
				sc.nextLine();
				customerMenu(checking, saving);
}
}
 
 public void displayDateAndTime (){
      // Instantiate a Date object
      Date date = new Date();

      // display time and date using toString()
      System.out.println(date.toString());
   }
 
	public void displayAllTransactions() {
		System.out.println("Displaying all transactions");
		checking.displayTransaction();
		saving.displayTransaction();
		loan.displayTransaction();
		
	}
	
	
	
}
