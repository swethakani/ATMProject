package atmPackage;

public interface AtmOperation {
	public void viewBalance();
	public void withdrawAmount(double withdrawAmt);
	public void depositAmount(double depositAmt);
	public void viewMiniStatement();
}