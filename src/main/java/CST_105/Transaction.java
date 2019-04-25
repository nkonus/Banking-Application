package CST_105;

import java.time.LocalDate;
import java.util.Date;

public class Transaction{
	
	private Date transaction;
	private String accountName;
	private double amount;
	private String type;
	

	
	@Override
	public String toString() {
		return LocalDate.now() + " " + accountName +  " "+ amount + " "+ type;
	}

	
	
	

	public Date getTransaction() {
		return transaction;
	}


	public void setTransaction(Date transaction) {
		this.transaction = transaction;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	// Constructor
	
	public Transaction(LocalDate localDate, String accountName, double amount, String type ) {
		
		this.accountName = accountName;
		this.amount = amount;
		this.type = type;
		
		
	}

	public Transaction (){
	
}

	
	
	
	
}
