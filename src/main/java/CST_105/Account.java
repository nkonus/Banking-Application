package CST_105;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account implements iTrans {

	double balance;
	private String account;
	
	Transaction t = new Transaction();

		public double getBalance() {
			return balance;
		}
	
		public void setBalance(double balance) {
			this.balance = balance;
		}
	
		public String getAccount() {
			return account;
		}
	
		public void setAccount(String account) {
			this.account = account;
		}

	

	
	public double doWithdraw (double amount) {
		
		double withdrawAmount = 0;
		if (withdrawAmount > 0.0)
	        if (withdrawAmount > getBalance())
	            System.out.println("Withdrawal amount exceeded account balance. Press any key to continue.");
	        else
	            setBalance(getBalance() - withdrawAmount);
		
		return amount;
		
		
		
		
	}
	
	public double doDeposit(double amount) {
		return amount;
		
	}

	public void displayTransaction() {
		// TODO Auto-generated method stub
		
	}

	public void addTransaction(double amount, String type) {
		// TODO Auto-generated method stub
		
	}

}

