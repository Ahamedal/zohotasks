package railwayreservationlogic;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CustomException;
import passengers.Passenger;
import seat.Berth;
import ticket.Ticket;
public class RailwayReservationLogic {
	static int availableLowerBerth=2;
	static int availableUpperBerth=2;
	static int availableMiddleBerth=2;
	static int availableRAC=1;
   	static int availableWaitingList=1;
	
    static int ticketNo=0;
    
   static Map<String,List<Berth>> availableSeats=new HashMap<>();
   static Map<Integer,List<Passenger>> passengersInfo=new HashMap<>();
   static Map<Integer,Ticket> ticketInfo=new HashMap<>();
   static List<Passenger> RACList=new ArrayList<>();
   static List<Passenger> waitingList=new ArrayList<>();
  
   public void addSeat(Berth seat) throws CustomException {
	   nullCheck(seat);
	  List<Berth> lis=availableSeats.get(seat.getBerthType());
	  if(lis==null) {
		  lis=new ArrayList<>();
		  availableSeats.put(seat.getBerthType(), lis);
	  }
	  lis.add(seat);
   }
  
   public void addTicket(Ticket tObj) {
	ticketInfo.put(tObj.getTicketNumber(), tObj)   ;
   }
   public void bookTicket(Passenger pass,Berth b) throws CustomException {
	   nullCheck(pass);
	   nullCheck(b);
	   pass.setStatus("Booked");
	   pass.setBerthType(b.getBerthType());
	   pass.setSeatNo(b.getSeatNo());
	   
	   List<Passenger> lis=passengersInfo.get(pass.getTicketNo());
	   if(lis==null) {
		   lis=new ArrayList<>();
		   passengersInfo.put(pass.getTicketNo(),lis);
	   }
	   lis.add(pass);
	   
	   
   }
   public void addToRACTicket(Passenger pass,Berth b) throws CustomException {
	   nullCheck(pass);
	   nullCheck(b);
	   pass.setStatus("RAC");
	   pass.setBerthType(b.getBerthType());
	   pass.setSeatNo(b.getSeatNo());
	   
	   List<Passenger> lis=passengersInfo.get(pass.getTicketNo());
	   if(lis==null) {
		   lis=new ArrayList<>();
		   passengersInfo.put(pass.getTicketNo(),lis);
	   }
	   lis.add(pass);
	   RACList.add(pass);
   }
   public void addToWLTicket(Passenger pass,Berth b) throws CustomException {
	   nullCheck(pass);
	   nullCheck(b);
	  pass.setStatus("WL");
	  
	   List<Passenger> lis=passengersInfo.get(pass.getTicketNo());
	   if(lis==null) {
		   lis=new ArrayList<>();
		   passengersInfo.put(pass.getTicketNo(),lis);
	   }
	   lis.add(pass);
	   
	   waitingList.add(pass);
   }
   public int generatTicketNo() {
	   return ++ticketNo;
   }
   public  void bookingTicket(Passenger pObj) throws CustomException {
	  nullCheck(pObj);
		     
	   if(pObj.getAge()>5) {
	   if(pObj.getBerthPreference().equals("Lower")&&availableLowerBerth>0) {
		   bookTicket(pObj,availableSeats.get("Lower").get(0));
		   availableSeats.get("Lower").remove(0);
		   availableLowerBerth--;
		   
		   
	   }
	   else if(pObj.getBerthPreference().equals("Middle")&&availableMiddleBerth>0) {
		   bookTicket(pObj,availableSeats.get("Middle").get(0));
		   availableSeats.get("Middle").remove(0);
		   availableMiddleBerth--;
		   
		   
	   }
	   else if(pObj.getBerthPreference().equals("Upper")&&availableUpperBerth>0) {
		   bookTicket(pObj,availableSeats.get("Upper").get(0));
		   availableSeats.get("Upper").remove(0);
		   availableUpperBerth--;
		   
		   
	   }
	   else if(availableLowerBerth>0) {
		   bookTicket(pObj,availableSeats.get("Lower").get(0));
		   availableSeats.get("Lower").remove(0);
		   availableLowerBerth--;
		   
	   }
	   else if(availableMiddleBerth>0) {
		   bookTicket(pObj,availableSeats.get("Middle").get(0));
		   availableSeats.get("Middle").remove(0);
		   availableMiddleBerth--;
		   
	   }
	   else if(availableUpperBerth>0) {
		   bookTicket(pObj,availableSeats.get("Upper").get(0));
		   availableSeats.get("Upper").remove(0);
		   availableUpperBerth--;
		   
	   }
	   else if(availableRAC>0) {
		   addToRACTicket(pObj,availableSeats.get("RAC").get(0));
		   availableSeats.get("RAC").remove(0);
		   availableRAC--;
		   
	   }
	   else if(availableWaitingList>0) {
		   addToWLTicket(pObj,availableSeats.get("WL").get(0));
		   availableSeats.get("WL").remove(0);
		  
		   availableWaitingList--;
		   
	   }
	   }
	   else {
		   if(availableRAC>0) {
		   pObj.setStatus("RAC");
		   }
		   else if(availableRAC==0&&availableWaitingList>0) {
			   pObj.setStatus("WL");
		   }
		   List<Passenger> lis=passengersInfo.get(pObj.getTicketNo());
		   if(lis==null) {
			   lis=new ArrayList<>();
			   passengersInfo.put(pObj.getTicketNo(),lis);
		   }
		   lis.add(pObj);  
	   }
	   
   }
   public void RACRemove(Passenger p) throws CustomException {
	   nullCheck(p);
	   RACList.remove(p);
	   if(waitingList.size()>0) {
		   Passenger pasWLis=waitingList.get(0);
			  
		   waitingList.remove(0);
		   addToRACTicket(pasWLis,availableSeats.get("RAC").get(0));
		   availableSeats.get("RAC").remove(0);
		   availableRAC--;
		 
		   bookingTicket(pasWLis);
		   availableWaitingList++;
	   }
   }
   public void removeWaitingList(Passenger p) throws CustomException {
	     nullCheck(p);
		   waitingList.remove(p);
	 
   }
   public List<Passenger> cancelTicket1(int tNo) throws CustomException {
	   checkTicketNo(tNo);
	   List<Passenger> pass=passengersInfo.get(tNo);
	   return pass;
   }
   public void removeTicket1(int tNo,Passenger p) {
	   List<Passenger> lis=passengersInfo.get(tNo);
	   lis.remove(p);
   }
   public void removeTicket(int tNo) {
	   
	   passengersInfo.remove(tNo);
   }
   public void cancelTicket(Passenger p) throws CustomException {
//	   checkTicketNo(tNo);
	   Berth b=new Berth();
//	   List<Passenger> pass=passengersInfo.get(tNo);
//	   passengersInfo.remove(tNo);
//	   for(int i=0;i<pass.size();i++) {
//	   Passenger p=pass.get(i);
	  
	   int seatNumber=p.getSeatNo();
	   String berthType=p.getBerthType();
	   b.setBerthType(berthType);
	   b.setSeatNo(seatNumber);
	   addSeat(b);
	   if(berthType.equals("RAC")) {
		   availableRAC++;
		   RACRemove(p);
	   }
	   else if(berthType.equals("WL")) {
		   availableWaitingList++;
		   removeWaitingList(p);
	   }
	   else {
	   if(berthType.equals("Lower")) {
		   availableLowerBerth++;
	   }
	   else if(berthType.equals("Middle")) {
		   availableMiddleBerth++;
	   }
	   else  if(berthType.equals("Upper")) {
		   availableUpperBerth++;
	   }
	   
	   
	   if(RACList.size()>0) {
		   Berth b1=new Berth();
		   Passenger passRAC=RACList.get(0);
		   int seatNumber2=passRAC.getSeatNo();
		   b1.setSeatNo(seatNumber2);
		   String berthType2=passRAC.getBerthType();
		   b1.setBerthType(berthType2);
		   addSeat(b1);
		   passengersInfo.remove(passRAC.getTicketNo());
		   RACList.remove(0);
		   availableRAC++;
		   if(waitingList.size()>0) {
			   Passenger passWL=waitingList.get(0);
			  
			   waitingList.remove(0);
			   passengersInfo.remove(passWL.getTicketNo());
			   addToRACTicket(passWL,availableSeats.get("RAC").get(0));
			  
			   availableSeats.get("RAC").remove(0);
			   availableRAC--;
			   availableWaitingList++;
			   
		   }
		   
		
		bookingTicket(passRAC)  ;
	   }
	   }
	   
   }
   public String printAvailable() {
	   String available="";
	   available+="Available Lower Berths "+availableLowerBerth;
	   available+="\nAvailable Middle Berths "+availableMiddleBerth;
	   available+="\nAvailable Upper Berths "+availableUpperBerth;
	   available+="\nAvailable RAC "+availableRAC;
	   available+="\nAvailable Waiting List "+availableWaitingList;
	   int total=availableLowerBerth+availableMiddleBerth+availableUpperBerth+availableRAC+availableWaitingList;
	   available+="\ntotal no of availble tickets "+total;
	   return available;
   }
  public Map<Integer,Ticket> bookedTicketDetails(){
	  return ticketInfo;
  }
   public Map<Integer,List<Passenger>> bookedTickets(){
	   return passengersInfo;
   }
   public int getWaitingList() {
	   return availableWaitingList;
   }
   public int getTicketNo() {
	   return ticketNo;
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
	private void checkTicketNo(int tNo) throws CustomException {
		if(passengersInfo.get(tNo)==null) {
			throw new CustomException("This token no is does not exist");
		}
	}
}
