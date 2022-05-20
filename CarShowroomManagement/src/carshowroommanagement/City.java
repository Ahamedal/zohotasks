package carshowroommanagement;

public class City {
private int totalStackForSheltos;
private int totalStackForSonet;
private String cityName;
private int SONETSold;
private int SELTOSSold;
private String mostSoldCar;




public int getTotalStackForSheltos() {
	return totalStackForSheltos;
}
public void setTotalStackForSheltos(int totalStackForSheltos) {
	this.totalStackForSheltos = totalStackForSheltos;
}
public int getTotalStackForSonet() {
	return totalStackForSonet;
}
public void setTotalStackForSonet(int totalStackForSonet) {
	this.totalStackForSonet = totalStackForSonet;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public int getSONETSold() {
	return SONETSold;
}
public void setSONETSold(int sONETSold) {
	SONETSold = sONETSold;
}
public int getSELTOSSold() {
	return SELTOSSold;
}
public void setSELTOSSold(int sELTOSSold) {
	SELTOSSold = sELTOSSold;
}

public String getMostSoldCar() {
	return mostSoldCar;
}
public void setMostSoldCar(String mostSoldCar) {
	this.mostSoldCar = mostSoldCar;
}
@Override
public String toString() {
	
	return "[SONETSold=" + SONETSold
			+ ", SELTOSSold=" + SELTOSSold + "]";
	
}

}
