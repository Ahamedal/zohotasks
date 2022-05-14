package virtualclassroom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VirtualClassroom {
 
	List<User> studentList=new ArrayList<>();
	List<User> teacherList=new ArrayList<>();
	Map<Integer,User> totalSignUpList=new HashMap<>();
	Map<Integer,List<Question>> questionList=new HashMap<>();
	Map<String,String> discussion=new HashMap<>();
	Map<Integer,Answer> answerList=new HashMap<>();
	Map<String,List<Materials>> materials=new HashMap<>();
	
	int quesId=1000;
	public int generateQuesId() {
		return ++quesId;
	}
	public void addUser(User userObj) {
		totalSignUpList.put(userObj.getUserId(), userObj);
	}
	public void addQuestions(Question question) {
		List<Question> lis=questionList.get(question.getUserId());
		if(lis==null) {
			lis=new ArrayList<>();
			questionList.put(question.getQuesId(), lis);
		}
		lis.add(question);
	}
	public void addAnswer(Answer ans) {
		answerList.put(ans.getQuestionId(), ans);
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
			studentList.add(us);
		}
		else {
			teacherList.add(us);
		}
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
		if(totalSignUpList.containsKey(userId)) {
			User us=totalSignUpList.get(userId);
			if(us.getPassword().equals(pass)&&studentList.contains(us)) {
				return true;
			}
		}
		return false;
	}
	public String getUserType(int userId) {
		User us=totalSignUpList.get(userId);
		return us.getUserTyp();
	}
	public Map<String,String> getDiscussion(){
		return discussion;
	}
}
