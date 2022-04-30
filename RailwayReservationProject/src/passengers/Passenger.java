package passengers;

public class Passenger {

private int ticketNo;
private String passengerName;
private int age;
private String gender;
private String berthPreference;
private String berthType;
private int seatNo;
private String status;
public int getTicketNo() {
	return ticketNo;
}
public void setTicketNo(int ticketNo) {
	this.ticketNo = ticketNo;
}
public String getPassengerName() {
	return passengerName;
}
public void setPassengerName(String passengerName) {
	this.passengerName = passengerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBerthPreference() {
	return berthPreference;
}
public void setBerthPreference(String berthPreference) {
	this.berthPreference = berthPreference;
}
public String getBerthType() {
	return berthType;
}
public void setBerthType(String berthType) {
	this.berthType = berthType;
}
public int getSeatNo() {
	return seatNo;
}
public void setSeatNo(int seatNo) {
	this.seatNo = seatNo;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "[passengerName=" + passengerName + ", age=" + age + ", gender=" + gender + 
			", berthType=" + berthType + ", seatNo=" + seatNo + ", Status=" + status+"]";
}

}
