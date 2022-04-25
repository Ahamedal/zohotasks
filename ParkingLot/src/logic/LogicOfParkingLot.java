package logic;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import exception.CustomException;

import floor.Vehicle;
import vehicle.Floor;

public class LogicOfParkingLot {
	Map<Integer,Floor> floorInfo=new HashMap<>();
	Map<Integer,Vehicle> vehicleInfo=new HashMap<>();
	Map<Integer,Integer> tokenInfo=new HashMap<>();
	
	int tokenNumber=1000;
	float hor1=4;
	float hour2=3.5f;
	float hours=2.5f;
	public void fullFloorInfo() {
		Floor floor=new Floor();
		int size=floor.getFloorNumber();
		for(int i=1;i<=size;i++) {
		    floor=new Floor();
			floorInfo.put(i, floor);
		}
	}
	public Map<Integer,Floor> displayAvailable(){
		return floorInfo;
	}
	public Floor availablePerFlor(int fNumber) {
		return floorInfo.get(fNumber);
	}
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
public boolean isAvailable(String vehicle,int fNumber) throws CustomException {
	stringCheck(vehicle);
	checkFloorId(fNumber);
	 int avai=0;
	
	 
	Floor floors=floorInfo.get(fNumber);
	switch(vehicle) {
	case "Car":
		avai=floors.getCompactSpot()-1;
		floors.setCompactSpot(floors.getCompactSpot()-1);
		break;
	case "Truck":
		avai=floors.getLargeSpot()-1;
		floors.setLargeSpot(floors.getLargeSpot()-1);
		break;
		
	case "MotorCycle":
		avai=floors.getMotorCycleSpot()-1;
		floors.setMotorCycleSpot(floors.getMotorCycleSpot()-1);
		break;
		
	case "Handicapped":
		avai=floors.getHandicappedSpot()-1;
		floors.setHandicappedSpot(floors.getHandicappedSpot()-1);
		break;
		
	case "Electric Car":
		avai=floors.getElectricCarSpot()-1;
		floors.setElectricCarSpot(floors.getElectricCarSpot()-1);;
		break;
	
	default:
		return false;
	}
	
	if(avai<=-1) {
		switch(vehicle) {
		case "Car":
			
			floors.setCompactSpot(floors.getCompactSpot()+1);
			break;
		case "Truck":
			
			floors.setLargeSpot(floors.getLargeSpot()+1);
			break;
			
		case "MotorCycle":
			
			floors.setMotorCycleSpot(floors.getMotorCycleSpot()+1);
			break;
			
		case "Handicapped":
			
			floors.setHandicappedSpot(floors.getHandicappedSpot()+1);
			break;
			
		case "Electric Car":
			floors.setElectricCarSpot(floors.getElectricCarSpot()+1);
		}
		return false;
	}
	floors.setTotalSize(floors.getTotalSize()-1);
	return true;
}
public void addSizeExit(String vehicle,int fNo) throws CustomException {
	stringCheck(vehicle);
	
	Floor floors=floorInfo.get(fNo);
	switch(vehicle) {
	case "Car":
		
		floors.setCompactSpot(floors.getCompactSpot()+1);
		break;
	case "Truck":
		
		floors.setLargeSpot(floors.getLargeSpot()+1);
		break;
		
	case "MotorCycle":
		
		floors.setMotorCycleSpot(floors.getMotorCycleSpot()+1);
		break;
		
	case "Handicapped":
		
		floors.setHandicappedSpot(floors.getHandicappedSpot()+1);
		break;
		
	}
	floors.setTotalSize(floors.getTotalSize()+1);
}
public void addFloorIfExit(int vNo) throws CustomException {
	checkVehicleId(vNo);
	Vehicle ve=vehicleInfo.get(vNo);
	String vehicleType=ve.getVehicleType();
	int fNo=ve.getFloorNo();
	addSizeExit(vehicleType,fNo);
	
}
public int calDiffEnterAndExit(String entry,String exit) throws CustomException,ParseException {
	stringCheck(entry);
	stringCheck(exit);
	SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
	Date date1=formatter.parse(entry);
	Date date2=formatter.parse(exit);
	int time=(date2.getSeconds()-date1.getSeconds());
	return time;
}
public int calTime(int vNumber) throws CustomException,ParseException {
	checkVehicleId(vNumber);
	String exitTim=time();
	Vehicle ve=vehicleInfo.get(vNumber);
	return calDiffEnterAndExit(ve.getEntryTime(),exitTim);
	
}
public boolean isPayment(int vNumber2) throws CustomException {
	checkVehicleId(vNumber2);
	Vehicle ve=vehicleInfo.get(vNumber2);
	return ve.isPaymentType();
}
public void addToken(Vehicle vOb) throws CustomException {
	nullCheck(vOb);
	tokenInfo.put(vOb.getTokenNumber(), vOb.getVehicleNumber());
}
public int getToken(int tNo) throws CustomException {
	checkTokenId(tNo);
	return tokenInfo.get(tNo);
}
public void addVehicle(Vehicle vOb) throws CustomException {
	nullCheck(vOb);
	vehicleInfo.put(vOb.getVehicleNumber(), vOb);
}
public void remove(int vNo) throws CustomException {
	checkVehicleId(vNo);
	vehicleInfo.remove(vNo);
}
public int generatToken() {
	return ++tokenNumber;
}
public String time() {
	SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
	Date dateObj=new Date();
	return date.format(dateObj);
	
}
private void stringCheck(String testString)throws CustomException{
	if(testString==null||testString.isEmpty()){
	throw new CustomException("String can not be null or empty");
	}
	}
private void nullCheck(Object fileObj)throws CustomException{
	if(fileObj==null){
	throw new CustomException(fileObj+"cannot be null");
	}
	}

private void checkVehicleId(int vId)throws CustomException{
	  if(vehicleInfo.get(vId)==null) {
		  throw new CustomException("this Vehicle No is does not exist");
	  }
}
private void checkFloorId(int fId)throws CustomException{
	  if(floorInfo.get(fId)==null) {
		  throw new CustomException("this Floor no is does not exist");
	  }
}
private void checkTokenId(int fId)throws CustomException{
	  if(tokenInfo.get(fId)==null) {
		  throw new CustomException("this Token no is does not exist");
	  }
}
}
