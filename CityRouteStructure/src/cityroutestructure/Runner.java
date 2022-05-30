package cityroutestructure;

import java.util.Scanner;
import java.util.List;
import java.util.Map;


public class Runner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CityRoute city=new CityRoute();
		city.initialSetup();
		System.out.println(city.findAllRoutes("A", "G"));
		Map<List<String>,Integer>  allRoutes=city.findAllRoutes("A", "G");
		System.out.println(city.getShortestRoute(allRoutes));
		System.out.println(city.deleteRoute("A", "C"));
		System.out.println(city.deleteRoute("E", "C"));
		System.out.println(city.findAllRoutes("A", "G"));
		System.out.println(city.addRoutes("A", "C", 10));
		System.out.println(city.findAllRoutes("A", "G"));
		System.out.println(city.busyCity());
	}
}
