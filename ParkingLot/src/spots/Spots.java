package spots;

public class Spots {
private int spotNo;
private int tokenNo;
private String spotsType;
private int floorNo;
private boolean electricCharge=false;
public int getSpotNo() {
	return spotNo;
}
public void setSpotNo(int spotNo) {
	this.spotNo = spotNo;
}

public int getTokenNo() {
	return tokenNo;
}
public void setTokenNo(int tokenNo) {
	this.tokenNo = tokenNo;
}
public String getSpotsType() {
	return spotsType;
}
public void setSpotsType(String spotsType) {
	this.spotsType = spotsType;
}
public int getFloorNo() {
	return floorNo;
}
public void setFloorNo(int floorNo) {
	this.floorNo = floorNo;
}
public boolean isElectricCharge() {
	return electricCharge;
}
public void setElectricCharge(boolean electricCharge) {
	this.electricCharge = electricCharge;
}
@Override
public String toString() {
	return "spotNo=" + spotNo + ", spotsType=" + spotsType + ", floorNo=" + floorNo + ", electricCharge="
			+ electricCharge + "";
}

}
