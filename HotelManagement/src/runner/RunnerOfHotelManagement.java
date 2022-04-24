package runner;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import hotel.Hotel;
import logicOfHotel.LogicOfHotel;

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
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	RunnerOfHotelManagement ru=new RunnerOfHotelManagement();
	LogicOfHotel lo=new LogicOfHotel();
	ru.filInfo();
	boolean condition1=true;
	while(condition1) {
	System.out.println("1-Print the Hotel Data\n2-Sort by Names\n3-Sort by HotelRating\n4-Sort hotels by Maximum Numbers Of Rooms Available");
	int sel=sc.nextInt();
	sc.nextLine();
	switch(sel) {
	case 1:
		System.out.println(lo.printHotelData());
		break;
		
	case 2:
		Map<String,Hotel> map=lo.sorting("Names");
		Set<String> key=map.keySet();
		for(int i=0;i<key.size();i++) {
			System.out.println(map.get(key));
		}
		
		
	}
}
}
}
