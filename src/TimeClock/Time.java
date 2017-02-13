package TimeClock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Time implements Subject{
	
	private List<Observer> observerList;
	private Timer timer;
	
	private Date time;
	
	public Time(){
		this.observerList = new ArrayList<>();
		this.timer = new Timer();
		
		this.time = Calendar.getInstance().getTime();
		notifyObserver();
		
		
		this.timer.schedule(new TimeTask(), this.time, 1000);
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < this.observerList.size(); i++){
			this.observerList.get(i).update(this.time);
		}
		
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observerList.add(observer);
		
	}

	@Override
	public void deleteObserver(Observer observer) {
		if(this.observerList.contains(observer)){
			int index = this.observerList.indexOf(observer);
			this.observerList.remove(index);
		}
		
	}
	
	private class TimeTask extends TimerTask{
		@Override
		public void run() {
			time = Calendar.getInstance().getTime();
			notifyObserver();
		}
		
	}

}
