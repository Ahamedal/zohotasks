package cityroutestructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CityRoute {

	List<String> city=new ArrayList<>();
	Map<String,City> cityRoutes=new HashMap<>();
	
	public void initialSetup() {
		city.add("A");
		
		addRoutes("A","B",20);
		addRoutes("A","C",45);
		addRoutes("A","D",25);
		addRoutes("B","F",90);
		addRoutes("B","G",35);
		addRoutes("C","E",10);
		addRoutes("D","G",30);
		addRoutes("E","H",35);
		addRoutes("F","G",30);
		addRoutes("G","H",40);
		
		
	}
	public String addRoutes(String fromPlace,String toPlace,int distance) {
		if(!city.contains(fromPlace)) {
			return "Route cannot be added because +"+fromPlace+" does not exist";
		}
		
		City cityObj=cityRoutes.get(fromPlace);
		City cityObj2=cityRoutes.get(toPlace);
		if(cityObj==null) {
			cityObj=new City();
			cityObj.setCityName(fromPlace);
			cityRoutes.put(fromPlace, cityObj);
		}
		
		if(cityObj2==null) {
			cityObj2=new City();
			cityObj2.setCityName(toPlace);
			cityRoutes.put(toPlace, cityObj2);
		}
		Map<String,Integer> map=cityObj.getRoutes();
		Map<String,Integer> map2=cityObj2.getRoutes();
		if(map.containsKey(toPlace)) {
			return "Route already exist";
		}
		map.put(toPlace, distance);
		map2.put(fromPlace,distance);
		if(!city.contains(toPlace)) {
			city.add(toPlace);
			return "Route added between"+fromPlace+" and "+toPlace+" with distance "+distance+ "." +toPlace+" is a new city that will also get added.";
		}
		return "New Route Added";
	}
	public Map<List<String>,Integer> findAllRoutes(String fromPlace,String toPlace) {
		Map<List<String>,Integer> map=new HashMap<>();
		City ci=cityRoutes.get(fromPlace);
	    City ci2=cityRoutes.get(toPlace);
	    if(ci!=null&&ci2!=null) {
	    	Set<String> availableCity=ci.getRoutes().keySet();
	    	List<String> route=new ArrayList<>();
	    	route.add(fromPlace);
	    	findRoutes(availableCity,toPlace,route,map);
	    		
	    	}
	    else {
	    	List<String> lis=new ArrayList<>();
	    	lis.add("City not found");
	    	map.put(lis, 0);
	    }
	    return map;
		
	}
	public void findRoutes(Set<String> cityNames, String destination, List<String> routes,Map<List<String>,Integer> allRout){

	       Set<String>routeNames=new HashSet<>();
	       routeNames.addAll(cityNames);
	       routeNames.removeAll(routes);
	        for(String cityName:routeNames){
	            if(!destination.equals(cityName)){
	                City city=cityRoutes.get(cityName);
	                Set<String>cityNames1=city.getRoutes().keySet();
	                routes.add(cityName);
	                findRoutes(cityNames1, destination,routes,allRout);
	            }else {
	                routes.add(destination);
	                List<String>successRoutes=new ArrayList<>();
	                successRoutes.addAll(routes);
	                int distance=findDistance(successRoutes);
	                allRout.put(successRoutes,distance);
	                
	            }
	            routes.remove(cityName);
	        }
	    }
//	public void findRoutes(Set<String> availablePath,String toPlace,Set<String> route,Map<List<String>,Integer> allRout,String fromPlace) {
//		availablePath.remove(fromPlace);
//		for(String path:availablePath) {
//			if(!path.equals(toPlace)) {
//				City cit=cityRoutes.get(path);
//				Set<String> set=cit.getRoutes().keySet();
//				route.add(path);
//				findRoutes(set,toPlace,route,allRout,fromPlace);
//				
//			}
//			else {
//				route.add(toPlace);
//				List<String> lis=new ArrayList<>();
//				lis.addAll(route);
//				int distance=findDistance(lis);
//				allRout.put(lis, distance);
//				route.remove(toPlace);
//			} 
//			route.removeAll(availablePath);
//		}
//	}
	public Map<List<String>,Integer> getShortestRoute(Map<List<String>,Integer> allRoutes){
		int min=Integer.MAX_VALUE;
		Map<List<String>,Integer> shorestRoute=new HashMap<>();
		Set<List<String>> all=allRoutes.keySet();
		for(List<String> lis:all) {
			int dis=allRoutes.get(lis);
			if(dis<min) {
				min=dis;
				shorestRoute.clear();
				shorestRoute.put(lis, dis);
			}
			else if(dis==min) {
				shorestRoute.put(lis, dis);
			}
			
		}
		return shorestRoute;
	}
	public int findDistance(List<String> routes) {
		int distance=0;
		for(int i=0;i<routes.size()-1;i++) {
			String from=routes.get(i);
			String to=routes.get(i+1);
			City city=cityRoutes.get(from);
			int dis=city.getRoutes().get(to);
			distance+=dis;
		}
		return distance;
	}
	public String deleteRoute(String cit1,String cit2) {
		City cityOb1=cityRoutes.get(cit1);
		City cityOb=cityRoutes.get(cit2);
		if(cityOb1==null||cityOb==null) {
			return "("+cit1+","+cit2+") route not found";
		}
		if(cityOb1.getRoutes().get(cit2)==null) {
			return "("+cit1+","+cit2+") route not found";
		}
		if(cityOb1.getRoutes().size()==1||cityOb.getRoutes().size()==1) {
			return "route cannot be deleted either one city isolated from other cities without any route";
		}
		cityOb1.getRoutes().remove(cit2);
		cityOb.getRoutes().remove(cit1);
		return "Route ("+cit1+","+cit2+") deleted";
	}
	public List<String> busyCity(){
		List<String> buCity=new ArrayList<>();
		int max=Integer.MIN_VALUE;
		for(String s:cityRoutes.keySet()) {
			City city=cityRoutes.get(s);
			int k=city.getRoutes().size();
			if(k>max) {
				max=k;
				buCity.clear();
				buCity.add(s);
			}
			else if(k==max) {
				buCity.add(s);
			}
		}
		return buCity;
	}
}
