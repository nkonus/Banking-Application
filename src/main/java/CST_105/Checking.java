package CST_105;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Checking extends Account {
	
	private double overdraft;

	
	
		List<Transaction> transChecking = new ArrayList<Transaction>();
	
		public void addTransaction(double amount, String type) {
			
			
			
	    }
	  
	    public void displayTransaction() {
	        for(Transaction t : transChecking) {
	            System.out.println(t.toString());
	      }
	    }
	
	
	
	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	

	public double doWithdraw (double amount) {
		
			return amount;
		}
		
		
	//Custructor
	public Checking (double balance, String account, String uniqueID) {
		this.setBalance (balance);
		this.setAccount(account);
			
	}


	
	
}
