package virtualclassroom;

public class User {
 private String name;
 private int age;
 private String genter;
 private String emailId;
 private long mobileNo;
 private String userTyp;
 private int userId;
 private String password;
 private boolean pending=true;
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
public String getGenter() {
	return genter;
}
public void setGenter(String genter) {
	this.genter = genter;
}
public String getUserTyp() {
	return userTyp;
}
public void setUserTyp(String userTyp) {
	this.userTyp = userTyp;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isPending() {
	return pending;
}
public void setPending(boolean pending) {
	this.pending = pending;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
@Override
public String toString() {
	return "[name=" + name + "\nage=" + age + "\ngenter=" + genter + "\nemailId=" + emailId + "\nmobileNo="
			+ mobileNo + "]";
}
 
}
