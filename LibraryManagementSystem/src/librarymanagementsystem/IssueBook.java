package librarymanagementsystem;

public class IssueBook {
 private String memberId;
 private int uniqueIdNumber;
 private String issueDate;
 private String dueDate;
 private String dayElapse;
 private double fineAmount;
public String getMemberId() {
	return memberId;
}
public void setMemberId(String memberId) {
	this.memberId = memberId;
}
public int getUniqueIdNumber() {
	return uniqueIdNumber;
}
public void setUniqueIdNumber(int uniqueIdNumber) {
	this.uniqueIdNumber = uniqueIdNumber;
}

public String getIssueDate() {
	return issueDate;
}
public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}
public String getDueDate() {
	return dueDate;
}
public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}
public String getDayElapse() {
	return dayElapse;
}
public void setDayElapse(String dayElapse) {
	this.dayElapse = dayElapse;
}
public double getFineAmount() {
	return fineAmount;
}
public void setFineAmount(double fineAmount) {
	this.fineAmount = fineAmount;
}
 
 
}
