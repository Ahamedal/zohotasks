package virtualclassroom;

public class Answer {
private int questionId;
private int userId;
private String ans;
private long answerTime;
private long resolutionTime;
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAns() {
	return ans;
}
public void setAns(String ans) {
	this.ans = ans;
}
public long getAnswerTime() {
	return answerTime;
}
public void setAnswerTime(long answerTime) {
	this.answerTime = answerTime;
}
public long getResolutionTime() {
	return resolutionTime;
}
public void setResolutionTime(long resolutionTime) {
	this.resolutionTime = resolutionTime;
}

}
