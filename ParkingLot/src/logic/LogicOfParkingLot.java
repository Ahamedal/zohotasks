package logic;

import java.util.*;

import java.util.HashMap;
import java.util.Map;

import customer.CustomerDetails;
import exception.CustomException;
import spots.Spots;
import token.Token;
//import token.Vehicle;

public class LogicOfParkingLot {
	static int tokenNo = 1000;
	static int customerId = 0;
	float hor1 = 4;
	float hour2 = 3.5f;
	float hours = 2.5f;
	static Map<Integer, Map<String, List<Spots>>> availableSpots = new HashMap<>();
	static Map<Integer, Spots> occupiedSpots = new HashMap<>();
	static Map<Integer, Token> vehicleInfo = new HashMap<>(); //key=vehicleNo value=tokenObj
	static Map<Integer, CustomerDetails> cusInfo = new HashMap<>(); //key=tokenNo value=cusObj
	static Map<Integer, Integer> tokenInfo = new HashMap<>();//key=tokenNo value=vehicleNo
	static Map<Integer, Integer> cusIdInfo = new HashMap<>();//key=cusNo value=tokenNo
	static Map<Integer,Integer> vehAndCusId=new HashMap<>();//key=vehicleNo value=cusId;

	public void addParkInf(int fNo, String vehicleType, Spots spot) throws CustomException {
		stringCheck(vehicleType);
		nullCheck(spot);
		Map<String, List<Spots>> map = availableSpots.get(fNo);
		if (map == null) {
			map = new HashMap<>();
			availableSpots.put(fNo, map);

		}
		List<Spots> list = map.get(vehicleType);
		if (list == null) {
			list = new ArrayList<>();
			map.put(vehicleType, list);
		}
		list.add(spot);
	}
    public String showMsgOnFloor(int floorNo,String vehicleModel) {
    	String aSpace=availableSpots.get(floorNo).get(vehicleModel).size()+" Free "+ vehicleModel +" spot on the "+floorNo+" floor";
    	return aSpace;
    }
	public Spots isAvailable(String vehicleType, int floorNo) throws CustomException {
		stringCheck(vehicleType);
		Spots spot = null;

		List<Spots> lic = availableSpots.get(floorNo).get(vehicleType);
		if (lic.size() != 0) {
			spot = availableSpots.get(floorNo).get(vehicleType).get(0);
			if (spot != null) {
				spot.setTokenNo(generatToken());
				List<Spots> lis = availableSpots.get(floorNo).get(vehicleType);
				occupiedSpots.put(spot.getTokenNo(), spot);
				lis.remove(spot);
			}
		}

		return spot;

	}

	public int generatToken() {
		return ++tokenNo;
	}

	public int generatCusId() {
		return ++customerId;
	}

	public void addFloorIfExit(int tNo) throws CustomException {
		checkTokenId(tNo);
		Spots spot = occupiedSpots.get(tNo);
		int fNo = spot.getFloorNo();
		String spotTyp = spot.getSpotsType();
		addParkInf(fNo, spotTyp, spot);
		occupiedSpots.remove(tNo);

	}

	public long calTime(int vNumber) throws CustomException {
		checkVehicleId(vNumber);
		long exitTim = System.currentTimeMillis();
		Token token = vehicleInfo.get(vNumber);
		return calDiffEnterAndExit(token.getEntryTime(), exitTim);

	}

	public long calDiffEnterAndExit(long entry, long exit) {

		long time = (exit - entry) / 1000;
		return time;
	}

	public boolean isPayment(int vNumber) throws CustomException {
		checkVehicleId(vNumber);
		Token token = vehicleInfo.get(vNumber);
		return token.isPaymentStatus();
	}

	public void addToken(Token tOb) throws CustomException {
		nullCheck(tOb);
		tokenInfo.put(tOb.getTokenNumber(), tOb.getVehicleNumber());
	}

	public int getToken(int tNo) throws CustomException {
		checkTokenId(tNo);
		return tokenInfo.get(tNo);
	}

	public void addCustomer(CustomerDetails cus, int tNo) throws CustomException {
		nullCheck(cus);
		cusInfo.put(tNo, cus);
	}

	public CustomerDetails getCusInfo(int tNo) throws CustomException {
		checkTokenId(tNo);
		return cusInfo.get(tNo);
	}

	public void addVehicle(Token tOb) throws CustomException {
		nullCheck(tOb);
		vehicleInfo.put(tOb.getVehicleNumber(), tOb);
	}

	public float calPayment(long hour) {
		float sum = 0;
		for (long i = hour; i >= 1; i--) {
			if (i == 2 || i == 3) {
				sum = sum + hour2;
			} else if (i == 1) {
				sum = sum + hor1;
			} else {
				sum = sum + hours;
			}
		}
		return sum;
	}

	public void addCustomerId(int cId, int tId) {
		cusIdInfo.put(cId, tId);
	}
    public void addVehAndCusId(int vNo,int cId) {
    	vehAndCusId.put(vNo,cId);
    }
	public CustomerDetails getWalletAmount(int cId) throws CustomException {
		checkCusId(cId);
		int tId = cusIdInfo.get(cId);
		CustomerDetails cus = cusInfo.get(tId);
		return cus;
	}

	public void maps() {
		System.out.println(availableSpots);
		System.out.println(occupiedSpots);
		System.out.println(cusInfo);
		System.out.println(vehicleInfo);
		System.out.println(tokenInfo);
	}

	private void stringCheck(String testString) throws CustomException {
		if (testString == null || testString.isEmpty()) {
			throw new CustomException("String can not be null or empty");
		}
	}

	private void nullCheck(Object fileObj) throws CustomException {
		if (fileObj == null) {
			throw new CustomException(fileObj + "cannot be null");
		}
	}

	private void checkVehicleId(int vId) throws CustomException {
		if (vehicleInfo.get(vId) == null) {
			throw new CustomException("this Vehicle No is does not exist");
		}
	}

	private void checkTokenId(int tId) throws CustomException {
		if (tokenInfo.get(tId) == null) {
			throw new CustomException("this token no is does not exist");
		}
	}

	private void checkCusId(int fId) throws CustomException {
		if (cusIdInfo.get(fId) == null) {
			throw new CustomException("this Customer Id is does not exist");
		}
	}

}

//	Map<Integer,Floor> floorInfo=new HashMap<>();
//	Map<Integer,Vehicle> vehicleInfo=new HashMap<>();
//	Map<Integer,Integer> tokenInfo=new HashMap<>();
//	
//	int tokenNumber=1000;
//	float hor1=4;
//	float hour2=3.5f;
//	float hours=2.5f;
//	public void fullFloorInfo() {
//		Floor floor=new Floor();
//		int size=floor.getFloorNumber();
//		for(int i=1;i<=size;i++) {
//		    floor=new Floor();
//			floorInfo.put(i, floor);
//		}
//	}
//	public Map<Integer,Floor> displayAvailable(){
//		return floorInfo;
//	}
//	public Floor availablePerFlor(int fNumber) {
//		return floorInfo.get(fNumber);
//	}
//	public float calPayment(int hour) {
//		float sum=0;
//		for(int i=hour;i>=1;i--) {
//			if(i==2||i==3) {
//				sum=sum+hour2;
//			}
//			else if(i==1) {
//				sum=sum+hor1;
//			}
//			else {
//				sum=sum+hours;
//			}
//		}
//		return sum;
//	}
//public boolean isAvailable(String vehicle,int fNumber) throws CustomException {
//	stringCheck(vehicle);
//	checkFloorId(fNumber);
//	 int avai=0;
//	
//	 
//	Floor floors=floorInfo.get(fNumber);
//	switch(vehicle) {
//	case "Car":
//		avai=floors.getCompactSpot()-1;
//		floors.setCompactSpot(floors.getCompactSpot()-1);
//		break;
//	case "Truck":
//		avai=floors.getLargeSpot()-1;
//		floors.setLargeSpot(floors.getLargeSpot()-1);
//		break;
//		
//	case "MotorCycle":
//		avai=floors.getMotorCycleSpot()-1;
//		floors.setMotorCycleSpot(floors.getMotorCycleSpot()-1);
//		break;
//		
//	case "Handicapped":
//		avai=floors.getHandicappedSpot()-1;
//		floors.setHandicappedSpot(floors.getHandicappedSpot()-1);
//		break;
//		
//	case "Electric Car":
//		avai=floors.getElectricCarSpot()-1;
//		floors.setElectricCarSpot(floors.getElectricCarSpot()-1);;
//		break;
//	
//	default:
//		return false;
//	}
//	
//	if(avai<=-1) {
//		switch(vehicle) {
//		case "Car":
//			
//			floors.setCompactSpot(floors.getCompactSpot()+1);
//			break;
//		case "Truck":
//			
//			floors.setLargeSpot(floors.getLargeSpot()+1);
//			break;
//			
//		case "MotorCycle":
//			
//			floors.setMotorCycleSpot(floors.getMotorCycleSpot()+1);
//			break;
//			
//		case "Handicapped":
//			
//			floors.setHandicappedSpot(floors.getHandicappedSpot()+1);
//			break;
//			
//		case "Electric Car":
//			floors.setElectricCarSpot(floors.getElectricCarSpot()+1);
//		}
//		return false;
//	}
//	floors.setTotalSize(floors.getTotalSize()-1);
//	return true;
//}
//public void addSizeExit(String vehicle,int fNo) throws CustomException {
//	stringCheck(vehicle);
//	
//	Floor floors=floorInfo.get(fNo);
//	switch(vehicle) {
//	case "Car":
//		
//		floors.setCompactSpot(floors.getCompactSpot()+1);
//		break;
//	case "Truck":
//		
//		floors.setLargeSpot(floors.getLargeSpot()+1);
//		break;
//		
//	case "MotorCycle":
//		
//		floors.setMotorCycleSpot(floors.getMotorCycleSpot()+1);
//		break;
//		
//	case "Handicapped":
//		
//		floors.setHandicappedSpot(floors.getHandicappedSpot()+1);
//		break;
//		
//	}
//	floors.setTotalSize(floors.getTotalSize()+1);
//}
//public void addFloorIfExit(int vNo) throws CustomException {
//	checkVehicleId(vNo);
//	Vehicle ve=vehicleInfo.get(vNo);
//	String vehicleType=ve.getVehicleType();
//	int fNo=ve.getFloorNo();
//	addSizeExit(vehicleType,fNo);
//	
//}
//public int calDiffEnterAndExit(String entry,String exit) throws CustomException,ParseException {
//	stringCheck(entry);
//	stringCheck(exit);
//	SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
//	Date date1=formatter.parse(entry);
//	Date date2=formatter.parse(exit);
//	int time=(date2.getSeconds()-date1.getSeconds());
//	return time;
//}
//public int calTime(int vNumber) throws CustomException,ParseException {
//	checkVehicleId(vNumber);
//	String exitTim=time();
//	Vehicle ve=vehicleInfo.get(vNumber);
//	return calDiffEnterAndExit(ve.getEntryTime(),exitTim);
//	
//}
//public boolean isPayment(int vNumber2) throws CustomException {
//	checkVehicleId(vNumber2);
//	Vehicle ve=vehicleInfo.get(vNumber2);
//	return ve.isPaymentType();
//}
//public void addToken(Vehicle vOb) throws CustomException {
//	nullCheck(vOb);
//	tokenInfo.put(vOb.getTokenNumber(), vOb.getVehicleNumber());
//}
//public int getToken(int tNo) throws CustomException {
//	checkTokenId(tNo);
//	return tokenInfo.get(tNo);
//}
//public void addVehicle(Vehicle vOb) throws CustomException {
//	nullCheck(vOb);
//	vehicleInfo.put(vOb.getVehicleNumber(), vOb);
//}
//public void remove(int vNo) throws CustomException {
//	checkVehicleId(vNo);
//	vehicleInfo.remove(vNo);
//}
//public int generatToken() {
//	return ++tokenNumber;
//}
//public String time() {
//	SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
//	Date dateObj=new Date();
//	return date.format(dateObj);
//	
//}
//private void stringCheck(String testString)throws CustomException{
//	if(testString==null||testString.isEmpty()){
//	throw new CustomException("String can not be null or empty");
//	}
//	}
//private void nullCheck(Object fileObj)throws CustomException{
//	if(fileObj==null){
//	throw new CustomException(fileObj+"cannot be null");
//	}
//	}
//
//private void checkVehicleId(int vId)throws CustomException{
//	  if(vehicleInfo.get(vId)==null) {
//		  throw new CustomException("this Vehicle No is does not exist");
//	  }
//}
//private void checkFloorId(int fId)throws CustomException{
//	  if(floorInfo.get(fId)==null) {
//		  throw new CustomException("this Floor no is does not exist");
//	  }
//}
//private void checkTokenId(int fId)throws CustomException{
//	  if(tokenInfo.get(fId)==null) {
//		  throw new CustomException("this Token no is does not exist");
//	  }
//}
//for(int i=0;i<availableSpots.size();i++) {
//if(availableSpots.get(i).getFloorNo()==floorNo) {
//	 spot=availableSpots.get(i);
//	switch(vehicleType) {
//	case "Car":
//		if(spot.getSpotsType().equals("Compact")) {
//			spot.setTokenNo(generatToken());
//			occupiedSpots.add(spot);
//			availableSpots.remove(spot);
//			return spot;
//		}
//		break;
//	case "Truck":
//		if(spot.getSpotsType().equals("Large")) {
//			occupiedSpots.add(spot);
//			availableSpots.remove(spot);
//			return spot;
//		}
//		
//		break;
//	case "MotorCycle":
//		
//		if(spot.getSpotsType().equals("MotorCycle")) {
//			occupiedSpots.add(spot);
//			availableSpots.remove(spot);
//			return spot;
//		}
//		break;
//	case "Handicapped":
//		if(spot.getSpotsType().equals("Handicapped")) {
//			occupiedSpots.add(spot);
//			availableSpots.remove(spot);
//			return spot;
//		}
//		break;
//		
//	case "Electric Car":
//		if(spot.getSpotsType().equals("ElectricCar")) {
//			occupiedSpots.add(spot);
//			availableSpots.remove(spot);
//			return spot;
//		}
//		break;
//	
//}
//	
//}
//
//
//}
