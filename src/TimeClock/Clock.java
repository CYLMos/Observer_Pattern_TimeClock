package TimeClock;

import java.util.Date;
import java.util.List;

public class Clock implements Observer<Date>{
	
	private Subject Time;
	
	public Clock(Subject time){
		this.Time = time;
		this.Time.registerObserver(this);
	}

	@Override
	public void update(Date time) {
		Date dateTime = (Date)time;
		@SuppressWarnings("deprecation")
		String timeString = dateTime.toGMTString();
		display(timeString);
	}

	@Override
	public void display(String time) {
		System.out.println(time);
		
	}

}
