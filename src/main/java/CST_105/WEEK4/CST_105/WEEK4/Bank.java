package CST_105.WEEK4;

import java.util.Date;
import java.util.Scanner;

public class Bank {

	Scanner sc = new Scanner(System.in); 
	private String name;
	
	static Bank bankObject = new Bank("GCU Credit Union");
	Checking checkingObject = new Checking(5000.00, "991773");
	Saving savingObject = new Saving (5000.00, "191923");
	Customer customerObject = new Customer();
	
public static void main(String[] args) {
		
		Checking checking = new Checking(5000.00, "991773");
		Saving saving = new Saving (5000.00, "991773");
		saving.setServiceFee(25.00);
		saving.setAnnualInterestRate(.06);
		saving.setMinBalance(200.00);
		checking.setOverdraft(45.00);
		bankObject.displayMenu(checking, saving);
		
	}
	//Constructor
	public Bank (String name) {
		this.name = name;
	}
	
	private void displayMenu(Checking checking, Saving saving) {
		int option;
		do {
		
	System.out.println("   					                    " );
	System.out.println("============================================");
	System.out.println("		MAIN MENU 				");
	System.out.println("	  " + this.name.toUpperCase());
	System.out.println("	  " + customerObject.getCustomerInfo());
	System.out.println(" Pick an option ");
	System.out.println("--------------------------------------------");
	System.out.println("1: Deposit to Checking");
	System.out.println("2: Deposit to Savings");
	System.out.println("3: Write a Check");
	System.out.println("4: Withdraw from Saving");
	System.out.println("5: Get Balance");
	System.out.println("6: Close month");
	System.out.println("--------------------------------------------");
	System.out.println("9:: Exit");
	
	bankObject.displayDateAndTime();
	option = sc.nextInt();
	this.doAction (option, checking, saving);
		}
		while (option != 9);
		
	}
	
	public void doAction (int option, Checking checking, Saving saving) {
		
		 
        // switch statement with int data type 
        switch (option) { 
        case 1: 
             bankObject.displayDepositChecking(checking); 
         
            break; 
        case 2: 
             bankObject.displayDepositSaving(saving);
           
            break; 
        case 3: 
        	bankObject.displayWithdrawChecking(checking);
           
            break; 
        case 4: 
            bankObject.displayWithdrawSaving(saving); 
            break; 
        case 5: 
        	bankObject.displayBalanceScreen(checking, saving);
            break; 
        case 6: 
            bankObject.doEndMonth(checking, saving);; 
            break; 
  
        case 7: 
            bankObject.displayExitScreen();
            System.out.println("You have exited!");
            break; 
        default: 
            System.out.println("Invalid "); 
            
        } 
    	
    }
		

	
	
		private void doEndMonth (Checking checking, Saving saving ) {
		
			
			System.out.println("Calculate end of month items.");
			System.out.println("Your Checking balance is $" + checking.getBalance());
	
			if (saving.getBalance() < saving.getMinBalance()) {
				System.out.println("Your account is below the minimum balance of $200" );
				saving.setBalance(saving.getBalance()- saving.getServiceFee());
				
				System.out.println("$25 Service fee added if balance is below $200" + (saving.getBalance()));
			}
		        
	        else
	        	
	        	System.out.println("Your Saving balance is $" + (saving.getBalance()));
				System.out.println("You earned $" + (saving.balance) * (saving.getAnnualInterestRate() / 12) + " interest in your saving account!");
				saving.setBalance( saving.balance + (saving.balance) * (saving.getAnnualInterestRate()) / 12);
				System.out.println("Your total saving balance is $" + saving.getBalance());
			
				
	 		  
	 		  }
			

	
		private void displayExitScreen() {
			System.out.println("displayExitScreen");
			}
	
		
		
	private void displayBalanceScreen (Checking checking, Saving saving) {
		
		
		System.out.println("Your Saving balance is $" + saving.getBalance());
		
		System.out.println("Your Checking balance is $" + checking.getBalance());
		 
			

			
		
		
		
	}
	
	private void displayWithdrawSaving (Saving saving) {
		
		 System.out.println("Your current saving balance is $" + saving.getBalance());
		 
		 System.out.println("Enter amount you would like to withdraw: ");
		 int withdrawAmount = sc.nextInt();
		

			if (withdrawAmount > 0.0)
		        if (withdrawAmount > saving.getBalance())
		            System.out.println("Withdrawal amount exceeded the account balance." );
						
			
		        else
		        	saving.setBalance(saving.getBalance() - withdrawAmount);	
	}
	
	
	private void displayWithdrawChecking (Checking checking) {
		
		
		System.out.println("Your current checking balance is $" + checking.getBalance());
		 
		 System.out.println("Enter amount you would like to withdraw ");
		 int withdrawAmount = sc.nextInt();
			if (withdrawAmount > 0.0 && withdrawAmount > checking.getBalance() ) {
		        
		            System.out.println("Withdrawal amount exceeded account balance. If you continue $45 overdraft fee will be charged. Press 1 to continue.\"");
					Scanner in = new Scanner (System.in);
					int custChoice = in.nextInt();
			
			if (withdrawAmount > checking.getBalance() && custChoice ==1) 
				
		        	 checking.setBalance (checking.balance -= withdrawAmount += checking.getOverdraft());
		        	 System.out.println("Your balance is $ " + checking.getBalance());
			}
		        else 
			System.out.println("Your new balance is: $" +(checking.balance -= withdrawAmount));
			}
	
	private void displayDepositSaving (Saving saving) {
		System.out.println("displayDepositSaving");
		System.out.println(saving.getBalance());
		System.out.println("Enter amount you would like to deposit into saving: ");
		 	int depositAmount = sc.nextInt();
		    
		 	if (depositAmount >= 0.00) {
		 	
		 		System.out.println ("Your new balance is: $" + (saving.balance += depositAmount));
		 		
		 	}
		        	
		
		
	
	}
	private void displayDepositChecking (Checking checking) {
		   
			System.out.println(checking.getBalance());
			System.out.println("Enter amount you would like to deposit into checking: ");
			 	int depositAmount = sc.nextInt();
			    
			 	if (depositAmount >= 0.00) {
			 	
			 		System.out.println ("Your new balance is: $" + (checking.balance += depositAmount));
			 	}
			        	
			
	
	}
	
	 
	 public void displayDateAndTime (){
	      // Instantiate a Date object
	      Date date = new Date();

	      // display time and date using toString()
	      System.out.println(date.toString());
	   }
	 
	 
	 
	 
	 
	}
	
	