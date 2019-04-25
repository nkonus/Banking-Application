package CST_105;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Loan extends Account{

	
List<Transaction> transLoan = new ArrayList<Transaction>();
	
    public void addTransaction(double amount, String type) {
    	//transLoan.add(new Transaction(this.getAccount(),amount, LocalDate.now(),type ));
    	
    }
    public void displayTransaction() {
        for(Transaction t : transLoan) {
            System.out.println(t.toString());
      }
    }
	
	
		
		private double interestRate= 4.5;
		private double lateFee = 50;
		private double balance = -5000;
		private int payment;
		


		public Loan (double reqAmount, String account){
			this.setBalance(reqAmount);
			this.setAccount(account);
	}
	
		public void doEndOfMonthInterest() {
			System.out.println("You made a payment of " + payment + " to your loan balance.");
			for(Transaction t : transLoan) {
	            System.out.println(t.toString());
			}
		}
public void payLoan() {
	
	Scanner sc = new Scanner(System.in);
	
	 System.out.println("Your current loan balance is $" + getBalance());
	 
	 System.out.println("Enter amount you would like to pay: ");
	 payment = sc.nextInt();
	 		if (payment > 1) {
	        	setBalance(getBalance() + payment);	
	        	addTransaction(payment,"Payment");
	        	transLoan.add(new Transaction (LocalDate.now(), getAccount(),payment, "Payment"));
}


	//System.out.println("Calculate end of month Loan items.");
	
        if (payment >= 1.00 && payment <= balance) {
            balance = balance - payment;
            System.out.println("Remaining loan balance is : " + balance);
        }
        else if (payment <= 1) {
		System.out.println("Late fee is charged" );
		setBalance(getBalance()- getLateFee());
		
		System.out.println("$50 late fee added" + (getBalance()));
	}
        
    else {
    	
    	System.out.println("Your Loan Balance is $" + (getBalance()));
		  }
        displayTransaction();
        }




public double getInterestRate() {
	return interestRate;
}

public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}

public double getLateFee() {
	return lateFee;
}

public void setLateFee(double lateFee) {
	this.lateFee = lateFee;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
public int getPayment() {
	return payment;
}



public void setPayment(int payment) {
	this.payment = payment;
}




}
