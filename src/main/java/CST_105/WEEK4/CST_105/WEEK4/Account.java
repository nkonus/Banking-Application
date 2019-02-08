package CST_105.WEEK4;

public class Account {

	double balance;
	private String account;
	
	
	
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
}

