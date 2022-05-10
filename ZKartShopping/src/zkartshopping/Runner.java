package zkartshopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public void customerInitialization() {
		CustomerInfo cus=new CustomerInfo();
		ZCartShopping zKart=new ZCartShopping();
		
		cus.setEmailId("abc@zoho.com");
		cus.setEncryptedPwd("ABIB");
		cus.setName("Rahul");
		cus.setMobileNo(912345678);
		zKart.addCustomer(cus);
		CustomerInfo cus1=new CustomerInfo();
		cus1.setEmailId("123@zoho.com");
		cus1.setEncryptedPwd("CB");
		cus1.setName("Anitha");
		cus1.setMobileNo(912345671);
		zKart.addCustomer(cus1);
		
		
		
	}
	public void invetoryInitialization() {
		ZKartInfo zKart=new ZKartInfo();
		ZCartShopping zKart1=new ZCartShopping();
		zKart.setBrand("Apple");
		zKart.setCategory("Mobile");
		zKart.setModel("6S");
		zKart.setPrice(60000);
		zKart.setStock(10);
		zKart1.addZKartDetails(zKart);
		ZKartInfo zKart2=new ZKartInfo();
		zKart2.setBrand("HP");
		zKart2.setCategory("Laptop");
		zKart2.setModel("G");
		zKart2.setPrice(12000);
		zKart2.setStock(5);
		zKart1.addZKartDetails(zKart2);;
		
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Runner objForRunner=new Runner();
	ZCartShopping objForLogic=new ZCartShopping();
	boolean condition=true;
	while(condition) {
		System.out.println("1.Customer Initialization \n 2.Inventory Initialization\n3.Customer Signup \n 4.Login\n8.Admin Module");
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			objForRunner.customerInitialization();
		    System.out.println(objForLogic.getCusInfo());
			break;
			
		case 2:
			objForRunner.invetoryInitialization();
			System.out.println(objForLogic.getzKart());
			break;
			
		case 3:
			boolean condition2=true;
			CustomerInfo cus=new CustomerInfo();
			while(condition2) {
			System.out.println("Enter your EmailId/UserName");
			String emailId=sc.nextLine();
			if(objForLogic.checkExistingEmailId(emailId)) {
				System.out.println("Your emailId is already exist");
			}
			else {
				cus.setEmailId(emailId);
				condition2=false;
			}
			
			}
			System.out.println("Enter your name");
			String name=sc.nextLine();
			cus.setName(name);
			System.out.println("Enter Your MobileNo");
			long mNo=sc.nextLong();
			sc.nextLine();
			cus.setMobileNo(mNo);
			boolean condition3=true;
			while(condition3) {
				
			System.out.println("Enter Password");
			String passWord=sc.nextLine();
			System.out.println("Enter retype above password");
			String reType=sc.nextLine();
			if(objForLogic.checkPassword(passWord,reType)) {
				cus.setEncryptedPwd(passWord);
				condition3=false;
			}
			else {
				System.out.println("Your password is not matching");
			}
			}
			objForLogic.addCustomer(cus);
			break;
			
		case 4:
			System.out.println("Enter your emailId");
			String emailId=sc.nextLine();
			System.out.println("Enter your password");
			String pass=sc.nextLine();
			if(!objForLogic.loginCheck(emailId, pass)) {
				System.out.println("your emailId or password is wrong");
			}
			else {
				System.out.println("1.shooping 2.ordeHistory");
				int sel3=sc.nextInt();
				sc.nextLine();
				switch(sel3) {
				case 1:
					boolean condition4=true;
					List<ZKartInfo> zKart=new ArrayList<>();
					 while(condition4) {
					 List<ZKartInfo> lis=objForLogic.getzKart();
					 System.out.println(lis);
					 for(int i=0;i<lis.size();i++) {
						 System.out.println("Enter "+(i+1)+"-"+lis.get(i));
						
						
					 }
					 
					 int sel1=sc.nextInt();
					 sc.nextLine();
					 ZKartInfo zz=lis.get(sel1-1);
					 if(zz.getStock()>0) {
					 zz.setDate(System.currentTimeMillis());
					 zKart.add(zz);
					 zz.setStock(zz.getStock()-1);
					 }
					
					 
					  System.out.println("Enter Continue Shopping Enter true or false ");
					  condition4=sc.nextBoolean();
					  
					 }
					 int invoice=objForLogic.generateUniqueInvoice();
					 
					 System.out.println("Your unique voice number is "+invoice);
					 objForLogic.addOrderHistory(emailId, zKart);
					 System.out.println("Your order deatils\n"+zKart);
					 break;
					 
				case 2:
					System.out.println(objForLogic.getOrderHistory(emailId));
					break;
					
				}
			}
			break;
		
		case 5:
			System.out.println(objForLogic.getCusInfo());
			break;
		case 6:
			System.out.println(objForLogic.getzKart());
			break;
			
		
			 
		case 8:
			 
		}	
	}
}
}
