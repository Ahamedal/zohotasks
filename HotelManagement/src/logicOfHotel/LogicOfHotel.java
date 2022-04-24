package logicOfHotel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import hotel.Hotel;

public class LogicOfHotel {
 static Map<String,Hotel> hotelInfo=new HashMap<>();
  public Map sorting(String type){
	  
	  switch(type) {
	  case "Names":
		  TreeMap<String,Hotel> tre=new TreeMap<>();
		  Set<String> set=hotelInfo.keySet();
		  for(String key:set) {
			  tre.put(hotelInfo.get(key).getHotelName(),hotelInfo.get(key));
		  }
		  return tre;
		
		  
	  case "Rating":
		  TreeMap<Integer,Hotel> rating=new TreeMap<>();
		  Set<String> key=hotelInfo.keySet();
		  for(String s:key) {
			  rating.put(hotelInfo.get(s).getRating(),hotelInfo.get(s));
		  }
		  return rating;
		  
	  case "Room Available":
		  TreeMap<Integer,Hotel> roomAvailable=new TreeMap<>();
		  Set<String> room=hotelInfo.keySet();
		  for(String s:room) {
			  roomAvailable.put(hotelInfo.get(s).getRoomsAvailable(), hotelInfo.get(s));
		  }
		  return roomAvailable;
	  }
	  return new HashMap<>();
  }
  public Map<String,Hotel> printHotelData(){
	  return hotelInfo;
  }
  public void addInfo(Hotel hObj) {
	  hotelInfo.put(hObj.getHotelName(), hObj);
  }
}
