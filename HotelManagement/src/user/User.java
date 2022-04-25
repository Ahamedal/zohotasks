package user;

public class User {
	private String userNam;
	private int userId;
	private String hotelName;
	private int bookingCost;
	public String getUserNam() {
		return userNam;
	}
	public void setUserNam(String userNam) {
		this.userNam = userNam;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getBookingCost() {
		return bookingCost;
	}
	public void setBookingCost(int bookingCost) {
		this.bookingCost = bookingCost;
	}
	@Override
	public String toString() {
		return "[userNam=" + userNam + ", userId=" + userId + ", hotelName=" + hotelName + ", bookingCost="
				+ bookingCost + "]";
	}
    
}
