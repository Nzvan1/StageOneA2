package obsPattern;

import java.util.*;

public class TwentyUpdater implements Subject {
	private boolean started = false;

	HashSet<Observer> Observers = new HashSet<Observer>();
	
	
	public void attach(Observer o) {
		if( started== false){
		startClock();
		started=true;
		
		}
		
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
			;
			o.update();
			
			}}
		
		
		
	

public void startClock(){
	Timer t = new Timer();
	t.schedule(new TimerTask() {
	    @Override
	    public void run() {
	    
	    
	     notifyObservers();}
	    
	}, 0,20000);
}}

