package tollpayment;

public class Ticket {
 private int ticketNo;
 private String vehicleNo;
 private char tollName;
 private double amount;
 
public int getTicketNo() {
	return ticketNo;
}
public void setTicketNo(int ticketNo) {
	this.ticketNo = ticketNo;
}
public String getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public char getTollName() {
	return tollName;
}
public void setTollName(char tollName) {
	this.tollName = tollName;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "ticketNo=" + ticketNo + "\nvehicleNo=" + vehicleNo + "\ntollName=" + tollName + "\namount=" + amount
		    ;
}
 
}
