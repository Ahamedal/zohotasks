package bankrunner;
import java.util.*;


import com.logiclayer.*;
import level3.*;

public class RunnerClass {
 
	
	
	
	private void addDummyCustomerInfo() throws CustomException, ClassNotFoundException{
		APILayer objForLogic=new APILayer(true);
		
		CustomerInfo pInfo=new CustomerInfo();
		pInfo.setName("abi");
		pInfo.setAddress("karaikudi");
		pInfo.setMobileNo(7890123679l);
		
		objForLogic.addMap(pInfo);
		//objForFile.fileSerialization(pInfo);
		CustomerInfo pInfo1=new CustomerInfo();
		pInfo1.setName("ruj");
		pInfo1.setAddress("podi");
		pInfo1.setMobileNo(965554403l);
		
		objForLogic.addMap(pInfo1);
		//objForFile.fileSerialization(pInfo1);
		CustomerInfo pInfo2=new CustomerInfo();
		pInfo2.setName("prabha");
		pInfo2.setAddress("chennai");
		pInfo2.setMobileNo(91763531234l);
		
		objForLogic.addMap(pInfo2);
	}
	private void addDummyAccount()throws CustomException, ClassNotFoundException {
		APILayer objForLogic=new APILayer(true);
		
		AccountInfo aInfo=new AccountInfo();
		aInfo.setCustomerID(1);
		
		aInfo.setAccountType("savings");
		aInfo.setBranchName("selam");
		//aInfo.setBalance(12000l);
	
		//objForLogic.depositMoney(aInfo);
		//objForLogic.withDrawMoney(aInfo);
		objForLogic.addMultipleAccount(aInfo);
		
		
		AccountInfo aInfo2=new AccountInfo();
		aInfo2.setCustomerID(1);
		
		aInfo2.setAccountType("savings");
		aInfo2.setBranchName("palai");
		
		//aInfo2.setBalance(2000l);
		
		objForLogic.addMultipleAccount(aInfo2);
		
		AccountInfo aInfo1=new AccountInfo();
		
		aInfo1.setCustomerID(2);
		aInfo1.setAccountType("savings");
		aInfo1.setBranchName("kovai");
		//aInfo1.setBalance(92000l);
		
		
		objForLogic.addMultipleAccount(aInfo1);
		
		
		AccountInfo aInfo3=new AccountInfo();
		aInfo3.setCustomerID(3);
		
		aInfo3.setAccountType("savings");
		aInfo3.setBranchName("chokka");
		//aInfo3.setBalance(70l);
		
	    
		objForLogic.addMultipleAccount(aInfo3);
		
	}

	private void addCustomerDetails() throws CustomException{
		APILayer objForLogic=null;
		try {
			objForLogic = new APILayer(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("how many customers do you add");
		int count=sc.nextInt();
		sc.nextLine();
	for(int i=0;i<count;i++) {
		CustomerInfo obj=new CustomerInfo();
		
		System.out.println("enter acc holder name");
		String accHolderName=sc.nextLine();
		
		System.out.println("enter Your address");
		String address=sc.nextLine();
		
		System.out.println("enter mobile no");
		long mobileNo=sc.nextLong();
		sc.nextLine();
	obj.setName(accHolderName);
	obj.setAddress(address);
	obj.setMobileNo(mobileNo);
	
	
	objForLogic.addMap(obj);

	}
	
	}
	private void addMultiple() throws CustomException, ClassNotFoundException{
		APILayer objForLogic=new APILayer(true);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("how many customers do you add");
		int count=sc.nextInt();
		sc.nextLine();
		
	for(int i=0;i<count;i++) {
		AccountInfo obj1=new AccountInfo();
		System.out.println("enter your customerID");
		int customerID=sc.nextInt();
		sc.nextLine();
		//int accountID=objForFile.generateAccountID();
		System.out.println("enter account type");
		String accountType=sc.nextLine();
		
		
		System.out.println("enter branch name");
		String branchName=sc.nextLine();
		
		//System.out.println("enter balance");
		//long balance=sc.nextLong();
		//sc.nextLine();
	obj1.setCustomerID(customerID);
	obj1.setBranchName(branchName);
	obj1.setAccountType(accountType);
	
	objForLogic.addMultipleAccount(obj1);
	}

	}
	public static void main(String[] args) throws ClassNotFoundException, CustomException {
		
		APILayer objForLogic=new APILayer(true);
		
		Scanner sc=new Scanner(System.in);
        DBLayer objDb=new DBLayer();
        /*try {
        Class.forName("com.mysql.cj.jdbc.driver");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }*/
		boolean condition=true;
		while(condition) {
			int no=0;
			try {
			
			System.out.println("enter your question no");
			System.out.println("1.add customer details \n 2.get customer details from file and cache\n 3.put multiple account \n 4.get account details to account id from file \n 5.get account details to accountId from cache\n 6.depositMoney \n 7.withdrawal \n 9.setAccountstatus \n 11.setcustomerstatus\n 12.read customer details to file\n13.read account details to file\n14.create table\n15.read customer details from cache\n16.read account details from cache");
			no=sc.nextInt();
			sc.nextLine();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			

		switch(no) {
		
		case 1:
			try {
		  RunnerClass run=new RunnerClass();
	    // run.addDummyCustomerInfo();
		 
		 // objForLogic.addCustomerFile();
		  //run.addCu();
		 run.addCustomerDetails();
			}
			catch(CustomException e) {
				e.getMessage();
			}
		break;
		case 2:
		try {
		   System.out.println("enter customer id");
		   int customerID=sc.nextInt();
		   sc.nextLine();
		   System.out.println(objForLogic.getCusInfoFromFile(customerID));
		   System.out.println(objForLogic.getCusInfoFromCache(customerID));
		}
		catch(CustomException e) {
			System.out.println(e.getMessage());
		}
		   break;
			
		case 3:
			try {
			RunnerClass run1=new RunnerClass();
			//run1.addDummyAccount();
			run1.addMultiple();
			}
			catch(CustomException e) {
				e.getMessage();
			}
			break;
		
		case 4:
			try {
			System.out.println("enter customerId");
			int customerId=sc.nextInt();
			sc.nextLine();
			System.out.println("enter accountId");
			int accountId=sc.nextInt();
			sc.nextLine();
			System.out.println(objForLogic.getAccForAccIdFromFile(customerId,accountId));
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
			System.out.println("enter customerId");
			int customerId1=sc.nextInt();
			sc.nextLine();
			System.out.println("enter AccountId");
			int accountId=sc.nextInt();
			sc.nextLine();
			
			System.out.println(objForLogic.getAccForAccIdFromCache(customerId1,accountId));
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
		    try {
			System.out.println("enter customer id");
			int cusID=sc.nextInt();
			System.out.println("enter Account id");
			int accID=sc.nextInt();
			System.out.println("enter your deposit money");
			long deposit=sc.nextLong();
		    objForLogic.depositMoney(cusID,accID,deposit);
		    }
		    catch(CustomException e) {
		    	System.out.println(e.getMessage());
		    }
			break;
		case 7:
			try {
			System.out.println("enter customer Id");
			int cusId=sc.nextInt();
			sc.nextLine();
			System.out.println("enter account Id");
			int accId=sc.nextInt();
			sc.nextLine();
			System.out.println("enter your withDraw");
			long withDraw=sc.nextLong();
			objForLogic.withDrawMoney(cusId, accId, withDraw);
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 9:
			try {
				System.out.println("enter customer Id");
				int cusId1=sc.nextInt();
				sc.nextLine();
				System.out.println("enter account Id");
				int accId1=sc.nextInt();
				sc.nextLine();
				System.out.println("please enter 0 for deactivated the account, 1 for activated the account");
				int status=sc.nextInt();
				sc.nextLine();
				objForLogic.setAccountStatus(cusId1,accId1,status);
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 11:
			try {
				System.out.println("enter customer Id");
				int cusId=sc.nextInt();
				sc.nextLine();
				System.out.println("please enter 0 for deactivated the customerInfo, 1 for activated the customerInfo");
				int status=sc.nextInt();
				sc.nextLine();
				objForLogic.setCustomerStatus(cusId, status);
			}
			catch(CustomException e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case 12:
			try {
				System.out.println(objForLogic.readCusInfo());
				
				
				
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
		
//		case 13:
//			try {
//				System.out.println(objForLogic.readAccInfo());
//				
//				
//			}
//			catch(CustomException e) {
//				System.out.println(e.getMessage());
//			}
//			break;
		case 14:
			objDb.createTable();
			break;
		case 15:
	         try {
				
				
				System.out.println(objForLogic.getCustomerInfoCache());
				
				}
				catch(CustomException e) {
					System.out.println(e.getMessage());
				}
				break;			
		case 16:
			
			try {
				
				
				System.out.println(objForLogic.getAccountInfoCache());
				
				}
				catch(CustomException e) {
					System.out.println(e.getMessage());
				}
				break;			
		default:
			condition=false;
		}
		
		
		
		}
	
	
	   
		
	}

}
