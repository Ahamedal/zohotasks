package virtualclassroom;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {
	public void admin() {
		User us=new User();
		VirtualClassroom objForLogic=new VirtualClassroom();
		us.setAge(20);
		us.setEmailId("admin12@gmail.com");
		us.setMobileNo(11);
		us.setGenter("male");
		us.setName("admin");
		us.setPassword("admin12");
		us.setPending(true);
		us.setUserId(100001);
		us.setUserTyp("Admin");
		objForLogic.addUser(us);
		
	}
	public void postMaterials(int userId) {
		Scanner sc=new Scanner(System.in);
    	VirtualClassroom objForLogic=new VirtualClassroom();
    	Materials m=new Materials();
        System.out.println("What Subject material do post");
        String sub=sc.nextLine();
        System.out.println("What type of material do post");
        String type=sc.nextLine();
        m.setFileSize("100Mb");
        m.setMaterialType(type);
        m.setPostTim(System.currentTimeMillis());
        m.setSubject(sub);
        m.setUserId(userId);
        objForLogic.addMaterials(m);
	}
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
		runner.admin();
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
								break;
							}
							
				
						}
						break;
					case "Teacher":
						boolean condition3=true;
						while(condition3) {
							System.out.println("1.Edit Profile  2.post ppts or interactive video lessons 3.show all Question 4.to Answer");
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
								runner.postMaterials(userId);
								break;
								
							case 3:
								System.out.println(objForLogic.getQuestion());
								break;
								
							case 4:
								Map<Integer,Question> notAnswered=objForLogic.getNotAnsweredQuestionList();
								for(Integer key:notAnswered.keySet()) {
									System.out.println(key+" = "+notAnswered.get(key).getQuestion());
								}
								System.out.println("Enter question Id what question to answer");
								int quesId=sc.nextInt();
								sc.nextLine();
								System.out.println("Enter Answer that question");
								String answ=sc.nextLine();
								Answer answer=new Answer();
								answer.setAns(answ);
								answer.setAnswerTime(System.currentTimeMillis());
								answer.setQuestionId(quesId);
								answer.setResolutionTime(Math.abs(notAnswered.get(quesId).getSendingTime()-answer.getAnswerTime()));
								answer.setUserId(userId);
								objForLogic.addAnswer(answer);
								break;
								
							case 5:
								condition3=false;
								break;
								
							}
						}
						break;
					case "Admin":
						 boolean condition4=true;
						 while(condition4) {
							 System.out.println("1.display a list of register students/teacher 2.student/teacher signup request still pending 3.delete Question and answer");
							 int sel4=sc.nextInt();
							 sc.nextLine();
							 switch(sel4) {
							 case 1:
								 System.out.println(objForLogic.getSignUp());
								 break;
								 
							 case 2:
								 System.out.println("Student pending list\n"+objForLogic.studentPendingList());
								 System.out.println("Teacher pending list\n"+objForLogic.teacherPendingList());
								 System.out.println("Enter userId to allow virtual classroom");
								 int us=sc.nextInt();
								 sc.nextLine();
								 objForLogic.allowClassroom(us);
								 break;
								 
							 case 3:
								 System.out.println("Total discussion List\n"+objForLogic.getDiscussion());
								 System.out.println("If You Delete to Question 1-yes 2-no");
								 int sel6=sc.nextInt();
								 sc.nextLine();
								 if(sel6==1) {
									 System.out.println("Enter Question Id you want to delete");
									 int quesId=sc.nextInt();
									 sc.nextLine();
									 objForLogic.deleteQuestion(quesId);
								 }
								 break;
								 
							 case 4:
								 condition4=false;
							 }
						 }
					}
					
				}
				else {
					System.out.println("Your userId and password is wrong or  not permission to classroom contact admin");
				}
				break;
				
			case 2:
				User us=new User();
				System.out.println("Enter your name");
				String name=sc.nextLine();
				System.out.println("Enter your age");
				int age=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter your genter");
				String genter=sc.nextLine();
				System.out.println("Enter EmailId");
				String emailId=sc.nextLine();
				System.out.println("Enter mobile No");
				long mbN=sc.nextLong();
				sc.nextLine();
				System.out.println("userType is you have 1-teacher 2-student");
				int sel11=sc.nextInt();
				sc.nextLine();
				String usType=null;
				switch(sel11) {
				case 1:
				usType="Teacher";
				break;
				case 2:
				usType="Student";
				}
				us.setAge(age);
				us.setEmailId(emailId);
				us.setMobileNo(mbN);
				us.setGenter(genter);
				us.setName(name);
				System.out.println("Enter your password");
				String pas=sc.nextLine();
				us.setPassword(pas);
				us.setUserId(objForLogic.generateUserId());
				System.out.println("Your customerId is "+us.getUserId());
				us.setUserTyp(usType);
				objForLogic.addUser(us);
				
				
				
				
				break;
				
			case 3:
				condition=false;
			
			}
		}
	}
}
