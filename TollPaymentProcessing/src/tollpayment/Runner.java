package tollpayment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {
 
	public void setTollInfo() {
		TollPaymentLogic toll=new TollPaymentLogic();
		Toll to=new Toll();
		to.setTollName('A');
		to.setVehicleType("Car");
		to.setAmount(100);
		toll.addToll(to);
		Toll tollObj=new Toll();
		tollObj.setTollName('A');
		tollObj.setVehicleType("Bus");
		tollObj.setAmount(125);
		toll.addToll(tollObj);
		Toll to11=new Toll();
		to11.setTollName('B');
		to11.setVehicleType("Car");
		to11.setAmount(102);
		toll.addToll(to11);
		Toll tollObj11=new Toll();
		tollObj11.setTollName('B');
		tollObj11.setVehicleType("Bus");
		tollObj11.setAmount(120);
		toll.addToll(tollObj11);
		Toll toc=new Toll();
		toc.setTollName('C');
		toc.setVehicleType("Car");
		toc.setAmount(120);
		toll.addToll(toc);
		Toll tob=new Toll();
		tob.setTollName('C');
		tob.setVehicleType("Bus");
		tob.setAmount(120);
		toll.addToll(tob);
		Toll dToll=new Toll();
		dToll.setTollName('D');
		dToll.setVehicleType("Car");
		dToll.setAmount(120);
		toll.addToll(dToll);
		Toll dToll1=new Toll();
		dToll1.setTollName('D');
		dToll1.setVehicleType("Bus");
		dToll1.setAmount(150);
		toll.addToll(dToll1);
		Toll eToll=new Toll();
		eToll.setTollName('E');
		eToll.setVehicleType("Car");
		eToll.setAmount(110);
		toll.addToll(eToll);
		Toll eToll1=new Toll();
		eToll1.setTollName('E');
		eToll1.setVehicleType("Bus");
		eToll1.setAmount(160);
		toll.addToll(eToll1);
		Toll fToll=new Toll();
		fToll.setTollName('F');
		fToll.setVehicleType("Car");
		fToll.setAmount(110);
		toll.addToll(fToll);
		Toll fToll1=new Toll();
		fToll1.setTollName('F');
		fToll1.setVehicleType("Bus");
		fToll1.setAmount(200);
		toll.addToll(fToll1);
		
		
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Runner obj=new Runner();
		obj.setTollInfo();
		TollPaymentLogic objForLogic=new TollPaymentLogic();
		boolean condition=true;
		while(condition) {
			System.out.println("1.Payment per toll 2.Display details of toll 3.Display details of vehicle");
			int sel=sc.nextInt();
			sc.nextLine();
			
		switch(sel) {
		case 1:
			System.out.println("Enter your vehicle number");
			String vNo=sc.nextLine();
			System.out.println("Enter vehicle type");
			String vehicle=sc.nextLine();
			System.out.println("Toll gate [A,B,C,D,E,F]");
			System.out.println("Enter Start position");
			char start=sc.next().charAt(0);
			System.out.println("Enter Your Destination");
			char end=sc.next().charAt(0);
			System.out.println("is VIP user true or false");
			boolean isVIP=sc.nextBoolean();
			List<Ticket> lis=objForLogic.getTollPaidAmount(vNo,vehicle,start,end,isVIP);
			int totalAmount=0;
			for(int i=0;i<lis.size();i++) {
			totalAmount+=lis.get(i).getAmount();
			System.out.println(lis.get(i)+"\n");
			}
			System.out.println("Total amount is "+totalAmount);
			break;
			
		case 2:
			System.out.println(objForLogic.getTollInfo());
			break;
			
		case 3:
			System.out.println(objForLogic.getVehicleDetails());
			break;
			
		case 4:
			System.out.println("Enter your vehicle number");
			String vNo4=sc.nextLine();
			System.out.println("Enter vehicle type");
			String vehicle2=sc.nextLine();
			System.out.println("Toll gate [A,B,C,D,E,F]");
			System.out.println("Enter Start position");
			char start1=sc.next().charAt(0);
			System.out.println("Enter Your Destination");
			char end1=sc.next().charAt(0);
			System.out.println("is VIP user true or false");
			boolean isVIP1=sc.nextBoolean();
			System.out.println(objForLogic.shortRoute(vNo4,vehicle2,start1,end1,isVIP1));
			System.out.println(objForLogic.temp1);
			List<Ticket> lis4=objForLogic.getTollPaidAmount(vNo4,vehicle2,start1,end1,isVIP1);
			int totalAmount11=0;
			for(int i=0;i<lis4.size();i++) {
			totalAmount11+=lis4.get(i).getAmount();
			System.out.println(lis4.get(i)+"\n");
			}
			System.out.println("Total amount is "+totalAmount11);
			break;
			
		
		}
		}
	}
}
