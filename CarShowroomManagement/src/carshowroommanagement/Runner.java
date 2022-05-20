package carshowroommanagement;

import java.util.Scanner;

public class Runner {
    
	public void addCar() {
		Scanner sc=new Scanner(System.in);
		CarShowroomManagement objForLogic=new CarShowroomManagement();
		boolean condition=true;
		while(condition) {
		System.out.println("1.Add sonet Car 2.Add seltos car");
		int sel=sc.nextInt();
		sc.nextLine();
		switch (sel) {
		case 1:
		
		System.out.println("How many city in your show room management");
		int size=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<size;i++) {
		System.out.println("Enter your city");
		String city=sc.nextLine();
		System.out.println("How many branch in this "+city);
		int branchSize=sc.nextInt();
		sc.nextLine();
		for(int j=0;j<branchSize;j++) {
		System.out.println("Enter your branch");
		String branch=sc.nextLine();
		
		String model="SONET";
		System.out.println("Enter how much "+model+" car in this branch");
		int sonet=sc.nextInt();
		sc.nextLine();
		for(int k=0;k<sonet;k++) {
		Car c=new Car();
		Branch brn=new Branch();
		City citObj=new City();
		c.setCity(city);
		c.setBranch(branch);
		c.setCarModel(model);
		c.setCarNumber(objForLogic.generateCarNumber());
		citObj.setCityName(city);
		objForLogic.addCity(citObj);
		brn.setBranchName(branch);
		brn.setCityName(city);
		objForLogic.addBranch(brn);
		
		objForLogic.addCar(c, sonet);
		
	
		
		
		}
		}
		}
		break;
		
		case 2:
			System.out.println("How many city in your show room management");
			int size1=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<size1;i++) {
			System.out.println("Enter your city");
			String city=sc.nextLine();
			System.out.println("How many branch in this "+city);
			int branchSize=sc.nextInt();
			sc.nextLine();
			for(int j=0;j<branchSize;j++) {
			System.out.println("Enter your branch");
			String branch=sc.nextLine();
			String model="SELTOS";
			System.out.println("Enter how much "+model+" car in this branch");
			int sonet=sc.nextInt();
			sc.nextLine();
			for(int k=0;k<sonet;k++) {
			Car c=new Car();
			Branch brn=new Branch();
			City citObj=new City();
			c.setCity(city);
			c.setBranch(branch);
			c.setCarModel(model);
			c.setCarNumber(objForLogic.generateCarNumber());
			citObj.setCityName(city);
			objForLogic.addCity(citObj);
			
			brn.setBranchName(branch);
			brn.setCityName(city);
			objForLogic.addBranch(brn);
			objForLogic.addCar(c, sonet);
		
			
			
			}
			}
			}
			break;
		case 3:
			condition=false;
		}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CarShowroomManagement objForLogic=new CarShowroomManagement();
		Runner runner=new Runner();
		runner.addCar();
		boolean condition=true;
		while(condition) {
			System.out.println("1.Customer Operation 2.Admin Operation 3.Sales Person");
			int sel=sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				System.out.println("Enter the city");
				String city=sc.nextLine();
				System.out.println("Enter the branch");
				String branchName=sc.nextLine();
				System.out.println("Enter the model");
				String model=sc.nextLine();
				if(objForLogic.buyCar(city, branchName, model)==null) {
					System.out.println("Your model car is not available");
				}
				else {
					System.out.println("Car successfully sale");
				}
				break;
				
			case 2:
				boolean condition2=true;
				while(condition2) {
				System.out.println("1.Show cities in the order most slodly car 2.find a city to add stack 3.first sold car 4.recently sold car");
				int sel2=sc.nextInt();
				sc.nextLine();
				switch(sel2) {
				case 1:
					System.out.println(objForLogic.orderCitySaleMostCar());
					break;
					
				case 2:
					boolean condition3=true;
					while(condition3) {
					System.out.println("1.for seltos 2.for sonet");
					int sel1=sc.nextInt();
				    sc.nextLine();
				    switch(sel1) {
					case 1:
						System.out.println(objForLogic.addTStackForSheltos());
						break;
						
					case 2:
						System.out.println(objForLogic.addTStackForSonet());
						break;
						
					case 3:
						condition3=false;
						break;
				    }
					}
					break;
					
				case 3:
					System.out.println(objForLogic.firstSoldCar());
					break;
					
				case 4:
					System.out.println(objForLogic.recentlyCar());
					break;
					
				case 5:
					condition2=false;
					break;
				}
				
			
					
				
				
				}
			case 3:
				System.out.println(objForLogic.getSoldDetails());
				System.out.println("Enter sales data for a week by entering the number of cars sold each day of a week");
				int[] arr=new int[7];
				for(int i=0;i<7;i++) {
					arr[i]=sc.nextInt();
				}
				System.out.println(objForLogic.findProfit(arr));
			}
			
		}
		
	}
}
