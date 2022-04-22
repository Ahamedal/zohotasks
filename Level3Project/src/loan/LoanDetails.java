package loan;

public class LoanDetails {
   private String address;
   private long aadhaarNumber;
   private String loanType;
   private double amount;
   private String status;
   private boolean isApproved=false;

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getAadhaarNumber() {
	return aadhaarNumber;
}
public void setAadhaarNumber(long aadhaarNumber) {
	this.aadhaarNumber = aadhaarNumber;
}
public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public boolean isApproved() {
	return isApproved;
}
public void setApproved(boolean isApproved) {
	this.isApproved = isApproved;
}
@Override
public String toString() {
	return "address=" + address + ", aadhaarNumber=" + aadhaarNumber + 
			", amount=" + amount + ", status="+status+", isApproved=" + isApproved + "]";
}
   
   
}
