package runner;

import java.text.ParseException;


import java.util.Scanner;

import customer.CustomerDetails;
import exception.CustomException;
import logic.LogicOfParkingLot;
import spots.Spots;
import token.Token;


public class ParkingLotRunner {
	public void fullFloorInfo() {
		LogicOfParkingLot logicPark=new LogicOfParkingLot();
		for(int f=0;f<2;f++) {
		for(int i=1;i<4;i++) {
			Spots spot=new Spots();
			spot.setFloorNo(f);
			spot.setSpotNo(i);
			spot.setSpotsType("Compact");
			logicPark.addParkInf(f,"Compact",spot);
		}
		for(int i=4;i<6;i++) {
			Spots spot=new Spots();
			spot.setFloorNo(f);
			spot.setSpotNo(i);
			spot.setSpotsType("Large");
			logicPark.addParkInf(f,"large",spot);
		}
		for(int i=6;i<=7;i++) {
			Spots spot=new Spots();
			spot.setFloorNo(f);
			spot.setSpotNo(i);
			spot.setSpotsType("ElectricCar");
			spot.setElectricCharge(true);
			logicPark.addParkInf(f,"ElectricCar",spot);
			
		}
		for(int i=9;i<=9;i++) {
			Spots spot=new Spots();
			spot.setFloorNo(f);
			spot.setSpotsType("MotorCycle");
			spot.setSpotNo(i);
			logicPark.addParkInf(f,"MotorCycle",spot);
		}
		}
	}
	public void payment() {
		Scanner sc=new Scanner(System.in);
		CustomerDetails cusDetails=new CustomerDetails();
		
		LogicOfParkingLot logicPark=new LogicOfParkingLot();
		System.out.println("Enter Name");
		String uName=sc.nextLine();
		System.out.println("Enter Your mobile number");
		long mNo=sc.nextLong();
		sc.nextLine();
		
		System.out.println("How Much money You wish to have in your wallet");
		double wAmmount=sc.nextDouble();
		sc.nextLine();
	    cusDetails.setUsName(uName);
	    cusDetails.setMobileNumber(mNo);
	    cusDetails.setWalletAmmount(wAmmount);
		
		
	}
/**
 * @param args
 * @throws ParseException
 */
public static void main(String[] args)  {
	
	Scanner sc=new Scanner(System.in);
	ParkingLotRunner run=new ParkingLotRunner();
	LogicOfParkingLot logicPark=new LogicOfParkingLot();
	run.fullFloorInfo();
	
	boolean condition=true;
	System.out.println("No of floors are 5.You will see the display available spots per floor");
	//System.out.println(logicPark.displayAvailable());
	while(condition) {
		System.out.println("\nEnter 1-Entry \n 2-Exit");
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			try{
			
			Token tObj=new Token();
			
			boolean condition2=true;
			while(condition2) {
			System.out.println("Enter Floor Number");
			int fNumber=sc.nextInt();
		    sc.nextLine();
		    //System.out.println(logicPark.availablePerFlor(fNumber));
		    System.out.println("Enter Vehicle Number");
			int vNumber=sc.nextInt();
			sc.nextLine();
		    System.out.println("Enter Your Vehicle Type");
		    String vehicle=sc.nextLine();
		    Spots spot=logicPark.isAvailable(vehicle,fNumber);
		    if(spot!=null) {
		    	
	    	
		    	tObj.setVehicleNumber(vNumber);
	    		tObj.setVehicleType(vehicle);
	    		tObj.setFloorNo(fNumber);
	    		tObj.setEntryTime(System.currentTimeMillis());
	    		tObj.setTokenNumber(spot.getTokenNo());
	    		System.out.println("Your Token Number is"+tObj.getTokenNumber()+", Your Spot no is "+spot.getSpotNo()+" in "+tObj.getFloorNo()+" floor");
		    	
		    		
		    		
		    		System.out.println("If you have pay to CustomerInfoPortal (Enter Yes-true Or No-false)");
		    		boolean cusPortal=sc.nextBoolean();
		    		if(cusPortal) {
		    			run.payment();
		    			
		    			tObj.setPaymentStatus(true);
		    			
		    		}
		    		
		    		logicPark.addToken(tObj);
		    		logicPark.addVehicle(tObj);
		    	
		    	condition2=false;
		    }
		    else {
		    	System.out.println("this floor "+fNumber+" "+vehicle+" spot  is already full so,not available.So,Choose another floor");
		    }
			}
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 2:
			try {
			System.out.println("Enter the Token Number");
			int tNumber2=sc.nextInt();
			sc.nextLine();
			int vNumber2=logicPark.getToken(tNumber2);
			if(logicPark.isPayment(vNumber2)) {
				long time=logicPark.calTime(vNumber2);
				float amount=logicPark.calPayment(time);
				CustomerDetails cus=logicPark.getCusInfo(tNumber2);
				double wAmount=cus.getWalletAmmount();
				if((wAmount-amount)>=0) {
					cus.setWalletAmmount(wAmount-amount);
					
					System.out.println("Successfully payed in CustomerInfoPortal");
					System.out.println("Current wallet amount is"+(wAmount-amount));
				}
				else {
				System.out.println("Your pay amount is "+Math.abs(wAmount-amount)+"$ for "+time+" hours after reduce in your wallet amount");
				System.out.println("Payment Successfully");
				}
				
			}
			else {
				System.out.println("You Have pay Enter 1-cash or Enter 2-Credit Cards ");
				int credit=sc.nextInt();
				sc.nextLine();
				  if(credit==2) {
				boolean condition2=true;
			    while(condition2) {
            
		    		
		    		System.out.println("Enter Your Credit Card No");
		    		long cNo=sc.nextLong();
		    		sc.nextLine();
		    	    if(String.valueOf(cNo).length()==16) {
		    	    	condition2=false;
		    	    }
		    	    else {
		    	    	System.out.println("Your credit card no is wrong.so,Enter correctly");
		    	    }
		    		
		    		}
			  }
			long time=logicPark.calTime(vNumber2);
			float amount=logicPark.calPayment(time);
			System.out.println("Your pay amount is "+amount+"$ for "+time+" hours");
			System.out.println("Payment Successfully");
			}
			
			logicPark.addFloorIfExit(tNumber2);
			
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
			
		 default:
			 logicPark.maps();
			condition=false;
		}
	}
}
}
