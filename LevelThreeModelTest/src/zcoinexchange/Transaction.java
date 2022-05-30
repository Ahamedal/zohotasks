package zcoinexchange;

import java.util.Date;

public class Transaction {
   
	
	private String transactionType;
	private int amount;
	private int recentBalanceRC;
	private int recentBalenceZC;
	private long transactionTime;
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
		public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getRecentBalanceRC() {
		return recentBalanceRC;
	}
	public void setRecentBalanceRC(int recentBalance) {
		this.recentBalanceRC = recentBalance;
	}
	
	public int getRecentBalenceZC() {
		return recentBalenceZC;
	}
	public void setRecentBalenceZC(int recentBalenceZC) {
		this.recentBalenceZC = recentBalenceZC;
	}
	public long getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(long transactionTime) {
		this.transactionTime = transactionTime;
	}
	@Override
	public String toString() {
		Date dat=new Date(transactionTime);
		return "Transaction [transactionType=" + transactionType + ", amount=" + amount + ", recentBalanceRc="
				+ recentBalanceRC + ", transactionTime=" + dat +",recentBalanceZC =" + recentBalenceZC+ "]";
	}
	
	
}
