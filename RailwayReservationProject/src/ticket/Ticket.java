package ticket;

import java.util.Date;

public class Ticket {
	private String fromPlace;
	private String toPlace;
	private long departureTime;
	private long arrivalTime;
	private int noOfPassengers;
	private int ticketNumber;
	private String trainNumber="1A6666";
	private int amount;
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public long getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}
	public long getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	@Override
	
	public String toString() {
		Date dep=new Date(departureTime);
		Date arr=new Date( arrivalTime );
		return "[trainNumber="+ trainNumber +", fromPlace=" + fromPlace + ", toPlace=" + toPlace + ", departureTime=" + dep
				+ ", arrivalTime=" + arr+ ", noOfPassengers=" + noOfPassengers + 
				", Amount=" + amount + "]";
	}
	

}
