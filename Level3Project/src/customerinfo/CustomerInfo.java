package customerinfo;

public class CustomerInfo {
   private int cusId;
   private String name;
   private int age;
   private long mobileNo;
   private String emailId;
   private String pWord;

public int getCusId() {
	return cusId;
}
public void setCusId(int cusId) {
	this.cusId = cusId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getpWord() {
	return pWord;
}
public void setpWord(String pWord) {
	this.pWord = pWord;
}
@Override
public String toString() {
	return "[cusId=" + cusId + ", name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + "]";
}
 
}
