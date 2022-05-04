package callTaxiBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taxi.Taxi;
import taxiHistory.TaxiHistory;

public class CallTaxiBooking {

	List<Taxi> taxi=new ArrayList<>();
	List<Character> points=new ArrayList<>();
	Map<Integer,List<TaxiHistory>> taxiHistory=new HashMap<>();
	int taxiNo=0;
	
  public void addPoints() {
	  points.add('A');
	  points.add('B');
	  points.add('C');
	  points.add('D');
	  points.add('E');
	  points.add('F');
  }
  public void addTaxi(Taxi taxDetails){
	  taxDetails.setTaxiNo(++taxiNo);
	  taxi.add(taxDetails);
  }
  public String taxiBooking(char pickUpPoint,char dropPoint,long pickUpTime) {
	  if(pickUpPoint<='A'||pickUpPoint>='F'||dropPoint<='A'||dropPoint>='F') {
		  return "Not Available";
	  }
	  List<Taxi> availableTaxi=new ArrayList<>();
	  for(int i=0;i<taxi.size();i++) {
		  if(taxi.get(i).isAvailable()&&availableTimeForPickUp(pickUpPoint,pickUpTime,taxi.get(i))){
			  availableTaxi.add(taxi.get(i));
		  }
	  }
	  return "";
	  
  }
  public boolean availableTimeForPickUp(char pickUpPoint,long pickUpTime,Taxi taxiObj) {
	 int fromPoint=taxiObj.getCurrentPosition();
	 int toPoint=pickUpPoint;
	  long reachTime=0;
	 if(fromPoint>toPoint) {
		 for(int i=fromPoint;i>toPoint;i--) {
			 reachTime+=3600000;
		 }
	 }
	 else {
		 for(int i=toPoint;i<fromPoint;i--) {
			 reachTime+=3600000;
		 }
	 }
	 if(pickUpTime<reachTime) {
		 return false;
	 }
	 return true;
  }
}
