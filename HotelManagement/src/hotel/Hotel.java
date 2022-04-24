package hotel;

public class Hotel {
private String hotelName;
private int roomsAvailable;
private String locations;
private int rating;
private int pricePerRoom;
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public int getRoomsAvailable() {
	return roomsAvailable;
}
public void setRoomsAvailable(int roomsAvailable) {
	this.roomsAvailable = roomsAvailable;
}
public String getLocations() {
	return locations;
}
public void setLocations(String locations) {
	this.locations = locations;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public int getPricePerRoom() {
	return pricePerRoom;
}
public void setPricePerRoom(int pricePerRoom) {
	this.pricePerRoom = pricePerRoom;
}
@Override
public String toString() {
	return "[hotelName=" + hotelName + ", roomsAvailable=" + roomsAvailable + ", locations=" + locations
			+ ", rating=" + rating + ", pricePerRoom=" + pricePerRoom + "]";
}

}
