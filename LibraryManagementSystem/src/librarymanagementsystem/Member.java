package librarymanagementsystem;

public class Member {
 private String name;
 private String emailId;
 private long mobileNumber;
 private int noOfNonReturnedBooks;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public int getNoOfNonReturnedBooks() {
	return noOfNonReturnedBooks;
}
public void setNoOfNonReturnedBooks(int noOfNonReturnedBooks) {
	this.noOfNonReturnedBooks = noOfNonReturnedBooks;
}
 
}
