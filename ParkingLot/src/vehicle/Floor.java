package vehicle;

public class Floor {
   private int floorNumber=5;
   private int availableFloor;
   private int totalSize=18;
   private int compactSpot=10;
   private int largeSpot=5;
   private int motorCycleSpot=2;
   private int handicappedSpot=1;
public int getFloorNumber() {
	return floorNumber;
}
public void setFloorNumber(int floorNumber) {
	this.floorNumber = floorNumber;
}

public int getAvailableFloor() {
	return availableFloor;
}
public void setAvailableFloor(int availableFloor) {
	this.availableFloor = availableFloor;
}
public int getTotalSize() {
	return totalSize;
}
public void setTotalSize(int totalSize) {
	this.totalSize = totalSize;
}
public int getCompactSpot() {
	return compactSpot;
}
public void setCompactSpot(int compactSpot) {
	this.compactSpot = compactSpot;
}
public int getLargeSpot() {
	return largeSpot;
}
public void setLargeSpot(int largeSpot) {
	this.largeSpot = largeSpot;
}
public int getMotorCycleSpot() {
	return motorCycleSpot;
}
public void setMotorCycleSpot(int motorCycleSpot) {
	this.motorCycleSpot = motorCycleSpot;
}
public int getHandicappedSpot() {
	return handicappedSpot;
}
public void setHandicappedSpot(int handicappedSpot) {
	this.handicappedSpot = handicappedSpot;
}
@Override
public String toString() {
	return "Vehicle [floorNumber=" + floorNumber + ", totalSize=" + totalSize + ", compactSpot=" + compactSpot
			+ ", largeSpot=" + largeSpot + ", motorCycleSpot=" + motorCycleSpot + ", handicappedSpot=" + handicappedSpot
			+ "]";
}
   
   
}
