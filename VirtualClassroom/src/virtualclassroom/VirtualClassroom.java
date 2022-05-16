package virtualclassroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualClassroom {
 
	static List<User> studentList=new ArrayList<>();
	static List<User> teacherList=new ArrayList<>();
	static Map<Integer,User> totalSignUpList=new HashMap<>();
	
	static Map<Integer,List<Question>> questionList=new HashMap<>();
	static Map<Integer,Question> answeredQuestion=new HashMap<>();
	static Map<Integer,Question> notAnsweredQuestionList=new HashMap<>();
	static Map<Question,Answer> discussion=new HashMap<>();
	static Map<Integer,Answer> answerList=new HashMap<>();
	
	static Map<String,List<Materials>> materials=new HashMap<>();
	static int userId=0;
	public int generateUserId() {
		return ++userId;
	}
	static int quesId=1000;
	public int generateQuesId() {
		return ++quesId;
	}
	public void addUser(User userObj) {
		totalSignUpList.put(userObj.getUserId(), userObj);
		if(userObj.getUserTyp().equals("Student")) {
			studentList.add(userObj);
		}
		else if(userObj.getUserTyp().equals("Teacher")) {
			teacherList.add(userObj);
		}
		
	}
	public void addQuestions(Question question) {
		List<Question> lis=questionList.get(question.getUserId());
		if(lis==null) {
			lis=new ArrayList<>();
			questionList.put(question.getQuesId(), lis);
		}
		lis.add(question);
		notAnsweredQuestionList.put(question.getQuesId(), question);
	}
	public void addAnswer(Answer ans) {
		answerList.put(ans.getQuestionId(), ans);
		notAnsweredQuestionList.get(ans.getQuestionId()).setAnswer(true);
		answeredQuestion.put(ans.getQuestionId(),notAnsweredQuestionList.get(ans.getQuestionId()) );
		discussion.put(notAnsweredQuestionList.get(ans.getQuestionId()), ans);
		notAnsweredQuestionList.remove(ans.getQuestionId());
	}
	public void addMaterials(Materials mat) {
		List<Materials> lis=materials.get(mat.getSubject());
		if(lis==null) {
			lis=new ArrayList<>();
			materials.put(mat.getSubject(), lis);
		}
		lis.add(mat);
	}
	public void allowClassroom(int userId) {
		User us=totalSignUpList.get(userId);
		us.setPending(false);
		if(us.getUserTyp().equals("Student")) {
			studentList.remove(us);
		}
		else {
			teacherList.remove(us);
		}
	}
	public List<User> studentPendingList(){
		return studentList;
	}
	public List<User> teacherPendingList(){
		return teacherList;
	}
	public Map<Integer,User> getSignUp(){
		return totalSignUpList;
	}
	public User getProfile(int usId) {
		return totalSignUpList.get(usId);
	}
	public void modifyName(int usId,String name) {
		User us=totalSignUpList.get(usId);
		us.setName(name);
	}
	public void modifyAge(int usId,int age) {
		User us=totalSignUpList.get(usId); 
		us.setAge(age);
	}
	public void modifyGenter(int usId,String gender) {
		User us=totalSignUpList.get(usId);
		us.setGenter(gender);
	}
	public void modifyEmailId(int usId,String emailId) {
		User us=totalSignUpList.get(usId);
		us.setEmailId(emailId);
	}
	public void modifyMobileNo(int usId,long mNo) {
		User us=totalSignUpList.get(usId);
		us.setMobileNo(mNo);
	}
	public List<Materials> getMaterials(String sub){
		return materials.get(sub);
	}
	public boolean matches(int userId,String pass) {
		if(userId==100001&&pass.equals("admin12")) {
			return true;
		}
		else {
		if(totalSignUpList.containsKey(userId)) {
			User us=totalSignUpList.get(userId);
			if(us.getUserTyp().equals("Student")) {
			if((us.getPassword().equals(pass)&&!studentList.contains(us))) {
				return true;
			}
			}
			else {
				if(us.getPassword().equals(pass)&&!teacherList.contains(us)) {
					return true;
				}
			}
		}
		}
		return false;
	}
	public Map<Integer,List<Question>> getQuestion(){
		return questionList;
	}
	public String getUserType(int userId) {
		User us=totalSignUpList.get(userId);
		return us.getUserTyp();
	}
	public Map<Integer,Question> getNotAnsweredQuestionList(){
		return notAnsweredQuestionList;
	}
	public Map<Question,Answer> getDiscussion(){
		return discussion;
	}
	public void deleteQuestion(int quesId) {
		Question que=answeredQuestion.get(quesId);
		answeredQuestion.remove(quesId);
		answerList.remove(quesId);
		discussion.remove(que);
	}
}
