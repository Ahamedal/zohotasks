package zcoinexchange;

import java.util.Map;
import java.util.Scanner;

public class ZCoinExchangeDriver {
	public void createAccount() {
		Scanner sc=new Scanner(System.in);
		ZCoinExchange logic=new ZCoinExchange();
		User userObj=new User();
		System.out.println("Enter your full name");
		String fullName=sc.nextLine();
		System.out.println("Enter your emailId");
		String emailId=sc.nextLine();
		System.out.println("Enter your mobilenumber");
		long mNo=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter your aadhaarCardNumber");
		long HId=sc.nextLong();
		sc.nextLine();
		
		userObj.setName(fullName);
		userObj.setH_ID(HId);
		userObj.setMobileNumber(mNo);
		userObj.setEmailId(emailId);
		boolean condition=true;
		while(condition) {
		System.out.println("Enter your Password \n password should follows:\n1.Password should not contain (full name)  / (mobile number)\n2.Length of the password should not be less than 8\n3.It should be AlphaNumeric with a Mixed case and limited Special character (!#%><&*)\n"
				+ "support ");
		String password=sc.nextLine();
		if(logic.passwordCheck(password, userObj)) {
			userObj.setPassword(password);
			condition=false;
		}
		else {
			System.out.println("Your password is wrong");
		}
		}
		System.out.println("Enter Initial RealCurrency Deposit");
		int deposit=sc.nextInt();
		sc.nextLine();
		userObj.setRealCurrencyWalletAmount(deposit);
		logic.addUser(userObj);
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ZCoinExchangeDriver runner=new ZCoinExchangeDriver();
		ZCoinExchange logic=new ZCoinExchange();
		boolean condition=true;
		while(condition) {
		System.out.println("1.CreateAccount 2.Login 3.exit");
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			runner.createAccount();
			break;
			
		case 2:
			boolean b2=true;
			while(b2) {
			System.out.println("1.AgentLogin 2.UserLogin 3.exit");
			int sel2=sc.nextInt();
			sc.nextLine();
			switch(sel2) {
			case 1:
				boolean bb=true;
				while(bb) {
				System.out.println("Enter your loginemailId");
				String emailId=sc.nextLine();
				System.out.println("Enter your password");
				String password=sc.nextLine();
				if(logic.agentLoginAccept(emailId, password)) {
					bb=false;
					boolean condition2=true;
					while(condition2) {
					System.out.println("1.To Allow Customer 2.User TransactionHistory 3.fixed rate RC to ZC");
					int sel3=sc.nextInt();
					sc.nextLine();
					switch(sel3) {
					case 1:
						Map<String,User> map=logic.getSignUpList();
						System.out.println(map);
						System.out.println("Enter emailId to allow or reject");
						String emailID=sc.nextLine();
						System.out.println("Enter 1-Allow 0-Reject");
						int sel4=sc.nextInt();
						sc.nextLine();
						if(sel4==1) {
							logic.allowUser(emailID);
							
						}
						else {
							logic.rejectUser(emailID);
						}
						break;
					case 2:
						System.out.println("Enter ZID for show transaction history by a user");
						int ZID=sc.nextInt();
						sc.nextLine();
						System.out.println(logic.getTransactionHistory(ZID));
						break;
						
					case 3:
						System.out.println("Enter  conversion fixed rate to RC to Zcoin transaction ");
						int con=sc.nextInt();
						sc.nextLine();
						logic.setRate(con);
						break;
						
					case 4:
						condition2=false;
					
					}
					}
					
					
				}
				else {
					System.out.println("Your userId and password is wrong");
					
					
				}
				}
				break;
			case 2:
				boolean b=true;
				while(b) {
					
				System.out.println("Enter your loginemailId");
				String emailId1=sc.nextLine();
				System.out.println("Enter your password");
				String password1=sc.nextLine();
				if(logic.userLogin(emailId1, password1)) {
					b=false;
					boolean condition4=true;
					while(condition4) {
					System.out.println("1.AccountDetails 2.TransactionHistory by user 3.change password 4.RC transaction 5.Zcoin Transaction");
					int sel6=sc.nextInt();
					sc.nextLine();
					switch(sel6) {
					
					case 1:
						boolean condition6=true;
						while(condition6) {
						System.out.println("1.Your profile 2.Show Wallet Amount 3.exit");
						int sel9=sc.nextInt();
						sc.nextLine();
						switch(sel9) {
						case 1:
							System.out.println(logic.getProfile(emailId1));
							System.out.println("Your ZID is "+logic.getZID(emailId1)+"\nThis ZID is used for all transactions");
							break;
							
						case 2:
							int ZID=logic.getZID(emailId1);
							System.out.println("Your Real Currency wallet amount is "+logic.getRCwallet(ZID));
							System.out.println("Your ZCoin Wallet amount "+logic.getZCWallet(ZID));
							break;
						
						case 3:
							condition6=false;
						
						}
						}
						break;
					case 2:
						int ZID=logic.getZID(emailId1);
						System.out.println(logic.getTransactionHistory(ZID));
						break;
						
					case 3:
						boolean condition11=true;
						while(condition11) {
						System.out.println("Enter Change Password \n password should follows:\n1.Password should not contain (full name)  / (mobile number)\n2.Length of the password should not be less than 8\n3.● It should be AlphaNumeric with a Mixed case and limited Special character (!#%><&*)\n"
								+ "support ");
						String pass=sc.nextLine();
						User usr=logic.getProfile(emailId1);
						if(logic.passwordCheck(pass, usr)) {
							usr.setPassword(pass);
							condition11=false;
						}
						else {
							System.out.println("Your password is wrong");
						}
						}
						break;
						
					case 4:
						boolean condition12=true;
						while(condition12) {
							System.out.println("1.Deposit 2.withdraw 3.transaction");
							int se11=sc.nextInt();
							sc.nextLine();
							switch(se11) {
							case 1:
								int zId=logic.getZID(emailId1);
								System.out.println("Enter amount to deposit");
								int dep=sc.nextInt();
								sc.nextLine();
								logic.deposit(zId,dep);
								logic.addTransaction(dep,zId,"deposited");
								System.out.println("Amount deposited successfully");
								break;
							case 2:
								int zId1=logic.getZID(emailId1);
								System.out.println("Enter amount to withdraw");
								int dep1=sc.nextInt();
								sc.nextLine();
								if(logic.withdraw(zId1,dep1)) {
									logic.addTransaction(dep1,zId1,"Withdraw");
								System.out.println("Amount withdraw successfully");
								}
								else {
									System.out.println("Your withdraw amount is out of range");
								}
								break;
								
							case 3:
								int zId2=logic.getZID(emailId1);
								System.out.println("Enter RC amount to change Zcoin ");
								int amount=sc.nextInt();
								sc.nextLine();
								if(	logic.RCToZCTransaction(zId2, amount)) {
									logic.addTransaction(amount,zId2,"RC to ZC transaction");
									System.out.println("Amount transfered successfully");
								}
								else {
									System.out.println("Your enter RC amount is out of range");
								}
								break;
								
							case 4:
								condition12=false;
								
							}
						}
						break;
					case 5:
						boolean condition13=true;
						while(condition13) {
						System.out.println("1.ZCoin transaction 2.Zcoin to Rc transaction");
						int k=sc.nextInt();
						sc.nextLine();
						switch(k) {
						case 1:
						int zId3=logic.getZID(emailId1);
					     System.out.println("Enter transfer account ZID");
					     int zId4=sc.nextInt();
					     sc.nextLine();
					     System.out.println("Enter amount to transfer");
					     int amount=sc.nextInt();
					     sc.nextLine();
					    if(logic.ZCToZCTransaction(zId3,zId4,amount))	{
					    	logic.addTransaction(amount,zId3,"ZC transer to"+zId4);
					    	logic.addTransaction(amount,zId4,"ZC transer from"+zId3);
					    	System.out.println("Amount transferred");
					    	
					    }
					    else {
					    	System.out.println("Your enter ZCoin amount is out of range");
					    }
					    break;
						case 2:
							int zId=logic.getZID(emailId1);
							 System.out.println("Enter amount to ZC to RC");
						     int amount2=sc.nextInt();
						     sc.nextLine();
						    if(logic.ZCToRCTransaction(zId,amount2))	{
						    	logic.addTransaction(amount2,zId,"ZC to RC conversion"+zId);
						    	
						    	System.out.println("ZC to RC trnsaction successfully");
						    	
						    }
						    else {
						    	System.out.println("Your enter ZCoin amount is out of range");
						    }
						    break;
						case 3:
							condition13=false;
					}
					}
					case 6:
						condition4=false;
						break;
					}
					
				}
						
				}
				else {
					System.out.println("Your userId and password is wrong");
				}
				}
				break;
			case 3:
				b2=false;
				
			}
			}
			break;
		case 3:
			condition=false;
		}
		
		}
		
	}
}
