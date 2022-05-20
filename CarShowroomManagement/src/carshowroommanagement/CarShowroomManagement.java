package carshowroommanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarShowroomManagement {

	static Map<Integer,Car> soldCar=new HashMap<>();
	static Map<String,Map<String,Branch>> branch=new HashMap<>();
	static Map<String,Map<String,List<Car>>> totalCarStocks=new HashMap<>();
	static Map<String,City> city=new HashMap<>();
	String firstSold=null;
	String recentlySold=null;
	static int carNumber=0;
	public Car buyCar(String cityName,String branchName,String model) {
		List<Car> lis=totalCarStocks.get(branchName).get(model);
		if(lis==null) {
			return null;
		}
		if(lis.size()==0) {
			return null;
		}
		Car car=lis.get(0);
		
	    Branch brn=branch.get(cityName).get(branchName);
	    brn.setAvailableStocks(brn.getAvailableStocks()-1);
	    brn.setSoldStocks(brn.getSoldStocks()+1);
	    soldCar.put(car.getCarNumber(), car);
	    City ci=city.get(cityName);
	    if(model.equals("SELTOS")) {
	    ci.setTotalStackForSheltos(ci.getTotalStackForSheltos()-1);
	    }
	    else {
	    ci.setTotalStackForSonet(ci.getTotalStackForSonet()-1);
	    }
	    if(firstSold==null) {
	    	firstSold=cityName;
	    }
	    recentlySold=cityName;
	    if(model.equals("SONET")) {
	    	ci.setSONETSold(ci.getSONETSold()+1);
	    }
	    else {
	    	ci.setSELTOSSold(ci.getSELTOSSold()+1);
	    }
	    if(ci.getSELTOSSold()>ci.getSONETSold()) {
			   ci.setMostSoldCar("SELTOS");
		   }
		   else {
			   ci.setMostSoldCar("SONET");
		   }
	    totalCarStocks.get(branchName).get(model).remove(0);
	    return car;
		
	}
	
	public void addCar(Car carObj,int sheldon) {
		String cityNam=carObj.getCity();
		String branchName=carObj.getBranch();
		String carType=carObj.getCarModel();
		Map<String,List<Car>> map=totalCarStocks.get(branchName);
		if(map==null) {
			map=new HashMap<>();
			totalCarStocks.put(branchName,map);
		}
	    List<Car> lis=map.get(carType);
	    if(lis==null) {
	    	lis=new ArrayList<>();
	    	map.put(carType, lis);
	    }
	    lis.add(carObj);
	   Branch brn= branch.get(cityNam).get(branchName);
	   brn.setAvailableStocks(brn.getAvailableStocks()+sheldon);
	   City ci=city.get(cityNam);
	   if(carType.equals("SELTOS")) {
		   ci.setTotalStackForSheltos(ci.getTotalStackForSheltos()+sheldon);
	   }
	   else {
		   ci.setTotalStackForSonet(ci.getTotalStackForSonet()+sheldon);
	   }
	   
	    
	}
	public void addBranch(Branch branchObj) {
		String cityNam=branchObj.getCityName();
		String branchName=branchObj.getBranchName();
		Map<String,Branch> map=branch.get(cityNam);
		if(map==null) {
			map=new HashMap<>();
			branch.put(cityNam, map);
		}
		map.put(branchName, branchObj);
	}
	public void addCity(City cityObj) {
	city.put(cityObj.getCityName(), cityObj);
	}
	public String firstSoldCar() {
		return firstSold;
	}
	public String recentlyCar() {
		
		return recentlySold;
	}
	public List<String> addTStackForSheltos(){
		List<String> lis=new ArrayList<>();
		for(String key:city.keySet()) {
			
			if(city.get(key).getTotalStackForSheltos()<2) {
				lis.add(key);
			}
		}
		return lis;
	}
	public List<String> addTStackForSonet(){
		List<String> lis=new ArrayList<>();
		for(String key:city.keySet()) {
			
			if(city.get(key).getTotalStackForSonet()<2) {
				lis.add(key);
			}
		}
		return lis;
	}
	public void putTree(int key,String value,TreeMap<Integer,List<String>> treeMap) {
		List<String> lis=treeMap.get(key);
		if(lis==null) {
			lis=new ArrayList<>();
			treeMap.put(key, lis);
		}
		lis.add(value);
	}
	
	public String orderCitySaleMostCar() {
		String res="";
		TreeMap<Integer, List<String>> tree=new TreeMap<>();
		for(String key:city.keySet()) {
			String mostCar=city.get(key).getMostSoldCar();
			if(mostCar==null) {
				
				putTree(0,"No sales in the "+key,tree);
			}
			else {
				if(mostCar.equals("SELTOS")) {
					putTree(city.get(key).getSELTOSSold(), city.get(key).getSELTOSSold()+" SELTON car mostly sale in the "+key,tree);
				}
				else {
					putTree(city.get(key).getSONETSold(),city.get(key).getSONETSold()+" SONET car mostly sale in the "+key,tree);
				}
			}
			
		}
		for(Integer key:tree.keySet()) {
			List<String> lis=tree.get(key);
			for(int j=0;j<lis.size();j++) {
				res=lis.get(j)+"\n"+res;
			}
		}
		
	   return res;	
	}
   public int generateCarNumber() {
	   return ++carNumber;
   }
   public Map<Integer,Car> getSoldDetails(){
	   return soldCar;
   }
   public String findProfit(int[] arr) {
	   String resul="";
	   String first=null;
	   int last=0;
	   int count=0;
	   for(int i=0;i<arr.length-1;i++) {
		   if(first==null) {
		   first=String.valueOf(arr[i]);
		   }
		   last=arr[i];
		   
		   if(arr[i+1]<arr[i]&&count>0) {
			   resul+="("+first+","+last+")";
			   first=null;
			   count=0;
		   }
		   if(arr[i]<arr[i+1]) {
			   
			   count++;
		   }
		   else {
			   first=null;
		   }
	   }
	   if(count>0) {
		   last=arr[arr.length-1];
		   resul+="("+first+","+last+")"; 
	   }
	   if(resul.equals("")) {
		   resul="No profit";
	   }
	   return resul;
   }
}
