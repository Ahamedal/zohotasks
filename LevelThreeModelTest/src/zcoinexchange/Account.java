package zcoinexchange;

public class Account {

	private int ZID;
	private String userId;
	private int RCWallet;
	private int ZCWallet=4;
	public int getZID() {
		return ZID;
	}
	public void setZID(int zID) {
		ZID = zID;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRCWallet() {
		return RCWallet;
	}
	public void setRCWallet(int rCWallet) {
		RCWallet = rCWallet;
	}
	public int getZCWallet() {
		return ZCWallet;
	}
	public void setZCWallet(int zCWallet) {
		ZCWallet = zCWallet;
	}
	
	
	
}
