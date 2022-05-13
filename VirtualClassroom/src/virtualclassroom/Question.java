package virtualclassroom;

public class Question {
private int quesId;
private String question;
private int userId;
private boolean answer=false;
private long sendingTime;
public int getQuesId() {
	return quesId;
}
public void setQuesId(int quesId) {
	this.quesId = quesId;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public boolean isAnswer() {
	return answer;
}
public void setAnswer(boolean answer) {
	this.answer = answer;
}
public long getSendingTime() {
	return sendingTime;
}
public void setSendingTime(long sendingTime) {
	this.sendingTime = sendingTime;
}


}
