package com.reflect;

public class PogoReflection {
	private String name;
	private int id;
public PogoReflection(){
	System.out.println("constructor");
}
public PogoReflection(String name,int id) {
	this.name=name;
	this.id=id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String toString() {
	return "name:"+name+"\n"+"id:"+id;
}
}
