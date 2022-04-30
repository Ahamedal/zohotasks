package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.CustomException;
import passengers.Passenger;
import railwayreservationlogic.RailwayReservationLogic;
import seat.Berth;
import ticket.Ticket;

public class RailwayReservationRunner {
	public void seat() throws CustomException {
		RailwayReservationLogic logicOb=new RailwayReservationLogic();
		for(int i=1;i<3;i++) {
			Berth bert=new Berth();
			bert.setBerthType("Lower");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
			
		}
		for(int i=1;i<3;i++) {
			Berth bert=new Berth();
			bert.setBerthType("Middle");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
		}
		for(int i=1;i<3;i++) {
			Berth bert=new Berth();
			bert.setBerthType("Upper");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
		}
		for(int i=1;i<2;i++) {
			Berth bert=new Berth();
			bert.setBerthType("RAC");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
		}
		for(int i=1;i<2;i++) {
			Berth bert=new Berth();
			bert.setBerthType("WL");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
		}
		
	}
	public void booking() throws CustomException {
		Scanner sc=new Scanner(System.in);
		RailwayReservationLogic logicOb=new RailwayReservationLogic();
		Ticket ticketObj=new Ticket();
		boolean condition2=true;
		int mem=0;
		while(condition2) {
		System.out.println("How Many memeber you have to book");
		mem=sc.nextInt();
		sc.nextLine();
		if(mem>6||mem<=0) {
			System.out.println("Only 6 memebers to book in one time");
		}
		else {
			condition2=false;
		}
		}
		
		boolean flag=true;
		if(logicOb.getWaitingList()!=0) {
			
		for(int i=0;i<mem;i++) {
		Passenger p=new Passenger();
		System.out.println("Enter Name");
		String name=sc.nextLine();
		System.out.println("Enter age");
		int age=sc.nextInt();
	    sc.nextLine();
	    System.out.println("Enter Your genter");
	    String gend=sc.nextLine();
	    System.out.println("Enter Birth Preference 1-Lower 2-Upper 3-Middle");
	    int sel=sc.nextInt();
	    sc.nextLine();
	    String berth="";
	    switch(sel) {
	    case 1:
	    	berth="Lower";
	    	break;
	    case 2:
	    	berth="Upper";
	    	break;
	    case 3:
	    	berth="Middle";
	    	break;
	    	
	    default:
	    	System.out.println("Enter Proper Birth Preference");
	    }
	    if(flag) {
	    p.setTicketNo(logicOb.generatTicketNo());
	    flag=false;
	    }
	    else {
	     p.setTicketNo(logicOb.getTicketNo());
	    }
	    p.setAge(age);
	    p.setBerthPreference(berth);
	    p.setGender(gend);
	    p.setPassengerName(name);
	    logicOb.bookingTicket(p);
		}
		ticketObj.setFromPlace("Ramnad");
		ticketObj.setToPlace("Karaikudi");
		ticketObj.setNoOfPassengers(mem);
		ticketObj.setTicketNumber(logicOb.getTicketNo());
		ticketObj.setDepartureTime(System.currentTimeMillis());
		ticketObj.setArrivalTime(System.currentTimeMillis()+3600000);
		ticketObj.setAmount(mem*100);
		logicOb.addTicket(ticketObj);
		System.out.println("Booked Successfully , Your ticket No is "+logicOb.getTicketNo());
	}
	
	else {
		System.out.println("All Tickets Are Booking so,not available");
	}
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	RailwayReservationRunner run=new RailwayReservationRunner();
	RailwayReservationLogic logicOb=new RailwayReservationLogic();
	try {
	run.seat();
	}
	catch(CustomException e) {
		System.out.println(e.getMessage());
	}
	boolean condition=true;
	while(condition) {
	System.out.println("1.Ticket Booking \n2.Ticket Cancel\n3.Print Booked Tickets\n4.Print Available Tickets");
	int sel=sc.nextInt();
	sc.nextLine();
	switch(sel) {
	case 1:
		try {
		run.booking();
		}
		catch(CustomException e) {
			System.out.println(e.getMessage());
		}
		
		break;
		
	case 2:
		try {
		System.out.println("Enter Your Ticket No");
		int ticketNo=sc.nextInt();
		sc.nextLine();
		
		List<Passenger> lis=logicOb.cancelTicket1(ticketNo);
		System.out.println("How many customers you Want to Cancel Enter 1-full 2-Parcial");
		int can=sc.nextInt();
		sc.nextLine();
				
		if(can==1) {
			for(int i=0;i<lis.size();i++) {
				
				logicOb.cancelTicket(lis.get(i));
			}
			logicOb.removeTicket(ticketNo);
		}
		else {
			for(int i=1;i<=lis.size();i++) {
				System.out.println("Enter "+i+"-"+lis.get(i-1));
			}
			List<Passenger> li=new ArrayList<>();
		System.out.println("You Enter Cancel Customer number with the comma separator\nex-1,2,3,...");
		String cancel=sc.nextLine();
		if(cancel.contains(",")) {
		for(String s:cancel.split(",")) {
			
			logicOb.cancelTicket(lis.get(Integer.valueOf(s)-1));
			li.add(lis.get(Integer.valueOf(s)-1));
			
		}
		for(int i=0;i<li.size();i++) {
			logicOb.removeTicket1(ticketNo,li.get(i));
		}
		}
		else {
			logicOb.cancelTicket(lis.get(Integer.valueOf(cancel)-1));
			logicOb.removeTicket1(ticketNo,lis.get(Integer.valueOf(cancel)-1));
		}
		
		}
		
		
		System.out.println("Cancel Successfully");
		}
		catch(CustomException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		break;
		
	case 3:
		System.out.println("Enter 1-Passenger Details 2-Ticket Details");
		int se=sc.nextInt();
		sc.nextLine();
		switch(se) {
		case 1:
			System.out.println(logicOb.bookedTickets());
			break;
			
		case 2:
			System.out.println(logicOb.bookedTicketDetails());
			break;
		}
		
		break;
		
	case 4:
		System.out.println(logicOb.printAvailable());
		break;
	}
	}
}
}
