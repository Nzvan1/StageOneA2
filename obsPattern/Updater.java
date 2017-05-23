package obsPattern;

import java.util.*;

public class Updater implements Subject {

	HashSet<Observer> Observers = new HashSet<Observer>();
	
	
	public void attach(Observer o) {
		
		Observers.add(o);
	}
	
	public void detach(Observer o) {
		
		Observers.remove(o);
	}
	
	
	
	/* 
	 * Notify All Locations.
	 */
	public void notifyObservers() {
		
		for (Observer o : Observers) {
			System.out.println("5min" + Observers.toString());
			
			
			o.update();
		
			}
		}

		
		public void startClock(){
			Timer t = new Timer();
			t.schedule(new TimerTask() {
			    @Override
			    public void run() {
			    
			    	System.out.println("Time Ticked Updated 5min");
			     notifyObservers();}
			    
			}, 0,300000);
		}
	
}	
		
		
		
		
	

