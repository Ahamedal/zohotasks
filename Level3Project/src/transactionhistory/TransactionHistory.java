package transactionhistory;

public class TransactionHistory {
	private int fromAccount;
	private int toAccount;
	private double amount;
	private String date;
	private String time;
	private double beforeBalance;
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getBeforeBalance() {
		return beforeBalance;
	}
	public void setBeforeBalance(double beforeBalance) {
		this.beforeBalance = beforeBalance;
	}
	@Override
	public String toString() {
		return "fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
				+ ", date=" + date + ", time=" + time + ", beforeBalance=" + beforeBalance + "";
	}
	

}
