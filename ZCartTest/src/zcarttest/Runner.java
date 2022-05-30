package zcarttest;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;





public class Runner {

	public void invetoryInitialization(ZCart zCartOb) {
		Product zKart=new Product();
		
		zKart.setBrandName("Apple");
		zKart.setCategoryName("Mobile");
		zKart.setModelName("6S");
		zKart.setPriceOfProduct(60000);
		zKart.setStockOfProduct(10);
		zKart.setProductId(zCartOb.generateProductId());
		zCartOb.addZKart(zKart);
		Product zKart2=new Product();
		zKart2.setBrandName("HP");
		zKart2.setCategoryName("Laptop");
		zKart2.setModelName("G");
		zKart2.setPriceOfProduct(12000);
		zKart2.setStockOfProduct(5);
		zKart2.setProductId(zCartOb.generateProductId());
		zCartOb.addZKart(zKart2);
	     zCartOb.addPassword("admin@zoho.com","xyzzy");
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Runner objForRunner=new Runner();
		ZCart objForLogic=new ZCart();
		objForRunner.invetoryInitialization(objForLogic);
		boolean condition=true;
		while(condition) {
			System.out.println("1.Customer Initialization \n 2.Inventory Initialization\n3.Customer Signup \n 4.Login\n7.Admin login\n9.Exit");
			int sel=sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
//				objForRunner.customerInitialization();
//			    System.out.println(objForLogic.getCusInfo());
//				break;
				
			case 2:
//				objForRunner.invetoryInitialization();
//				System.out.println(objForLogic.getzKart());
//				break;
				
			case 3:
				boolean condition2=true;
				Customer cus=new Customer();
				String emailId=null;
				while(condition2) {
				System.out.println("Enter your EmailId/UserName");
				emailId=sc.nextLine();
				if(objForLogic.existCustomer(emailId)) {
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
				cus.setMobileNumber(mNo);
				boolean condition3=true;
				while(condition3) {
				boolean condition6=true;
				String passWord=null;
				while(condition6) {
				System.out.println("Enter Password");
				passWord=sc.nextLine();
				if(objForLogic.checkPasswordCritteria(passWord)) {
					condition6=false;
				}
				else {
					System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers");
				}
				}
				System.out.println("Enter retype above password");
				String reType=sc.nextLine();
				if(objForLogic.checkPassword(passWord,reType)) {
					
					objForLogic.addPassword(emailId,passWord);
					cus.setEncryptedPassword(objForLogic.encryptPass(passWord));
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
						
						List<Integer> listOfKart=new ArrayList<>();
						List<Integer> noOfNeeds=new ArrayList<>();
					
						 while(condition4) 
						 {
						 Map<Integer,Product> map=objForLogic.getZKart();
						
						 for(Integer key:map.keySet()) 
						 {
							 System.out.println("Enter "+key+"-"+map.get(key));
							
							
						 }
						 
						 int sel1=sc.nextInt();
						 sc.nextLine();
						 System.out.println("How many do you want");
						 int sel7=sc.nextInt();
						 sc.nextLine();
						 listOfKart.add(sel1);
						 noOfNeeds.add(sel7);

						
						 
						  System.out.println("Enter Continue Shopping Enter true or false ");
						  condition4=sc.nextBoolean();
						  
						 }
						 
						 int invoice=objForLogic.generateInvoice();
						 List<Product> highestStock= objForLogic.getHighestStock();
						 objForLogic.checkOutCard(listOfKart, noOfNeeds);
						 System.out.println("Your unique voice number is "+invoice);
						
						 int totalAmount=0;
						 objForLogic.addOrderHistory(emailId1, listOfKart, noOfNeeds);
						 if(listOfKart.size()!=0) {
	                     
	                     System.out.println("Your orderDetails\n");
						 for(int i=0;i<listOfKart.size();i++)
						 {
							 
							 if(highestStock.contains(objForLogic.getProduct(listOfKart.get(i)))) 
							 {
								 System.out.println(objForLogic.getProduct(listOfKart.get(i))+" discount applied for this product");
								 totalAmount+=((objForLogic.getProduct(listOfKart.get(i)).getPriceOfProduct()*10/100)*noOfNeeds.get(i));
							 }
							 else 
							 {
							 totalAmount+=(objForLogic.getProduct(listOfKart.get(i)).getPriceOfProduct()*noOfNeeds.get(i));
							 }
							 System.out.println(objForLogic.getProduct(listOfKart.get(i))+"="+noOfNeeds.get(i));
						 }
						 System.out.println("Your totalAmount is "+totalAmount);

						 System.out.println("you have any discount code 1-yes 0-no");
						 int disCode=sc.nextInt();
						 sc.nextLine();
						if(disCode==1) {
							 System.out.println("Enter the discount code");
							 String code=sc.nextLine();
						 
						 if(objForLogic.validCoupenCode(code, emailId1)) {
							 int reduceAmount=0;
							 int dis=objForLogic.randomGenerated();
							 System.out.println(dis+"% discount applied");
							 reduceAmount=totalAmount-(totalAmount*dis/100);
							 System.out.println("You amount saved for discount "+(totalAmount-reduceAmount));
							 System.out.println("you pay only "+reduceAmount);
							 
						 }
						 else {
							 System.out.println("Your discount code is not valid or not correct");
						 }
						 }
						
						 if(objForLogic.addPurchase(emailId1)||totalAmount>20000) 
						 {
							 String dis=objForLogic.getAlphaNumbericCode();
							 System.out.println("Your discount code is "+dis+" this code is only using 3 transactions");
							 objForLogic.addCoupen(emailId1, dis);
							
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
							if(objForLogic.checkPasswordCritteria(passWord)||objForLogic.checkLast3Password(emailId1, passWord)) {
								condition9=false;
							}
							else {
								System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers or not equal last 3 password");
							}
							}
							System.out.println("Enter retype above password");
							String reType=sc.nextLine();
							if(objForLogic.checkPassword(passWord,reType)) {
							   objForLogic.addPassword(emailId1, passWord);
							    condition9=false;
							}
							else {
								System.out.println("Your password is not matching");
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
//				System.out.println(objForLogic.getCusInfo());
//				break;
			case 6:
//				System.out.println(objForLogic.getzKart());
//				break;
				
			
				 
			case 7:
				
					
					System.out.println("Enter your loginId/emailId");
					String emailId6=sc.nextLine();
					System.out.println("Enter your password");
					String password=sc.nextLine();
					boolean condition13=true;
					while(condition13) {
					if(objForLogic.adminLoginCheck(emailId6,password)) {
				System.out.println("1.Reorder 2.Change password 3.exit");
				int see=sc.nextInt();
				sc.nextLine();
				switch(see) {
				case 1:
				
				
				List<Product> lis=objForLogic.getLessNoOfStock();
				for(int i=0;i<lis.size();i++) {
					System.out.println(lis.get(i));
				}
				
			    objForLogic.reOrder(lis, 10);
			    
				
			
				break;
				case 2:
					String passWord=null;
					boolean condition9=true;
					while(condition9) {
						System.out.println("Enter Password");
					    passWord=sc.nextLine();
						if(objForLogic.checkPasswordCritteria(passWord)||objForLogic.checkLast3Password(emailId6, passWord)) {
							condition9=false;
						}
						else {
							System.out.println("Password complexity of mandating atleast 2 lowercase,2 uppercase and 2 numbers or not equal last 3 password");
						}
						}
						System.out.println("Enter retype above password");
						String reType=sc.nextLine();
						if(objForLogic.checkPassword(passWord,reType)) {
						   objForLogic.addPassword(emailId6, passWord);
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
