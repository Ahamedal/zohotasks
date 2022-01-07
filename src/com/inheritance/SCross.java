package com.inheritance;

public class SCross extends Car {
	

   @Override
	public void maintenance() {
		//super.maintenance();
		System.out.println("SCross under maintenance");
	}
private int seats;
   private int airBags;
   private String model;
   private String color;

public int getSeats() {
	return seats;
}
public void setSeats(int seats) {
	this.seats = seats;
}
public int getAirBags() {
	return airBags;
}
public void setAirBags(int airBags) {
	this.airBags = airBags;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
   
  
}
