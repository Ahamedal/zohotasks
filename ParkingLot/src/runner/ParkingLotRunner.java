package runner;

import java.text.ParseException;

import java.util.Scanner;

import customer.CustomerDetails;
import exception.CustomException;
import logic.LogicOfParkingLot;
import spots.Spots;
import token.Token;

public class ParkingLotRunner {
	public void fullFloorInfo() throws CustomException {
		LogicOfParkingLot logicPark = new LogicOfParkingLot();
		Scanner sc=new Scanner(System.in);
		System.out.println("How many floors in the ParkingLot");
		int flor=sc.nextInt();
		sc.nextLine();
		System.out.println("How many spots per floors");
		int spots=sc.nextInt();
		sc.nextLine();
		int sp=spots%5;
		spots=spots/5;
		
		for (int f = 0; f < flor; f++) {
			int i;
			for (i = 1; i <=spots+sp ; i++) {
				Spots spot = new Spots();
				spot.setFloorNo(f);
				spot.setSpotNo(i);
				spot.setSpotsType("Compact");
				logicPark.addParkInf(f, "Compact", spot);
			}
			int j;
			for (j = i; j <i+spots ; j++) {
				Spots spot = new Spots();
				spot.setFloorNo(f);
				spot.setSpotNo(j);
				spot.setSpotsType("Large");
				logicPark.addParkInf(f, "large", spot);
			}
			int k;
			for ( k= j; k < j+spots; k++) {
				Spots spot = new Spots();
				spot.setFloorNo(f);
				spot.setSpotNo(k);
				spot.setSpotsType("ElectricCar");
				spot.setElectricCharge(true);
				logicPark.addParkInf(f, "ElectricCar", spot);

			}
			int l;
			for (l= k; l<k+spots; l++) {
				Spots spot = new Spots();
				spot.setFloorNo(f);
				spot.setSpotsType("MotorCycle");
				spot.setSpotNo(l);
				logicPark.addParkInf(f, "MotorCycle", spot);
			}
		}
	}

	public int payment(int tokenNo) throws CustomException {
		Scanner sc = new Scanner(System.in);
		CustomerDetails cusDetails = new CustomerDetails();
		LogicOfParkingLot logicPark = new LogicOfParkingLot();
		

		System.out.println("Enter Name");
		String uName = sc.nextLine();
		System.out.println("Enter Your mobile number");
		long mNo = sc.nextLong();
		sc.nextLine();

		System.out.println("How Much money You wish to have in your wallet");
		double wAmmount = sc.nextDouble();
		sc.nextLine();
		int cId = logicPark.generatCusId();
		System.out.println("Your CustomerId is " + cId);
		cusDetails.setCustomerID(cId);
		cusDetails.setUsName(uName);
		cusDetails.setMobileNumber(mNo);
		cusDetails.setWalletAmmount(wAmmount);
		logicPark.addCustomer(cusDetails, tokenNo);
		logicPark.addCustomerId(cId, tokenNo);
		return cId;

	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ParkingLotRunner run = new ParkingLotRunner();
		LogicOfParkingLot logicPark = new LogicOfParkingLot();
		try {
			run.fullFloorInfo();

			boolean condition = true;
			int fNumber = 0;
			
			while (condition) {
				System.out.println("\nEnter 1-Entry \n 2-Exit \n3-CustomerInfoPortal");
				int sel = sc.nextInt();
				sc.nextLine();
				switch (sel) {
				case 1:
					try {

						Token tObj = new Token();
                            
						boolean condition2 = true;
						System.out.println("Enter Your Vehicle Type");
						String vehicle = sc.nextLine();
						
						
						
							
							
							String vehicleModel = null;
							switch (vehicle) {
							case "Car":
								vehicleModel = "Compact";
								break;

							case "Truck":
								vehicleModel = "Large";
								break;

							case "MotorCycle":
								vehicleModel = "MotorCycle";
								break;

							case "Handicapped":
								vehicleModel = "Handicapped";
								break;

							case "ElectricCar":
								vehicleModel = "ElectricCar";
								break;

							default:
								System.out.println("That vehicle parking is not availbale");

							}
							System.out.println(logicPark.showMsgOnFloor(vehicleModel));
							System.out.println("Enter Vehicle Number");
							int vNumber = sc.nextInt();
							sc.nextLine();
							while (condition2) {
							Spots spot = logicPark.isAvailable(vehicleModel, fNumber);
							if (spot != null) {
								
								
								tObj.setVehicleNumber(vNumber);
								tObj.setVehicleType(vehicle);
								tObj.setFloorNo(fNumber);
								tObj.setEntryTime(System.currentTimeMillis());
								tObj.setTokenNumber(spot.getTokenNo());
								System.out.println("Your Token Number is " + tObj.getTokenNumber() + ", Your Spot no is "
										+ spot.getSpotNo() + " in " + tObj.getFloorNo() + " floor");

						      if(logicPark.existCustomer(vNumber)) {
									 CustomerDetails cus=logicPark.getWalletAmount(vNumber);
									 logicPark.addCustomer(cus, tObj.getTokenNumber());
									logicPark.addCustomerId(cus.getCustomerID(), tObj.getTokenNumber());
									
								 }
								 else {
									int cId=run.payment(tObj.getTokenNumber());
                                    logicPark.addVehAndCusId(vNumber,cId);
									
								 }

				

								logicPark.addToken(tObj);
								logicPark.addVehicle(tObj);
                                  fNumber=0;
								condition2 = false;
							} else {
								System.out.println("this floor " + fNumber + " " + vehicle
										+ " spot  is already full so,not available.So,Choose another floor");
								fNumber++;
							}
						}
					}

					catch (CustomException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					try {
						System.out.println("Enter the Token Number");
						int tNumber2 = sc.nextInt();
						sc.nextLine();
						int vNumber2 = logicPark.getToken(tNumber2);
						
							long time = logicPark.calTime(vNumber2);
							float amount = logicPark.calPayment(time);
							CustomerDetails cus = logicPark.getCusInfo(tNumber2);
							double wAmount = cus.getWalletAmmount();
							if ((wAmount - amount) >= 0) {
								cus.setWalletAmmount(wAmount - amount);

								System.out.println("Successfully payed in CustomerInfoPortal");
								System.out.println("Current wallet amount is" + (wAmount - amount));
							} else {
								System.out.println("Your pay amount is " + Math.abs(wAmount - amount) + "$ for " + time
										+ " hours after reduce in your wallet amount");
								

						
							System.out.println("You Have pay Enter 1-cash or Enter 2-Credit Cards ");
							int credit = sc.nextInt();
							sc.nextLine();
							if (credit == 2) {
								boolean condition2 = true;
								while (condition2) {

									System.out.println("Enter Your Credit Card No");
									long cNo = sc.nextLong();
									sc.nextLine();
									if (String.valueOf(cNo).length() == 16) {
										condition2 = false;
									} else {
										System.out.println("Your credit card no is wrong.so,Enter correctly");
									}

								}
								
							}
							System.out.println("Payment Successfully");
							
						}

						logicPark.addFloorIfExit(tNumber2);

					} catch (CustomException e) {
						System.out.println(e.getMessage());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("Enter CustomerId");
					int cId=sc.nextInt();
					sc.nextLine();
					System.out.println("How much Amount like to deposit cash");
					Float deCash=sc.nextFloat();
					int tId=logicPark.getTokenIdForCusId(cId);
					CustomerDetails cus=logicPark.getCusInfo(tId);
					cus.setWalletAmmount(cus.getWalletAmmount()+deCash);
					System.out.println("In Customer Info portal deposited Sucessfully");
					break;
					

				default:
					logicPark.maps();
					condition = false;
				}
			}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
