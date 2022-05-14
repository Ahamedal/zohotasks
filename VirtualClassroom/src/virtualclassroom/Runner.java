package virtualclassroom;

import java.util.List;
import java.util.Scanner;

public class Runner {
	
    public void askQuestion(int userId) {
    	Scanner sc=new Scanner(System.in);
    	VirtualClassroom objForLogic=new VirtualClassroom();
    	Question q=new Question();
    	System.out.println("Enter Your Question");
    	String ques=sc.nextLine();
    	q.setQuesId(objForLogic.generateQuesId());
    	q.setUserId(userId);
    	q.setSendingTime(System.currentTimeMillis());
    	q.setQuestion(ques);
    	objForLogic.addQuestions(q);
     }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		VirtualClassroom objForLogic=new VirtualClassroom();
		Runner runner=new Runner();
		boolean condition=true;
		while(condition) {
			System.out.println("1.Signin for Existing Customer 2.Signup  ");
			int sel=sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				System.out.println("Enter UserId");
				int userId=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Password");
				String pass=sc.nextLine();
				if(objForLogic.matches(userId,pass)) {
					String usType=objForLogic.getUserType(userId);
					switch(usType) {
					case "Student":
						boolean condition2=true;
						while(condition2) {
							System.out.println("1.Edit Profile  2.Shows list of ppts&interactive video lessons 3.Ask Question 4.Shows Answer");
							int sel2=sc.nextInt();
							sc.nextLine();
							switch(sel2) {
							case 1:
								System.out.println(objForLogic.getProfile(userId));
								System.out.println("1.Edit Name 2.Edit Age 3.Edit gender 4.Edit emailId 5.Edit mobileNo");
								int sel3=sc.nextInt();
								sc.nextLine();
								switch(sel3) {
								case 1:
									System.out.println("Enter Your change name");
									String name=sc.nextLine();
									objForLogic.modifyName(userId, name);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 2:
									System.out.println("Enter Your change age");
									int age=sc.nextInt();
									sc.nextLine();
									objForLogic.modifyAge(userId, age);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 3:
									System.out.println("Enter Your change gender");
									String gender=sc.nextLine();
									objForLogic.modifyGenter(userId, gender);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 4:
									System.out.println("Enter Your change emailId");
									String emailId=sc.nextLine();
									objForLogic.modifyEmailId(userId, emailId);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 5:
									System.out.println("Enter Your change mobileNumber");
									long mNo=sc.nextLong();
									sc.nextLine();
									objForLogic.modifyMobileNo(userId,mNo);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;	
								}
							break;
							case 2:
								System.out.println("1.Tamil 2.English ");
								int sel4=sc.nextInt();
								sc.nextLine();
								switch(sel4) {
								case 1:
									List<Materials> material=objForLogic.getMaterials("Tamil");
									for(int i=0;i<material.size();i++) {
										System.out.println(material.get(i));
									}
									break;
									
								case 2:
									List<Materials> material2=objForLogic.getMaterials("English");
									for(int i=0;i<material2.size();i++) {
										System.out.println(material2.get(i));
									}
									break;
									
								}
								break;
								
							case 3:
								runner.askQuestion(userId);
								break;
								
							case 4:
								System.out.println(objForLogic.getDiscussion());
								break;
								
							case 5:
								condition2=false;
							}
				
						}
					case "Teacher":
						boolean condition3=true;
						while(condition3) {
							System.out.println("1.Edit Profile  2.post ppts or interactive video lessons 3.Ask Question 4.Shows Answer");
							int sel2=sc.nextInt();
							sc.nextLine();
							switch(sel2) {
							case 1:
								System.out.println(objForLogic.getProfile(userId));
								System.out.println("1.Edit Name 2.Edit Age 3.Edit gender 4.Edit emailId 5.Edit mobileNo");
								int sel3=sc.nextInt();
								sc.nextLine();
								switch(sel3) {
								case 1:
									System.out.println("Enter Your change name");
									String name=sc.nextLine();
									objForLogic.modifyName(userId, name);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 2:
									System.out.println("Enter Your change age");
									int age=sc.nextInt();
									sc.nextLine();
									objForLogic.modifyAge(userId, age);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 3:
									System.out.println("Enter Your change gender");
									String gender=sc.nextLine();
									objForLogic.modifyGenter(userId, gender);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 4:
									System.out.println("Enter Your change emailId");
									String emailId=sc.nextLine();
									objForLogic.modifyEmailId(userId, emailId);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;
									
								case 5:
									System.out.println("Enter Your change mobileNumber");
									long mNo=sc.nextLong();
									sc.nextLine();
									objForLogic.modifyMobileNo(userId,mNo);
									System.out.println("Modified Successfully\n"+objForLogic.getProfile(userId));
									break;	
								}
							break;
							case 2:
								//runner.postMetrials(userId);
								break;
								
							case 3:
								runner.askQuestion(userId);
								break;
								
							case 4:
								System.out.println(objForLogic.getDiscussion());
								break;
							}
						}
						
					}
				}
			}
		}
	}
}
