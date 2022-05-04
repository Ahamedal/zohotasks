package taxiHistory;

public class TaxiHistory {
 private int bookingId;
 private int customerId;
 private char pickUpPoint;
 private char dropPoint;
 private long pickUpTime;
public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public char getPickUpPoint() {
	return pickUpPoint;
}
public void setPickUpPoint(char pickUpPoint) {
	this.pickUpPoint = pickUpPoint;
}
public char getDropPoint() {
	return dropPoint;
}
public void setDropPoint(char dropPoint) {
	this.dropPoint = dropPoint;
}
public long getPickUpTime() {
	return pickUpTime;
}
public void setPickUpTime(long pickUpTime) {
	this.pickUpTime = pickUpTime;
}
@Override
public String toString() {
	return "[bookingId=" + bookingId + ", customerId=" + customerId + ", pickUpPoint=" + pickUpPoint
			+ ", dropPoint=" + dropPoint + ", pickUpTime=" + pickUpTime + "]";
}
 
 
}
