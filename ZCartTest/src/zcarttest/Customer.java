package zcarttest;

import java.util.HashMap;
import java.util.Map;

public class Customer {

	private String emailId;
	private String encryptedPassword;
	private String name;
	private long mobileNumber;
	private Map<Integer,OrderHistory> orders=new HashMap<>();
	private int purchaseNo;
	private Map<String,Coupen> coupen=new HashMap<>();
	
	
	public int getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Map<Integer, OrderHistory> getOrders() {
		return orders;
	}
	public void setOrders(Map<Integer, OrderHistory> orders) {
		this.orders = orders;
	}
	public Map<String, Coupen> getCoupen() {
		return coupen;
	}
	public void setCoupen(Map<String, Coupen> coupen) {
		this.coupen = coupen;
	}
	
	
	
}
