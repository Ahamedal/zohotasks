package com.inheritance;

import java.util.Scanner;


public class InheritanceRunner {
	
	
	
	public void callSwiftObject(Swift object) {
		System.out.println("Swift object");
	}

	public void callCarObject(Car object) {
		//System.out.println("accepted by all object");
		if(object instanceof Swift) {
			System.out.println("Hatch");
		}
		if(object instanceof SCross) {
			System.out.println("sedan");
		}
		if(object instanceof XUV) {
			System.out.println("SUV");
		}
		
	}
public void givenSwiftInput()throws Exception {

	Scanner sc=new Scanner(System.in);
	
	Swift objForSwift=new Swift();

	System.out.println("enter seats count");
	int seats=sc.nextInt();
	sc.nextLine();
	objForSwift.setSeats(seats);
	System.out.println("enter airbags count");
	int airBags=sc.nextInt();
	sc.nextLine();
	objForSwift.setAirBags(airBags);
	System.out.println("enter model name of car");
	String model=sc.nextLine();
	objForSwift.setModel(model);
	System.out.println("enter color");
	String color=sc.nextLine();
	objForSwift.setColor(color);
	System.out.println(objForSwift.getSeats());
	System.out.println(objForSwift.getAirBags());
	System.out.println(objForSwift.getModel());
	System.out.println(objForSwift.getColor());
}
public void givenSCrossInput()throws Exception{
Scanner sc=new Scanner(System.in);
	
	SCross objForSCross=new SCross();

	System.out.println("enter seats count");
	int seats=sc.nextInt();
	sc.nextLine();
	objForSCross.setSeats(seats);
	System.out.println("enter airbags count");
	int airBags=sc.nextInt();
	sc.nextLine();
	objForSCross.setAirBags(airBags);
	System.out.println("enter model name of car");
	String model=sc.nextLine();
	objForSCross.setModel(model);
	System.out.println("enter color");
	String color=sc.nextLine();
	objForSCross.setColor(color);
	System.out.println(objForSCross.getSeats());
	System.out.println(objForSCross.getAirBags());
	System.out.println(objForSCross.getModel());
	System.out.println(objForSCross.getColor());
}
public void givenSuperInput()throws Exception {

	Scanner sc=new Scanner(System.in);
	
	SCross objForSCross=new SCross();
	System.out.println("enter yearof make");
	int yearOfMake=sc.nextInt();
	sc.nextLine();
	objForSCross.setYearOfMake(yearOfMake);
	System.out.println("enter enginenumber");
	String engineNumber=sc.nextLine();
	objForSCross.setEngineNumber(engineNumber);
	System.out.println("enter type");
	String type=sc.nextLine();
	objForSCross.setType(type);
	System.out.println(objForSCross.getYearOfMake());
	System.out.println(objForSCross.getEngineNumber());
	System.out.println(objForSCross.getType());
	
}
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	InheritanceRunner objMain=new InheritanceRunner();
	Swift objForSwift=new Swift();
	SCross objForSCross=new SCross();
	//XUV objForXUV=new XUV();
    int quesNo=0;
    try {
    System.out.println("enter your question no");
    quesNo=sc.nextInt();
    sc.nextLine();
    }
    catch(Exception e) {
    	System.out.println("enter a number");
    }
switch(quesNo) {
case 2:
	try {
	objMain.givenSwiftInput();
	
	}
	catch(Exception e) {
		System.out.println("enter a number");
	}
	break;
case 3:
    try {
	objMain.givenSCrossInput();
	
	
	objMain.givenSuperInput();
	
    }
    catch(Exception e) {
    	System.out.println("enter a number");
    }
    break;
case 4:

	objMain.callCarObject(objForSwift);
	objMain.callCarObject(objForSCross);
	break;
case 5:

	objMain.callCarObject(objForSwift);
	objMain.callCarObject(objForSCross);
	break;
case 6:
	objMain.callSwiftObject(objForSwift);
	Car objj=new Swift();
	//Car ojj=new Car();
	
	//objMain.callSwiftObject(objj);
	//objMain.callSwiftObject(objForSCross);
	break;
case 7:
	objForSCross.maintenance();//1
	Car objSCross=new SCross();
	objSCross.maintenance();
	Car objForCar=new Car();
	objForCar.maintenance();
	objForSwift.maintenance();
	break;
	
case 8:
    XUV objXUV=new XUV();
    //XUV objXUV1=new XUV("hello");
    break;
case 9:
	//BirdAbstract objForAbstract=new BirdAbstract();
	ParrotMod ob=new ParrotMod();
	System.out.println(ob.fly());
	System.out.println(ob.speak());
	break;
case 10:
	Duck objForDuck=new Duck();
	System.out.println(objForDuck.fly());
	objForDuck.fly();
	System.out.println(objForDuck.speak());
	break;
    
}
}
}
