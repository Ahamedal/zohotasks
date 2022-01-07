package com.inheritance;

public class Car {
	public Car() {
		
	}
	public Car(String print) {
		System.out.println(print);
	}
	
	public void maintenance() {
		System.out.println("Car under mainteance");
	}
	private int yearOfMake;
	private String engineNumber;
	private String type;
	
public void setYearOfMake(int yearOfMake) {
	this.yearOfMake=yearOfMake;
}
public int getYearOfMake() {
	return yearOfMake;
}
public void setEngineNumber(String engineNumber) {
	this.engineNumber=engineNumber;
}
public String getEngineNumber() {
	return engineNumber;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
