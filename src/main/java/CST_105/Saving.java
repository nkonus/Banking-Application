package CST_105;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Saving extends Account {
	
	private double serviceFee;
	private double annualInterestRate;
	private double minBalance;

//Customer c = new Customer();

		List<Transaction> transSaving = new ArrayList<Transaction>();
	
    public void addTransaction(double amount, String type) {
		
    }

 
    public void displayTransaction() {
        for(Transaction t : transSaving) {
            System.out.println(t.toString());
      }}
	
	
	
		public double getServiceFee() {
			return serviceFee;
		}
		public void setServiceFee(double serviceFee) {
			this.serviceFee = serviceFee;
		}
		public double getAnnualInterestRate() {
			return annualInterestRate;
		}
		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate;
		}
		public double getMinBalance() {
			return minBalance;
		}
		public void setMinBalance(double minBalance) {
			this.minBalance = minBalance;
			
		}
	
		// Constructor
				public Saving( double balance, String account) {
					this.setBalance (balance);
					this.setAccount(account);
					
			}

				public Saving (double reqAmount){
						
				}
				public Saving( double balance, String account, Date date, String type) {
					this.setBalance (balance);
					this.setAccount(account);
					t.setType(super.t.getType());
			}

				
				}