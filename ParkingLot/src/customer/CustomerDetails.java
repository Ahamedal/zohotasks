package customer;

public class CustomerDetails {
   private int tokenId;
   private int customerID;
   private String usName;
   private long mobileNumber;
   private String vehicleType;
   private int vehicleNo;
   private double walletAmmount;
public int getTokenId() {
	return tokenId;
}
public void setTokenId(int tokenId) {
	this.tokenId = tokenId;
}

public int getCustomerID() {
	return customerID;
}
public void setCustomerID(int customerID) {
	this.customerID = customerID;
}
public String getUsName() {
	return usName;
}
public void setUsName(String usName) {
	this.usName = usName;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public int getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(int vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public double getWalletAmmount() {
	return walletAmmount;
}
public void setWalletAmmount(double walletAmmount) {
	this.walletAmmount = walletAmmount;
}
@Override
public String toString() {
	return " [tokenId=" + tokenId + ", customerID=" + customerID + ", usName=" + usName
			+ ", mobileNumber=" + mobileNumber + ", vehicleType=" + vehicleType + ", vehicleNo=" + vehicleNo
			+ ", walletAmmount=" + walletAmmount + "]";
}
  
}
