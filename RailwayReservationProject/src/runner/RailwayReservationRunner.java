package runner;

import java.util.Scanner;

import passengers.Passenger;
import railwayreservationlogic.RailwayReservationLogic;
import seat.Berth;

public class RailwayReservationRunner {
	public void seat() {
		RailwayReservationLogic logicOb=new RailwayReservationLogic();
		for(int i=1;i<2;i++) {
			Berth bert=new Berth();
			bert.setBerthType("Lower");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
			
		}
		for(int i=1;i<2;i++) {
			Berth bert=new Berth();
			bert.setBerthType("Middle");
			bert.setSeatNo(i);
			logicOb.addSeat(bert);
		}
		for(int i=1;i<2;i++) {
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
		
	}
	public void booking() {
		Scanner sc=new Scanner(System.in);
		RailwayReservationLogic logicOb=new RailwayReservationLogic();
		System.out.println("How Many memeber you have to book");
		int mem=sc.nextInt();
		sc.nextLine();
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
		System.out.println("Booked Successfully , Your ticket No is"+logicOb.getTicketNo());
	}
	
	else {
		System.out.println("All Tickets Are Booking so,not available");
	}
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	RailwayReservationRunner run=new RailwayReservationRunner();
	RailwayReservationLogic logicOb=new RailwayReservationLogic();
	run.seat();
	boolean condition=true;
	while(condition) {
	System.out.println("1.Ticket Booking \n2.Ticket Cancel\n3.Print Booked Tickets\n4.Print Available Tickets");
	int sel=sc.nextInt();
	sc.nextLine();
	switch(sel) {
	case 1:
		run.booking();
		
		break;
		
	case 2:
		System.out.println("Enter Your Ticket No");
		int ticketNo=sc.nextInt();
		sc.nextLine();
		logicOb.cancelTicket(ticketNo);
		break;
		
	case 3:
		System.out.println(logicOb.printAvailable());
		break;
		
	case 4:
		System.out.println(logicOb.bookedTickets());
		break;
	}
	}
}
}
