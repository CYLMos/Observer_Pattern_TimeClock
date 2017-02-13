package TimeClock;

public interface Observer<T> {
	
	public void update(T param);
	
	public void display(String sParam);
}
