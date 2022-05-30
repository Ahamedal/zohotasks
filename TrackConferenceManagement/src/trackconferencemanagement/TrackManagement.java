package trackconferencemanagement;

import java.util.ArrayList;
import java.util.List;

public class TrackManagement {

	 List<Track> trackList=new ArrayList<>();
     
	    public List<Track> getTrackLis(){
	    return trackList;
	    }
	public Event createEvent(String name) {
	int durtion=0;
	String[] ar=name.split(" ");
	String duratio=ar[ar.length-1];
	if(duratio.equals("lightning")) {
	durtion=5;
	}
	else {
	int i=0;
	while(duratio.charAt(i)!='m') {
	durtion=(durtion*10)+((int)duratio.charAt(i)-(int)'0');
	i++;
	}
	}
	Event events=new Event();
	events.setName(name);
	events.setDuration(durtion);
	return events;

	}
	public boolean checkUnfillEvent(Event evnt) {
	for(Track tr:trackList) {

	if(tr.getMorningTime()+evnt.getDuration()<=180) {
	List<Event> morningSession=tr.getMorningSession();
	morningSession.add(evnt);
	evnt.setTime(timeSet(tr.getMorningTime()));
	tr.setMorningTime(tr.getMorningTime()+evnt.getDuration());
	return true;
	}
	else if(tr.getAfternoonTime()+evnt.getDuration()<=480) {
	List<Event> afternoonSession=tr.getAfternoonSession();
	afternoonSession.add(evnt);
	evnt.setTime(timeSet(tr.getAfternoonTime()));
	tr.setAfternoonTime(tr.getAfternoonTime()+evnt.getDuration());
	return true;
	}
	}
	return false;
	}
	public String timeSet(int time) {
	String resu="";

	if((9+time/60)<12) {
	resu=(9+time/60)+"";

	resu+=":"+time%60;
	resu+=" AM";
	}
	else {
	resu=(9+time/60)-12+"";

	resu+=":"+time%60;
	resu+=" PM";
	}
	   return resu;
	}
	public void createTrack(List<Event> events) {
	Track trak=new Track();
	List<Event> morningSession=trak.getMorningSession();
	List<Event> afternoonSession=trak.getAfternoonSession();
	for(Event evnt:events) {
	if(evnt.getDuration()>240) {
	continue;
	}
	if(checkUnfillEvent(evnt)) {
	continue;
	}
	if(evnt.getDuration()<=240&&trak.getMorningTime()+evnt.getDuration()>180&&trak.getAfternoonTime()+evnt.getDuration()>480) {
	trackList.add(trak);
	trak=new Track();
	morningSession=trak.getMorningSession();
	afternoonSession=trak.getAfternoonSession();

	}
	if(trak.getMorningTime()+evnt.getDuration()<=180) {
	morningSession.add(evnt);
	evnt.setTime(timeSet(trak.getMorningTime()));
	trak.setMorningTime(trak.getMorningTime()+evnt.getDuration());
	}
	else {
	   afternoonSession.add(evnt);
	   evnt.setTime(timeSet(trak.getAfternoonTime()));
	   trak.setAfternoonTime(trak.getAfternoonTime()+evnt.getDuration());
	}
	}
	trackList.add(trak);
	}
}
