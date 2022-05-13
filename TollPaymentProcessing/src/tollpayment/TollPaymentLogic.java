package tollpayment;
import java.util.*;
public class TollPaymentLogic {
 static int ticketNo=1000;
 static Map<Character,Map<String,Double>> tollInf=new HashMap<>();
 static Map<Character,List<Ticket>> tollPaymentInfo=new HashMap<>();
 static Map<String,List<Vehicle>> vehicleInfo=new HashMap<>();
 String points="ABCDEF";
 public void addToll(Toll tollObj) {
	 Map<String,Double> lis=tollInf.get(tollObj.getTollName());
	if(lis==null) {
		lis=new HashMap<>();
		tollInf.put(tollObj.getTollName(), lis);
	}
	lis.put(tollObj.getVehicleType(), tollObj.getAmount());
 }
 public void addTollPaymentInfo(Ticket ticketObj) {
	 List<Ticket> lis=tollPaymentInfo.get(ticketObj.getTollName());
	 if(lis==null) {
		 lis=new ArrayList<>();
		 tollPaymentInfo.put(ticketObj.getTollName(), lis);
	 }
	 lis.add(ticketObj);
 }
 public void addVehicleDetails(Vehicle vehicleObj) {
	 List<Vehicle> lis=vehicleInfo.get(vehicleObj.getVehicleNo());
	 if(lis==null) {
		 lis=new ArrayList<>();
		 vehicleInfo.put(vehicleObj.getVehicleNo(), lis);
	 }
	 lis.add(vehicleObj);
 }
 public List<Ticket> getTollPaidAmount(String vNo,String vehicleType,char start,char end,boolean VIPUser) {
	 int str=start;
	 int e=end;
	 
	 List<Ticket> lis=new ArrayList<>();
	 int st=points.indexOf(start)+1;
	 int en=points.indexOf(end)+1;
	 Vehicle vObj=new Vehicle();
	 int crossTolls=0;
	 int amountPerJ=0;
	 if(e>=str) {
	
	
	 for(int i=st;i<=en;i++) {
		
		Ticket obj=new Ticket();
		double amount=tollInf.get(points.charAt(i-1)).get(vehicleType);
		crossTolls++;
		if(VIPUser) {
			amount=amount+(20/100);
		}
		obj.setTicketNo(generateTicketNo());
		obj.setTollName(points.charAt(i-1));
		obj.setAmount(amount);
		obj.setVehicleNo(vNo);
		addTollPaymentInfo(obj);
		amountPerJ+=amount;
		
		lis.add(obj);
	 }
	 vObj.setVehicleNo(vNo);
	 vObj.setStartPosition(start);
	 vObj.setEndingPosition(end);
	 vObj.setPassedTolls(crossTolls);
	 vObj.setAmountPerJourney(amountPerJ);
	 addVehicleDetails(vObj);
	 }
	 else {
		 for(int i=st;i<=en;i++) {
				
				Ticket obj=new Ticket();
				double amount=tollInf.get(points.charAt(i-1)).get(vehicleType);
				crossTolls++;
				if(VIPUser) {
					amount=amount+(20/100);
				}
				obj.setTicketNo(generateTicketNo());
				obj.setTollName(points.charAt(i-1));
				obj.setAmount(amount);
				obj.setVehicleNo(vNo);
				addTollPaymentInfo(obj);
				amountPerJ+=amount;
				
				lis.add(obj);
			 }
			 vObj.setVehicleNo(vNo);
			 vObj.setStartPosition(start);
			 vObj.setEndingPosition(end);
			 vObj.setPassedTolls(crossTolls);
			 vObj.setAmountPerJourney(amountPerJ);
			 addVehicleDetails(vObj); 
	 }
	 return lis;
 }
 public Map<String,List<Vehicle>> getVehicleDetails(){
	 return vehicleInfo;
 }

 int mini=Integer.MAX_VALUE;
 String temp1="";
 public int  route(String temp,char start,char end) {
	 
	int min=Math.abs(temp.indexOf(end)-temp.indexOf(start))+1;
	 if(mini>min) {
		 mini=min;
		 points=temp;
		temp1=temp.substring(0,min);
	 }
	return min;
 }
 public int shortRoute(String vNo,String vehicleType,char start,char end,boolean VIPUser) {
	 String temp="ABCDEF";
	
	 int min=0;
	 for(int i=0;i<temp.length();i++) {
		 min= route(temp.substring(temp.length()-i)+temp.substring(0, temp.length()-i),start,end);
		
	 }
	return min;
 }
 public String getTollInfo(){
	 String toll="";
	 String temp="ABCDEF";
	 for(int i=0;i<temp.length();i++) {
		 List<Ticket> lis=tollPaymentInfo.get(temp.charAt(i));
		 toll+="Toll "+temp.charAt(i)+":\n";
		 int totalAmount=0;
		 if(lis==null) {
			 toll+="No vehicle passed that toll\n";
			  }
		 else {
			 for(int j=0;j<lis.size();j++) {
				 toll+="Vehicle Number is "+lis.get(j).getVehicleNo()+"\n";
				 
				 toll+="Amount paid "+lis.get(j).getAmount()+"\n";
				 totalAmount+=lis.get(j).getAmount();
			 }
			 toll+="Total Amount is "+totalAmount+"\n";
		 }
		 
		 
	 }
	 return toll;
 }
 public int generateTicketNo() {
	 return ++ticketNo;
 }
}
