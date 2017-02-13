package TimeClock;

public interface Subject {

	public void notifyObserver();
	
	public void registerObserver(Observer observer);
	
	public void deleteObserver(Observer observer);
}
