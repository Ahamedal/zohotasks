package logicOfHotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hotel.Hotel;
import user.User;

public class LogicOfHotel {
	 static int userId=0;
	 static ArrayList<Hotel> hotelInfo=new ArrayList<>();
	 static List<String> hotelNames=new ArrayList<>();
	 static Map<String,List<Hotel>> hotelBasedLocation=new HashMap<>();
	 static Map<Integer,User> usrInfo=new HashMap<>();
	 
	 
	public class compareNames implements Comparator<Hotel>{
		@Override
		public int compare(Hotel o1, Hotel o2) {
			   
			return o1.getHotelName().compareTo(o2.getHotelName());
		}
	}
	public class compareRating implements Comparator<Hotel>{
		@Override
		public int compare(Hotel o1, Hotel o2) {
			   if(o1.getRating()>o2.getRating()) {
				   return 1;
			   }
			   else if(o1.getRating()==o2.getRating()) {
				   return 0;
			   }
			   else {
				   return -1;
			   }
		}
	}
	public class compareRoomAvailable implements Comparator<Hotel>{

		@Override
		public int compare(Hotel o1, Hotel o2) {
			if(o1.getRoomsAvailable()>o2.getRoomsAvailable()) {
				return 1;
				
			}
			else if(o1.getRoomsAvailable()==o2.getRoomsAvailable()) {
				return 0;
			}
			else {
				return -1;
			}
		}
		
	}

 public List<Hotel> sortingNames(){
	 Collections.sort(hotelInfo, new compareNames());
	 return hotelInfo;
 }
 public List<Hotel> sortingRating(){
	 Collections.sort(hotelInfo, new compareRating());
	 return hotelInfo;
 }
 public List<Hotel> sortingRoomAvailable(){
	 Collections.sort(hotelInfo, new compareRoomAvailable());
	 return hotelInfo;
 }
 public List<Hotel> locationsMatch(String locate){
	return hotelBasedLocation.get(locate);
 }
 public void addLocation(Hotel hotelOb,String locate) {
	 
	 List<Hotel> lis=hotelBasedLocation.get(locate);
	 if(lis==null) {
		 lis=new ArrayList<>();
		 hotelBasedLocation.put(locate, lis);
	 }
	 lis.add(hotelOb);
 }
 
 public int generatUserId() {
	  return ++userId;
 }
 public void addUser(User userObj) {
	  usrInfo.put(userObj.getUserId(), userObj);
 }
 public Map<Integer,User> getUser(){
	  return usrInfo;
 }
 public boolean isAvailable(String name ) {
	 if(hotelNames.contains(name)) {
		 return true;
	 }
	 return false;
 }
 

  public void addInfo(Hotel hObj) {
	  hotelNames.add(hObj.getHotelName());
	  hotelInfo.add(hObj);
  }
  public List<Hotel> printHotelData(){
	  return hotelInfo;
  }
  
  }

