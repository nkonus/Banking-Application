package CST_105;


import java.util.Scanner;

public class Bank {

	
	
	
	static Customer c = new Customer();
	
public static void main(String[] args) {
	
		c.saving.setAnnualInterestRate(.06);
		c.saving.setMinBalance(200.00);
		c.checking.setOverdraft(45.00);
		c.displayMenu(c.checking, c.saving);
		
		
	}
//	//Constructor
//	public Bank (String name) {
//		this.name = name;
//	}
//	
	}
	
	