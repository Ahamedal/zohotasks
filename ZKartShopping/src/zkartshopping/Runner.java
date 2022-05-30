package zkartshopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public void customerInitialization() {
		CustomerInfo cus=new CustomerInfo();
		ZCartShopping zKart=new ZCartShopping();
		
		cus.setEmailId("abc@zoho.com");
		cus.setEncryptedPwd("Abcd");
		cus.setName("Rahul");
		cus.setMobileNo(912345678);
		
		zKart.addCustomer(cus);
		CustomerInfo cus1=new CustomerInfo();
		cus1.setEmailId("123@zoho.com");
		cus1.setEncryptedPwd("Cz");
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
		zKart1.addZKartDetails(zKart2);
	     zKart1.addPassword("admin@zoho.com","xyzzy");
		
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Runner objForRunner=new Runner();
	ZCartShopping objForLogic=new ZCartShopping();
	boolean condition=true;
	while(condition) {
		System.out.println("1.Customer Initialization \n 2.Inventory Initialization\n3.Customer Signup \n 4.Login\n7.Admin login\n9.Exit");
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
			String emailId=null;
			while(condition2) {
			System.out.println("Enter your EmailId/UserName");
			emailId=sc.nextLine();
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
			boolean condition6=true;
			String passWord=null;
			while(condition6) {
			System.out.println("Enter Password");
			passWord=sc.nextLine();
			if(objForLogic.isCheckPass(passWord,emailId)) {
				condition6=false;
			}
			else {
				System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers");
			}
			}
			System.out.println("Enter retype above password");
			String reType=sc.nextLine();
			if(objForLogic.checkPassword(passWord,reType)) {
				cus.setEncryptedPwd(passWord);
				objForLogic.addPassword(emailId,passWord);
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
			String emailId1=sc.nextLine();
			System.out.println("Enter your password");
			String pass=sc.nextLine();
			if(!objForLogic.loginCheck(emailId1, pass)) {
				System.out.println("your emailId or password is wrong");
			}
			else {
				boolean condition5=true;
				while(condition5){
				System.out.println("1.shooping 2.ordeHistory 3.change Password 4.Exit");
				int sel3=sc.nextInt();
				sc.nextLine();
				switch(sel3) {
				case 1:
					boolean condition4=true;
					
					List<ZKartInfo> listOfKart=new ArrayList<>();
					List<Integer> noOfNeeds=new ArrayList<>();
				
					 while(condition4) 
					 {
					 List<ZKartInfo> lis=objForLogic.getzKart();
					 System.out.println(lis);
					 for(int i=0;i<lis.size();i++) 
					 {
						 System.out.println("Enter "+(i+1)+"-"+lis.get(i));
						
						
					 }
					 
					 int sel1=sc.nextInt();
					 sc.nextLine();
					 System.out.println("How many do you want");
					 int sel7=sc.nextInt();
					 sc.nextLine();
					 listOfKart.add(lis.get(sel1-1));
					 noOfNeeds.add(sel7);

					
					 
					  System.out.println("Enter Continue Shopping Enter true or false ");
					  condition4=sc.nextBoolean();
					  
					 }
					 
					 int invoice=objForLogic.generateUniqueInvoice();
					 ZKartInfo highestStock= objForLogic.highestStock();
					 objForLogic.shopping(listOfKart, noOfNeeds);
					 System.out.println("Your unique voice number is "+invoice);
					 objForLogic.addPurchase(emailId1);
					 int totalAmount=0;
					 objForLogic.addOrderHistory(emailId1,listOfKart,invoice);
					 if(listOfKart.size()!=0) {
                     
                     System.out.println("Your orderDetails\n");
					 for(int i=0;i<listOfKart.size();i++)
					 {
						 
						 if(highestStock.equals(listOfKart.get(i))) 
						 {
							 System.out.println(listOfKart.get(i)+" discount applied for this product");
							 totalAmount+=((listOfKart.get(i).getPrice()*10/100)*noOfNeeds.get(i));
						 }
						 else 
						 {
						 totalAmount+=(listOfKart.get(i).getPrice()*noOfNeeds.get(i));
						 }
						 System.out.println(listOfKart.get(i)+"="+noOfNeeds.get(i));
					 }
					 System.out.println("Your totalAmount is "+totalAmount);
					 if(objForLogic.getPurchases(emailId1)==3||totalAmount>20000) 
					 {
						 String dis=objForLogic.generateDiscountNo();
						 System.out.println("Your discount code is "+dis+" this code is only using 3 transactions");
						 objForLogic.setNextTransaction(emailId1,dis);
					 }
					 System.out.println("you have any discount code 1-yes 0-no");
					 int disCode=sc.nextInt();
					 sc.nextLine();
					if(disCode==1) {
						 System.out.println("Enter the discount code");
						 String code=sc.nextLine();
					 
					 if(objForLogic.checkCorrectCode(emailId1,code)&&objForLogic.getNextPurchases(emailId1)<3) {
						 int reduceAmount=0;
						 int dis=objForLogic.randomGenerator();
						 System.out.println(dis+"% discount applied");
						 reduceAmount=totalAmount-(totalAmount*dis/100);
						 System.out.println("You amount saved for discount "+(totalAmount-reduceAmount));
						 System.out.println("you pay only "+reduceAmount);
						 
					 }
					 else {
						 System.out.println("Your discount code is not valid or not correct");
					 }
					 }
					 }
					 else {
						 System.out.println("Your ordered product is not avilable");
					 }
					 break;
					 
				case 2:
					System.out.println(objForLogic.getOrderHistory(emailId1));
					break;
					
				case 3:
					String passWord=null;
					boolean condition9=true;
					while(condition9) {
						System.out.println("Enter Password");
					    passWord=sc.nextLine();
						if(objForLogic.isCheckPass(passWord,emailId1)) {
							condition9=false;
						}
						else {
							System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers");
						}
						}
						System.out.println("Enter retype above password");
						String reType=sc.nextLine();
						if(objForLogic.checkPassword(passWord,reType)&& objForLogic.changePassword(passWord, emailId1)) {
						   
						    condition9=false;
						}
						else {
							System.out.println("Your password is not matching or password not equals to last 3 password");
						}
						
				break;
				case 4:
					condition5=false;
					break;
				}
			}
			}
			break;
		
		case 5:
			System.out.println(objForLogic.getCusInfo());
			break;
		case 6:
			System.out.println(objForLogic.getzKart());
			break;
			
		
			 
		case 7:
			
				
				System.out.println("Enter your loginId/emailId");
				String emailId6=sc.nextLine();
				System.out.println("Enter your password");
				String password=sc.nextLine();
				boolean condition13=true;
				while(condition13) {
				if(objForLogic.adminLoginCheck(emailId6, password)) {
			System.out.println("1.Reorder 2.Change password 3.exit");
			int see=sc.nextInt();
			sc.nextLine();
			switch(see) {
			case 1:
			
			
				boolean condition6=true;
			while(condition6) {
			List<ZKartInfo> lis=objForLogic.getLessNoOfStack();
			for(int i=0;i<lis.size();i++) {
				System.out.println((i+1)+"= "+lis.get(i));
			}
			if(lis.size()!=0) {
		    System.out.println("Enter corresponding no for reOrder");
		    int no=sc.nextInt();
		    sc.nextLine();
		    System.out.println(lis.get(no-1)+"\n how much no of reorder of that model");
		    int reOr=sc.nextInt();
		    sc.nextLine();
		    objForLogic.reOrder(lis.get(no-1), reOr);
		    System.out.println("would do you like to reorder enter 1-yes 0-no");
		    int sel5=sc.nextInt();
		    sc.nextLine();
		    if(sel5==0) {
		    	condition6=false;
		    
			}
			}
			else {
				System.out.println("All items consist more than 10");
				condition6=false;
			}
		   
			}
			
		
			break;
			case 2:
				String passWord=null;
				boolean condition9=true;
				while(condition9) {
					System.out.println("Enter Password");
				    passWord=sc.nextLine();
					if(objForLogic.isCheckPass(passWord,emailId6)) {
						condition9=false;
					}
					else {
						System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers");
					}
					}
					System.out.println("Enter retype above password");
					String reType=sc.nextLine();
					if(objForLogic.checkPassword(passWord,reType)) {
					    objForLogic.adminChangePassword(passWord, emailId6);
					    condition9=false;
					}
					else {
						System.out.println("Your password is not matching");
					}
					break;
			case 3:
				condition13=false;
		    
			
			
			}
		
		    }
			else {
				System.out.println("Your emailId and password is wrong");
			}
	     }
				break;
		case 9:
			condition=false;
}
}
}
}
