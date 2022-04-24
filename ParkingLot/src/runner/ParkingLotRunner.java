package runner;

import java.text.ParseException;
import java.util.Scanner;

import floor.Vehicle;
import logic.LogicOfParkingLot;
import vehicle.Floor;

public class ParkingLotRunner {
	public void payment() {
		Scanner sc=new Scanner(System.in);
		LogicOfParkingLot logicPark=new LogicOfParkingLot();
		System.out.println("How Many hours to park Your Vehicle");
		int hour=sc.nextInt();
		System.out.println(logicPark.calPayment(hour)+"$ amount to pay for "+hour+" hour parking");
		
		
	}
/**
 * @param args
 * @throws ParseException
 */
public static void main(String[] args) throws ParseException {
	
	Scanner sc=new Scanner(System.in);
	ParkingLotRunner run=new ParkingLotRunner();
	LogicOfParkingLot logicPark=new LogicOfParkingLot();
	logicPark.fullFloorInfo();
	
	boolean condition=true;
	System.out.println("No of floors are 5.You will see the display available spots per floor");
	System.out.println(logicPark.displayAvailable());
	while(condition) {
		System.out.println("\nEnter 1-Entry \n 2-Exit");
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			
			
			Vehicle v=new Vehicle();
			
			boolean condition2=true;
			while(condition2) {
			System.out.println("Enter Floor Number");
			int fNumber=sc.nextInt();
		    sc.nextLine();
		    System.out.println(logicPark.availablePerFlor(fNumber));
		    System.out.println("Enter Vehicle Number");
			int vNumber=sc.nextInt();
			sc.nextLine();
		    System.out.println("Enter Your Vehicle Type");
		    String vehicle=sc.nextLine();
		    if(logicPark.isAvailable(vehicle,fNumber)) {
		    	System.out.println("You Have pay to amount to parking using CreditCards or etc");
	    	String cre=sc.nextLine();
		    	v.setVehicleNumber(vNumber);
	    		v.setVehicleType(vehicle);
	    		v.setFloorNo(fNumber);
		    	if(cre.equals("Yes")) {
		    		
		    		run.payment();
		    		v.setEntryTime(logicPark.time());
		    		v.setPaymentType(true);
		    		v.setTokenNumber(logicPark.generatToken());
		    		System.out.println("Your Token Number is"+v.getTokenNumber());
		    		logicPark.addToken(v);
		    		
		    		logicPark.addVehicle(v);
		    		
		    		
		    	}
		    	else {
		    		v.setEntryTime(logicPark.time());
		    		v.setTokenNumber(logicPark.generatToken());
		    		System.out.println("Your Token Number is"+v.getTokenNumber());
		    		logicPark.addToken(v);
		    		logicPark.addVehicle(v);
		    	}
		    	condition2=false;
		    }
		    else {
		    	System.out.println("this floor "+fNumber+" "+vehicle+" spot  is already full so,not available");
		    }
			}
			break;
		case 2:
			System.out.println("Enter the Token Number");
			int tNumber2=sc.nextInt();
			sc.nextLine();
			int vNumber2=logicPark.getToken(tNumber2);
			if(logicPark.isPayment(vNumber2)) {
				System.out.println("You Have already payed using cards so you go");
			}
			else {
			int time=logicPark.calTime(vNumber2);
			float amount=logicPark.calPayment(time);
			System.out.println("Your pay amount is "+amount+"$ for "+time+" hours");
			}
			
			logicPark.addFloorIfExit(vNumber2);
			logicPark.remove(vNumber2);
			break;
			
		 default:
			condition2=false;
		}
	}
}
}
