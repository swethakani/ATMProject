package atmPackage;

import java.util.HashMap;
import java.util.Map;

public class AtmImplement {
	ATM atm=new ATM();
	//amount and the message
	Map<Double,String> m=new HashMap<>();
	public void viewBalance() {
		System.out.println("Your Available Balance is : "+atm.getBalance());
	}
	
	public void withdrawAmount(double withdrawAmt) {
		if(withdrawAmt%500==0) {
			if(withdrawAmt<=atm.getBalance()) {
				m.put(withdrawAmt," Amount Withdrawn.");
				System.out.println("Collect ur cash : "+withdrawAmt);
				atm.setBalance(atm.getBalance()-withdrawAmt);
				viewBalance();
			}
			else {
				System.out.println("Insufficient Balance!!");
			}
		}
		else {
			System.out.println("Please,, Enter the amount in the multiples of 500");
		}
	}
	
	public void depositAmount(double depositAmt) {
		m.put(depositAmt," Amount Deposited.");
		System.out.println("You have successfully desposited the "+depositAmt+" Amount!");
		atm.setBalance(atm.getBalance()+depositAmt);
		viewBalance();
	}
	
	public void viewMiniStatement() {
		for(Map.Entry<Double,String> x:m.entrySet()) {
			System.out.println(x.getKey()+""+x.getValue());
		}
	}
}
