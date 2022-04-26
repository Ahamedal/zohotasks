package token;

public class Token {
private int floorNo;
private String vehicleType;
private int vehicleNumber;
private long entryTime;
private boolean paymentStatus=false;
private int tokenNumber;

public int getFloorNo() {
	return floorNo;
}
public void setFloorNo(int floorNo) {
	this.floorNo = floorNo;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public int getVehicleNumber() {
	return vehicleNumber;
}
public void setVehicleNumber(int vehicleNumber) {
	this.vehicleNumber = vehicleNumber;
}

public long getEntryTime() {
	return entryTime;
}
public void setEntryTime(long entryTime) {
	this.entryTime = entryTime;
}


public boolean isPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(boolean paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public int getTokenNumber() {
	return tokenNumber;
}
public void setTokenNumber(int tokenNumber) {
	this.tokenNumber = tokenNumber;
}
@Override
public String toString() {
	return "Token [floorNo=" + floorNo + ", vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber
			+ ", entryTime=" + entryTime + ", paymentStatus=" + paymentStatus + ", tokenNumber=" + tokenNumber + "]";
}



}
