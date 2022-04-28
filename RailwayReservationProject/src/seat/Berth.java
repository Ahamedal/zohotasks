package seat;

public class Berth {
private String berthType;
private int seatNo;
private boolean isAvailable=true;

public String getBerthType() {
	return berthType;
}
public void setBerthType(String berthType) {
	this.berthType = berthType;
}
public int getSeatNo() {
	return seatNo;
}
public void setSeatNo(int seatNo) {
	this.seatNo = seatNo;
}

public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
@Override
public String toString() {
	return "[berthType=" + berthType + ", seatNo=" + seatNo + "]";
}

}
