package atmPackage;

import java.util.Scanner;
import java.sql.*;

public class MainATM {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","KKSswetha@2003");
			Statement smt=con.createStatement();
			AtmImplement atmf=new AtmImplement();
//			int atmNo=12345;
//			int pinNo=3993;
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter the ATM number: ");
			int atm=sc.nextInt();
			System.out.print("Enter the PIN number: ");
			int pin=sc.nextInt();
			String name=null;
			int count=0;
			ResultSet rs=smt.executeQuery("select * from atmRecord where pinno="+pin);
			while(rs.next()) {
				name=rs.getString("name");
				count++;
			}
			if(count>0) {
				System.out.println("Welcome, "+name);
				int ch;
				do{
					System.out.println("1.View Available Balance\n2.Deposit the Amount\n3.Withdraw the Amount\n4.View the MiniStatement\n5.Exit");
					System.out.println();
					System.out.print("Enter ur choice: ");
					ch=sc.nextInt();
					switch(ch) {
					case 1:
						atmf.viewBalance();
						break;
					case 2:
						System.out.print("Enter the amount to deposit: ");
						double da=sc.nextDouble();
						atmf.depositAmount(da);
						break;
					case 3:
						System.out.print("Enter the amount to withdraw: ");
						double wa=sc.nextDouble();
						atmf.withdrawAmount(wa);
						break;
					case 4:
						atmf.viewMiniStatement();
						break;
					case 5:
						System.out.println("Please, Collect Your Card\nThank You for Visiting!!");
						break;
					default:
						System.out.println("Please, enter the valid choice....");
					}
				}while(ch<5);
			}
			else {
				System.out.println("Invalid ATM and PIN number!!!");
				System.exit(0);
			}
		}
		catch(Exception e) {
			System.out.println("Exception occured!!"+e);
		}
		
}
}
