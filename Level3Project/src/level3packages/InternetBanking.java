package level3packages;

import java.util.Scanner;

import accountinfo.AccountInfo;
import customerinfo.CustomerInfo;
import exception.CustomsException;
import internetbankinglogic.LogicOfInternetBanking;
import loan.LoanDetails;

public class InternetBanking {
	public void registorCustomer()throws CustomsException,Exception {
		Scanner sc=new Scanner(System.in);
		 LogicOfInternetBanking logicBank=new LogicOfInternetBanking();
		 CustomerInfo customerInfo=new CustomerInfo();
		   AccountInfo accountInfo=new AccountInfo();
		   System.out.println("Enter your name");
		   String name=sc.nextLine();
		   System.out.println("Enter your age");
		   int age=sc.nextInt();
		   sc.nextLine();
		   System.out.println("Enter your mobileNo");
		   long mNumber=sc.nextLong();
		   sc.nextLine();
		   System.out.println("Enter your EmailId");
		   String emailId=sc.nextLine();
		   boolean condition3=true;
		   String pasWord="";
		   while(condition3) {
			   System.out.println("Enter your password");
			   pasWord =sc.nextLine();
			   System.out.println("Enter confirm password");
			   String conPass=sc.nextLine();
			   if(pasWord.equals(conPass)) {
				   customerInfo.setpWord(pasWord);
				   condition3=false;
			   }
			   
		   }
		   
		   customerInfo.setName(name);
		   customerInfo.setAge(age);
		   customerInfo.setMobileNo(mNumber);
		   customerInfo.setEmailId(emailId);
		   
		   
		  
		   int cusId=logicBank.generatorCusId();
		   accountInfo.setCustomerId(cusId);
		   customerInfo.setCusId(cusId);
		   logicBank.addCustomer(customerInfo);
		   System.out.println("Your Registration Successfully");
		   System.out.println("Your UserId="+cusId+" and Password="+pasWord);
		   int accId=logicBank.generatorAccId();
		   accountInfo.setAccountId(accId);
		   logicBank.accountIds(cusId,accId);
		   System.out.println("Enter Branch Name");
		   String branch1=sc.nextLine();
		   accountInfo.setBrachName(branch1);
		   logicBank.addAccount(accountInfo);
		   System.out.println("Account is successfully created,Your Account Number is "+accId);
	}
	public void transactionDetails()throws CustomsException,Exception {
		  Scanner sc=new Scanner(System.in);
		  LogicOfInternetBanking logicBank=new LogicOfInternetBanking();
		  System.out.println("Enter Your AccountNumber");
		  int accId3=sc.nextInt();
		  sc.nextLine();
		  System.out.println(logicBank.getTransactionDetails(accId3));
	}
	public void transferAccount()throws CustomsException,Exception{
	   	  Scanner sc=new Scanner(System.in);
		  LogicOfInternetBanking logicBank=new LogicOfInternetBanking();

	   	   System.out.println("Enter From Account");
		   int fAcc=sc.nextInt();
		   sc.nextLine();
		   System.out.println("Enter To Account");
		   int tAcc=sc.nextInt();
		   sc.nextLine();
		   System.out.println("Enter amount to transfer");
		   double amount=sc.nextDouble();
		   System.out.println(logicBank.transferMoney(fAcc,tAcc,amount));
	}
	public void balance()throws CustomsException,Exception{
		 Scanner sc=new Scanner(System.in);
		 LogicOfInternetBanking logicBank=new LogicOfInternetBanking();
		 System.out.println("Enter your AccountId");
		 int accId=sc.nextInt();
		 System.out.println("Your Balance is "+logicBank.getBalance(accId));
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	 LogicOfInternetBanking logicBank=new LogicOfInternetBanking();
	 InternetBanking runner=new InternetBanking();
	boolean condition=true;
	boolean flag1=false;
	   boolean flag2=false;
	   boolean flag3=false;
	while(condition) {
	System.out.println("Enter 1-You are Existing Customer \nEnter 2-You are New Customer \nEnter 3-Logout");
	
	int customerType=sc.nextInt();
	sc.nextLine();
   switch(customerType) {
   case 1:
	   try {
	   System.out.println("Enter UserId");
	   int uId=sc.nextInt();
	   sc.nextLine();
	   System.out.println("Enter your password");
	   String pass=sc.nextLine();
	   if(uId==0) {
		   if(logicBank.validator(uId,pass)) {
		   boolean condition4=true;
		   while(condition4) {
			   System.out.println("Enter 1.Show All Customer Details \nEnter 2.Show all AccountDetails\nEnter 3.Add Customer\nEnter 4.Add Account\n5.Balance Inquiry\n6.Transfer Account\n7.Show transaction History\n10.Show Loan Details\n9.Change Loan Status");
			   int sel=sc.nextInt();
			   switch(sel) {
			   case 1:
				  
				   System.out.println(logicBank.showCustomerDetails());
				   
				   break;
				   
			   case 2:
				   System.out.println(logicBank.showAccountDeatils());
				   break;
				   
			   case 3:
				   try {
				   runner.registorCustomer();
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 4:
				   try {
				   AccountInfo acountInfo=new AccountInfo();
				   System.out.println("Enter User Id");
				   int userId=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter BranchName");
				   String branch=sc.nextLine();
				   acountInfo.setBrachName(branch);
				   int accId2=logicBank.generatorAccId();
				   acountInfo.setAccountId(accId2);
				   acountInfo.setCustomerId(userId);
				   logicBank.accountIds(userId,accId2);
				   logicBank.addAccount(acountInfo);
				   System.out.println("Your Account Number is "+accId2);
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 5:
				   try {
				   runner.balance();
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
			   
			   case 6:
				   try {
				   runner.transferAccount();
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 7:
				   try {
				   runner.transactionDetails();
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   
				   
			   case 9:
				   System.out.println("Enter Account Number for loan approved /rejected");
				   int accId9=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter 1-EducationLoan\nEnter 2-HomeLoan\nEnter 3-PersonalLoan");
				   String loan=null;
				   int loanId=sc.nextInt();
				   
				   sc.nextLine();
				   switch(loanId) {
				   case 1:
					   loan="Education Loan";
					   break;
					   
				   case 2:
					   loan="Home Loan";
					
					   break;
				
				   case 3:
					   loan="Personal Loan";
					   break;
					   
					default:
						System.out.println("Not Available other loans");
				   }
				   
				   System.out.println("Enter Approved or Rejected");
				   String status=sc.nextLine();
				   System.out.println(logicBank.changeStatus(accId9,loan,status));
				   break;
				   
			   case 10:
				   
				  System.out.println( logicBank.showLoanDetails());
				  
				  break;
				  
			   default:
				   condition4=false;
				   
			   }
		   }
		   }
		   else {
			   System.out.println("Your UserId and Password is wrong");
		   }
	   }
	   else if(logicBank.validator(uId,pass)) {
		   boolean condition2=true;
		   
		   while(condition2) {
			   System.out.println("Enter 1.Add New Account /n 2-Balance Enquiry /n Enter 3-Account History /n Enter 4-GetLoan /n 5-Previous Loans/n Enter 6-Account Transfer /n Enter 7-Logout");
			   int selId=sc.nextInt() ;
			   sc.nextLine();
			   switch(selId) {
			   case 1:
				   try {
				   AccountInfo acountInfo=new AccountInfo();
				   System.out.println("Enter BranchName");
				   String branch=sc.nextLine();
				   acountInfo.setBrachName(branch);
				   int accId2=logicBank.generatorAccId();
				   acountInfo.setAccountId(accId2);
				   acountInfo.setCustomerId(uId);
				   logicBank.accountIds(uId,accId2);
				   logicBank.addAccount(acountInfo);
				   System.out.println("Your Account Number is "+accId2);
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 2:
				   try {
				   if(logicBank.checkAcc(uId)==0) {
				   runner.balance();
				   }
				   else {
					   System.out.println("Your Balance is "+logicBank.getBalance(logicBank.checkAcc(uId)));  
				   }
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 3:
				   try {
					if(logicBank.checkAcc(uId)==0) {
				   runner.transactionDetails();
					}
					else {
						System.out.println(logicBank.getTransactionDetails(logicBank.checkAcc(uId)));
					}
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
			   
			   case 4:
				   try {
				   LoanDetails loan=new LoanDetails();
				   System.out.println("Enter AccountNumber");
				   int accId=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter your Permanent Address");
				   String add=sc.nextLine();
				   System.out.println("Enter Aadhaar Number");
				   long aadhar=sc.nextLong();
				   sc.nextLine();
				   System.out.println("Enter 1-EducationLoan\nEnter 2-HomeLoan\nEnter 3-PersonalLoan");
				   String loType=null;
				   int loanId=sc.nextInt();
				   
				   sc.nextLine();
				   switch(loanId) {
				   case 1:
					   loType="Education Loan";
					   break;
					   
				   case 2:
					   loType="Home Loan";
					
					   break;
				
				   case 3:
					   loType="Personal Loan";
					   break;
					   
					default:
						System.out.println("Not Available other loans");
				   }
				   System.out.println("Enter amount need to loan/n hint-Maximum amount borrow loan is 2lakhs");
				   double amount=sc.nextDouble();
				   sc.nextLine();
				   loan.setAadhaarNumber(aadhar);
				   loan.setAmount(amount);
				   loan.setAddress(add);
				   loan.setLoanType(loType);
				   loan.setStatus("Pending");
				   if(logicBank.loanApproving(accId,loan)) {
					   logicBank.addLoan(accId,loan);
					   System.out.println("Loan applied successfully");
				   }
				   else {
					   System.out.println("You Have already applied for this Loan so,Loan has rejected");
				   }
				   
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
				   
			   case 5:
				   try {
				   if(logicBank.checkAcc(uId)==0) {
				   System.out.println("Enter Account Number");
				   int accId5=sc.nextInt();
				   sc.nextLine();
				   System.out.println(logicBank.getLoanDetails(accId5));
					   }
				   else {
				   System.out.println(logicBank.getLoanDetails(logicBank.checkAcc(uId)));   
					   }
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
			   case 6:
				   try {
				   runner.transferAccount();
				   }
				   catch(CustomsException e) {
					   System.out.println(e.getMessage());
				   }
				   catch(Exception e) {
					   System.out.println(e.getMessage());
				   }
				   break;
			   default:
				   logicBank.showMap();
				   condition2=false;
			   }
		   }
		   
		   }
	   else {
		   System.out.println("Your userId and Password is wrong");
	   }
	   }
	   catch(CustomsException e) {
		   System.out.println(e.getMessage());
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   System.out.println("Enter Numbers only");
	   }
	   break;
	   
   case 2:
      try {
	   runner.registorCustomer();
      }
      catch(CustomsException e) {
    	  System.out.println(e.getMessage());
      }
      catch(Exception e) {
		   System.out.println(e.getMessage());
	   }
	   break;
	   
    default:
    	logicBank.showMap();
    	condition=false;
	   
   }
}
}
}
