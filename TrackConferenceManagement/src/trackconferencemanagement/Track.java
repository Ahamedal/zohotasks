package trackconferencemanagement;

import java.util.ArrayList;
import java.util.List;

public class Track {

	  private List<Event> morningSession=new ArrayList<>();
	    private List<Event> afternoonSession=new ArrayList<>();
	    private int morningTime=0;
	private int afternoonTime=240;


	public List<Event> getMorningSession() {
	return morningSession;
	}
	public void setMorningSession(List<Event> morningSession) {
	this.morningSession = morningSession;
	}
	public List<Event> getAfternoonSession() {
	return afternoonSession;
	}
	public void setAfternoonSession(List<Event> afternoonSession) {
	this.afternoonSession = afternoonSession;
	}
	public int getMorningTime() {
	return morningTime;
	}
	public void setMorningTime(int morningTime) {
	this.morningTime = morningTime;
	}
	public int getAfternoonTime() {
	return afternoonTime;
	}
	public void setAfternoonTime(int afternoonTime) {
	this.afternoonTime = afternoonTime;
	}
	public String toString() {
	String resu="";
	for(Event event:morningSession) {
	resu+=event.toString()+"\n";
	}
	resu+="12:00 PM Lunch"+"\n";
	for(Event event:afternoonSession) {
	resu+=event.toString()+"\n";
	}
	if(afternoonTime<420) {
	resu+="4:0 PM Networking Event";
	}
	else {
	resu+=((afternoonTime/60)-3)+":"+(afternoonTime%60)+" PM"+" Networking Event";
	}
	return resu;
	}
}
