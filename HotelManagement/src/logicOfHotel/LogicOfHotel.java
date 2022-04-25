package logicOfHotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import hotel.Hotel;
import user.User;

public class LogicOfHotel {
 static int userId=0;
 static Map<String,Hotel> hotelInfo=new HashMap<>();
 static List<User> usList=new ArrayList<>();
 
  @SuppressWarnings("rawtypes")
public TreeMap sorting(String type){
	  
	  switch(type) {
	  case "Names":
		  TreeMap<String,Hotel> tre=new TreeMap<>();
		  Set<String> set=hotelInfo.keySet();
		  for(String key:set) {
			  tre.put(hotelInfo.get(key).getHotelName(),hotelInfo.get(key));
		  }
		  return tre;
		
		  
	  case "Rating":
		  TreeMap<Integer,List<Hotel>> rating=new TreeMap<>();
		  Set<String> key=hotelInfo.keySet();
		  for(String s:key) {
			 addMap(rating,s);
			  
		  }
		  return rating;
		  
	  case "Room Available":
		  TreeMap<Integer,List<Hotel>> roomAvailable=new TreeMap<>();
		  Set<String> room=hotelInfo.keySet();
		  for(String s:room) {
			  addMap2(roomAvailable,s);
		  }
		  return roomAvailable;
	  }
	  return new TreeMap<>();
  }
  public boolean isAvailable(String hotelName) {
	  if(hotelInfo.get(hotelName)==null) {
		  return false;
	  }
	  return true;
  }
  public int generatUserId() {
	  return ++userId;
  }
  public ArrayList<String> hotels(){
	  return new ArrayList<String>(hotelInfo.keySet());
  }
  public List<Hotel> locationsMatch(String locate){
	  List<Hotel> lis=new ArrayList<>();
	  Set<String> keys=hotelInfo.keySet();
	  for(String key:keys) {
		  if(hotelInfo.get(key).getLocations().equals(locate)) {
			  lis.add(hotelInfo.get(key));
		  }
	  }
	  return lis;
  }
  public void addMap(TreeMap<Integer,List<Hotel>> map,String key) {
	  List<Hotel> lis=map.get(hotelInfo.get(key).getRating());
	  if(lis==null) {
		  lis=new ArrayList<>();
		  map.put(hotelInfo.get(key).getRating(), lis);
	  }
	  lis.add(hotelInfo.get(key));
  }
  public void addMap2(TreeMap<Integer,List<Hotel>> map,String key) {
	  List<Hotel> lis=map.get(hotelInfo.get(key).getRoomsAvailable());
	  if(lis==null) {
		  lis=new ArrayList<>();
		  map.put(hotelInfo.get(key).getRoomsAvailable(), lis);
	  }
	  lis.add(hotelInfo.get(key));
  }
  public void addUser(User userObj) {
	  usList.add(userObj);
  }
  public List<User> getUser(){
	  return usList;
  }
  public void addInfo(Hotel hObj) {
	  hotelInfo.put(hObj.getHotelName(), hObj);
  }
  public Map<String,Hotel> printHotelData(){
	  return hotelInfo;
  }
  
  }

