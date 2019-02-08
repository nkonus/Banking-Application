package CST_105.WEEK4;

public class Checking extends Account {

	private double overdraft;
	
	
	
	
	
	
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
	public Checking (double balance, String account) {
		this.setBalance (balance);
		this.setAccount(account);
		
	}

	
}
