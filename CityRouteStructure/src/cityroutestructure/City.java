package cityroutestructure;

import java.util.HashMap;
import java.util.Map;

public class City {
 
	private String cityName;
	
	private Map<String,Integer> routes=new HashMap<>();
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Map<String, Integer> getRoutes() {
		return routes;
	}
	public void setRoutes(String city,int distance) {
		routes.put(city, distance);
	}
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", routes=" + routes + "]";
	}
	
	
	
	
}
