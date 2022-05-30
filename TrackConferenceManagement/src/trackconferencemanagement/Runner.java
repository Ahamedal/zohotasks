package trackconferencemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		TrackManagement manager=new TrackManagement();
		List<Event> ev=new ArrayList<>();
		System.out.println("Enter Events");
		String events=sc.nextLine();
		while(!events.equals("end")) {
		Event e=manager.createEvent(events);
		events=sc.nextLine();

		ev.add(e);

		}
		manager.createTrack(ev);
		List<Track> lis=manager.getTrackLis();
		for(int i=0;i<lis.size();i++) {
		System.out.println("Track "+(i+1));
		System.out.println(lis.get(i));
		}

		}
}
