package virtualclassroom;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@Override
public String toString() {
	Date da1=new Date(answerTime);
    long hours=resolutionTime/(60*60*1000);
    long minutes=(resolutionTime/(60*1000))%60;
    long seconds=(resolutionTime/1000)%60;
	return "Answer [questionId=" + questionId + ", userId=" + userId + ", ans=" + ans + ", answerTime=" + da1
			+ ", resolutionTime=" +hours+":"+minutes+":"+seconds+ "]";
}

}
