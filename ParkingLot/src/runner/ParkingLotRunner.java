package runner;

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
		System.out.println(logicPark.calPayment(hour)+"amount to pay for parking");
		
		
	}
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	ParkingLotRunner run=new ParkingLotRunner();
	LogicOfParkingLot logicPark=new LogicOfParkingLot();
	boolean condition=true;
	while(condition) {
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			Floor flo=new Floor();
			Vehicle v=new Vehicle();
			System.out.println("Enter Vehicle Number");
			int vNumber=sc.nextInt();
			sc.nextLine();
			boolean condition2=true;
			while(condition2) {
			System.out.println("Enter Floor Number");
			int fNumber=sc.nextInt();
		    sc.nextLine();
		    System.out.println("Enter Your Vehicle Type");
		    String vehicle=sc.nextLine();
		    if(logicPark.isAvailable(vehicle,flo)) {
		    	System.out.println("You Have pay to amount to parking using CreditCards or etc");
		    	String cre=sc.nextLine();
		    	if(cre.equals("Yes")) {
		    		
		    		run.payment();
		    		v.setVehicleNumber(vNumber);
		    		v.setVehicleType(vehicle);
		    		v.setEntryTime(logicPark.time());
		    		v.setPaymentType(true);
		    		v.setTokenNumber(logicPark.generatToken());
		    		System.out.println("Your Token Number is"+v.getTokenNumber());
		    		logicPark.addVehicle(v);
		    		
		    		
		    	}
		    	condition2=false;
		    }
		    else {
		    	System.out.println("this "+fNumber+"is already full so,not available");
		    }
			}
		}
	}
}
}
