package tollpayment;

public class Vehicle {
 private String vehicleNo;
 private char startPosition;
 private char endingPosition;
 private int passedTolls;
 private double amountPerJourney;
 private double totalAmount;

public String getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public char getStartPosition() {
	return startPosition;
}
public void setStartPosition(char startPosition) {
	this.startPosition = startPosition;
}
public char getEndingPosition() {
	return endingPosition;
}
public void setEndingPosition(char endingPosition) {
	this.endingPosition = endingPosition;
}
public int getPassedTolls() {
	return passedTolls;
}
public void setPassedTolls(int passedTolls) {
	this.passedTolls = passedTolls;
}
public double getAmountPerJourney() {
	return amountPerJourney;
}
public void setAmountPerJourney(double amountPerJourney) {
	this.amountPerJourney = amountPerJourney;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
@Override
public String toString() {
	return "vehicleNo=" + vehicleNo + "\nstartPosition=" + startPosition + "\nendingPosition=" + endingPosition
			+ "\npassedTolls=" + passedTolls + "\namountPerJourney=" + amountPerJourney + 
			 "";
}

 
 
 
 
}
