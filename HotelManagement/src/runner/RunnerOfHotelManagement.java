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
		Hotel hObj2=new Hotel();
		hObj2.setHotelName("twos");
		hObj2.setLocations("Bengaluru");
		hObj2.setPricePerRoom(200);
		hObj2.setRoomsAvailable(5);
		hObj2.setRating(4);
		hotelOb.addInfo(hObj2);
		Hotel hObj3=new Hotel();
		hObj3.setHotelName("threess");
		hObj3.setLocations("Chennai");
		hObj3.setRating(4);
		hObj3.setRoomsAvailable(9);
		hObj3.setPricePerRoom(700);
		hotelOb.addInfo(hObj3);
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
		System.out.println(logicOb.printHotelData());
		break;
		
	case 2:
    Map<String,Hotel> map=logicOb.sorting("Names");

	ArrayList<String> keys=new ArrayList<>(map.keySet());
	for(String key:keys) {
		System.out.println(map.get(key));
	}
	break;	
	
	case 3:
		Map<Integer,List<Hotel>> map3=logicOb.sorting("Rating");
		ArrayList<Integer> keys3=new ArrayList<>(map3.keySet());
		Collections.sort(keys3,Collections.reverseOrder());
		for(Integer key:keys3) {
		   List<Hotel> lis= map3.get(key);
		   for(int i=0;i<lis.size();i++) {
			   System.out.println(lis.get(i));
		   }
		}
		break;
		
	case 4:
		System.out.println("Enter do You need location");
		String locations=sc.nextLine();
		List<Hotel> lis=logicOb.locationsMatch(locations);
		System.out.println("Print for "+locations+" Location is:");
		for(int i=0;i<lis.size();i++) {
			System.out.println(lis.get(i));
		}
		break;
	case 5:
		Map<Integer,List<Hotel>> map4=logicOb.sorting("Room Available");
		ArrayList<Integer> keys4=new ArrayList<>(map4.keySet());
		Collections.sort(keys4,Collections.reverseOrder());
		for(Integer key:keys4) {
		List<Hotel> lis4=map4.get(key);
		for(int i=0;i<lis4.size();i++) {
			System.out.println(lis4.get(i));
		}
		}
		break;
		
	case 6:
		
		System.out.println(" If You Have to book to Hotel if yes-true ,no-false");
		boolean booking=sc.nextBoolean();
		if(booking) {
			ru.printData();
			List<User> usr=logicOb.getUser();
			for(int i=0;i<usr.size();i++) {
				System.out.println(usr.get(i));
			}
		}
		else {
			System.out.println("Ok,Thankyou");
		}
		break;
		
	default:
		condition1=false;
	}
}
}
}
