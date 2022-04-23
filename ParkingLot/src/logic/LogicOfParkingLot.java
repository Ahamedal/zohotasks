package logic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import floor.Vehicle;
import vehicle.Floor;

public class LogicOfParkingLot {
	Map<Integer,Vehicle> vehicleInfo=new HashMap<>();
	int tokenNumber=1000;
	float hor1=4;
	float hour2=3.5f;
	float hours=2.5f;
	public float calPayment(int hour) {
		float sum=0;
		for(int i=hour;i>=1;i--) {
			if(i==2||i==3) {
				sum=sum+hour2;
			}
			else if(i==1) {
				sum=sum+hor1;
			}
			else {
				sum=sum+hours;
			}
		}
		return sum;
	}
public boolean isAvailable(String vehicle,Floor floo) {
	 int avai=0;
	switch(vehicle) {
	case "Car":
		avai=floo.getCompactSpot()-1;
		floo.setCompactSpot(floo.getCompactSpot()-1);
		break;
	case "Truck":
		avai=floo.getLargeSpot()-1;
		floo.setLargeSpot(floo.getLargeSpot()-1);
		break;
		
	case "MotorCycle":
		avai=floo.getMotorCycleSpot()-1;
		floo.setMotorCycleSpot(floo.getMotorCycleSpot()-1);
		break;
		
	case "Handicapped":
		avai=floo.getHandicappedSpot()-1;
		floo.setHandicappedSpot(floo.getHandicappedSpot()-1);
		break;
		
	}
	if(avai<=-1) {
		return false;
	}
	return true;
}
public void addVehicle(Vehicle vOb) {
	vehicleInfo.put(vOb.getVehicleNumber(), vOb);
}
public int generatToken() {
	return ++tokenNumber;
}
public String time() {
	SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
	Date dateObj=new Date();
	return date.format(dateObj);
	
}
}
