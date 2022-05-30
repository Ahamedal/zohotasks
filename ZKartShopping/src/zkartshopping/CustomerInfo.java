package zkartshopping;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
 private String emailId;
 private String encryptedPwd;
 private String name;
 private long mobileNo;
 private String discountNo;
 private int purchaseNo;
 private int nextTransaction;
 
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getEncryptedPwd() {
	return encryptedPwd;
}
public void setEncryptedPwd(String encryptedPwd) {
	this.encryptedPwd = encryptedPwd;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}

public String getDiscountNo() {
	return discountNo;
}
public void setDiscountNo(String discountNo) {
	this.discountNo = discountNo;
}
public int getPurchaseNo() {
	return purchaseNo;
}
public void setPurchaseNo(int purchaseNo) {
	this.purchaseNo = purchaseNo;
}

public int getNextTransaction() {
	return nextTransaction;
}
public void setNextTransaction(int nextTransaction) {
	this.nextTransaction = nextTransaction;
}
@Override
public String toString() {
	return "[emailId=" + emailId + ", encryptedPwd=" + encryptedPwd + ", name=" + name + ", mobileNo="
			+ mobileNo + "]";
}
 
}
