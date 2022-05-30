package trackconferencemanagement;

public class Event {
	private String name;
	private int duration;
	private String time;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public int getDuration() {
	return duration;
	}
	public void setDuration(int duration) {
	this.duration = duration;
	}

	public String getTime() {
	return time;
	}
	public void setTime(String time) {
	this.time = time;
	}
	@Override
	public String toString() {
	return time +" "+  name ;
	}
}
