package passengers;

public class Passenger {

private String passengerName;
private int age;
private String gender;
private String berthPreference;
private String berthType;
private String seatNo;

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
public String getSeatNo() {
	return seatNo;
}
public void setSeatNo(String seatNo) {
	this.seatNo = seatNo;
}
@Override
public String toString() {
	return "[passengerName=" + passengerName + ", age=" + age + ", gender=" + gender + 
			", berthType=" + berthType + ", seatNo=" + seatNo + "]";
}

}
