package tollpayment;

public class Toll {
 private char tollName;
 private String vehicleType;
 private double amount;
 
 private double totalAmount;
public char getTollName() {
	return tollName;
}
public void setTollName(char tollName) {
	this.tollName = tollName;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}


 
}
