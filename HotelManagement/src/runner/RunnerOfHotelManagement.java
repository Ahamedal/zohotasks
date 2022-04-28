package runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import hotel.Hotel;
import logicOfHotel.LogicOfHotel;
import user.User;

public class RunnerOfHotelManagement {
	public void filInfo() {
		LogicOfHotel hotelOb=new LogicOfHotel();
		Hotel hObject=new Hotel();
		hObject.setHotelName("ones");
		hObject.setLocations("Chennai");
		hObject.setPricePerRoom(100);
		hObject.setRating(7);
		hObject.setRoomsAvailable(7);
		hotelOb.addInfo(hObject);
		hotelOb.addLocation(hObject, hObject.getLocations());
		Hotel hObj2=new Hotel();
		hObj2.setHotelName("twos");
		hObj2.setLocations("Bengaluru");
		hObj2.setPricePerRoom(200);
		hObj2.setRoomsAvailable(5);
		hObj2.setRating(4);
		hotelOb.addInfo(hObj2);
		hotelOb.addLocation(hObj2, hObj2.getLocations());
		Hotel hObj3=new Hotel();
		hObj3.setHotelName("threess");
		hObj3.setLocations("Chennai");
		hObj3.setRating(4);
		hObj3.setRoomsAvailable(9);
		hObj3.setPricePerRoom(700);
		hotelOb.addInfo(hObj3);
		hotelOb.addLocation(hObj3, hObj3.getLocations());
	}
	public void printData() {
		Scanner sc=new Scanner(System.in);
		LogicOfHotel logicOb=new LogicOfHotel();
		User userObj=new User();
		System.out.println("Enter Your Name");
		String uNam=sc.nextLine();
		System.out.println("Hotels are:");
		System.out.println(logicOb.printHotelData());
		boolean condition=true;
		while(condition) {
		System.out.println("Enter your Hotel Name");
		String hotelName=sc.nextLine();
		if(logicOb.isAvailable(hotelName)) {
			userObj.setHotelName(hotelName);
			condition=false;
		}
		else {
			System.out.println("This "+hotelName+" is not here in this hotel management");
		}
		
		}
		System.out.println("How many rooms do you want");
		int room=sc.nextInt();
		sc.nextLine();
		userObj.setUserId(logicOb.generatUserId());
		userObj.setUserNam(uNam);
		userObj.setBookingCost(room*1000);
		logicOb.addUser(userObj);
		
	}
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	RunnerOfHotelManagement ru=new RunnerOfHotelManagement();
	LogicOfHotel logicOb=new LogicOfHotel();
	ru.filInfo();
	boolean condition1=true;
	while(condition1) {
	System.out.println("1-Print the Hotel Data\n2-Sort by Names\n3-Sort by HotelRating\n4.Print Hotel by Locations\n5-Sort hotels by Maximum Numbers Of Rooms Available\n6-UserBooking");
	int sel=sc.nextInt();
	sc.nextLine();
	switch(sel) {
	case 1:
		List<Hotel> lis=logicOb.printHotelData();
		for(int i=0;i<lis.size();i++) {
			System.out.println(lis.get(i));
		}
		break;
		
	case 2:
		List<Hotel> lis2=logicOb.sortingNames();
		for(int i=0;i<lis2.size();i++) {
			System.out.println(lis2.get(i));
		}
		break;
		
	case 3:
		List<Hotel> lis3=logicOb.sortingRating();
		for(int i=lis3.size()-1;i>=0;i--) {
			System.out.println(lis3.get(i));
		}
		break;
	case 4:
		System.out.println("Enter Your Location");
		String locate=sc.nextLine();
		List<Hotel> locateLis=logicOb.locationsMatch(locate);
		for(int i=0;i<locateLis.size();i++) {
			System.out.println(locateLis.get(i));
		}
		break;
	case 5:
		List<Hotel> lis4=logicOb.sortingRoomAvailable();
		for(int i=lis4.size()-1;i>=0;i--) {
			System.out.println(lis4.get(i));
		}
		break;
		
	case 6:
		ru.printData();
		Map<Integer,User> usr=logicOb.getUser();
		for(int i=1;i<=usr.size();i++) {
			System.out.println(usr.get(i));
		}
	
	
		break;
		
	default:
		condition1=false;
	}
}
}
}
