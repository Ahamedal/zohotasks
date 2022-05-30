package zcoinexchange;

public class User {
 
	private String name;
	private String emailId;
	private int ZID;
	private long mobileNumber;
	private long H_ID;
	private String password;
	private int realCurrencyWalletAmount;
	
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
	
	public int getZID() {
		return ZID;
	}
	public void setZID(int zID) {
		ZID = zID;
	}
	public long getH_ID() {
		return H_ID;
	}
	public void setH_ID(long h_ID) {
		H_ID = h_ID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRealCurrencyWalletAmount() {
		return realCurrencyWalletAmount;
	}
	public void setRealCurrencyWalletAmount(int realCurrencyWalletAmount) {
		this.realCurrencyWalletAmount = realCurrencyWalletAmount;
	}
	
	@Override
	public String toString() {
		return " H_ID=" + H_ID+"\nname=" + name + "\nemailId=" + emailId + "\nmobileNumber=" + mobileNumber + 
				"";
	}
	
	
}
