package librarymanagementsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    DBLayer db=new DBLayer();
	Timer time=new Timer();
	public TimerDemo(int seconds) {
		time.schedule(new RemindTask(), seconds*1000);
	}
	class RemindTask extends TimerTask{
		public void run() {
			String current=currentTime();
			List<String> lis=db.getNotification(current);
			if(!(lis==null)) {
				for(int i=0;i<lis.size();i++) {
		           System.out.println(lis.get(i)+" send to message - today is due date so,return book if no return book fine to book");
				}
			}
		}
		public String currentTime() {
			long currentTime=System.currentTimeMillis();
			SimpleDateFormat si=new SimpleDateFormat("HH:mm:ss");
			Date dateObj=new Date(currentTime);
			return si.format(dateObj);
		}
	}
}
