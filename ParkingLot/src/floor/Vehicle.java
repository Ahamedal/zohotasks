package floor;

public class Vehicle {
private String vehicleType;
private int vehicleNumber;
private String entryTime;
private boolean paymentType=false;
private int tokenNumber;
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
public String getEntryTime() {
	return entryTime;
}
public void setEntryTime(String entryTime) {
	this.entryTime = entryTime;
}
public boolean isPaymentType() {
	return paymentType;
}
public void setPaymentType(boolean paymentType) {
	this.paymentType = paymentType;
}
public int getTokenNumber() {
	return tokenNumber;
}
public void setTokenNumber(int tokenNumber) {
	this.tokenNumber = tokenNumber;
}



}
