package controller;

import java.util.ArrayList;

import obsPattern.Observer;
import obsPattern.Subject;
import obsPattern.TwentyUpdater;
import obsPattern.Updater;

import org.apache.axis2.AxisFault;

import weatherData.WeatherFactory;
import weatherData.WeatherMonitor;
import weatherData.iWeatherFactory;
import Monitors.GeneralMonitor;
import Monitors.MonitorFactory;
import Monitors.iMonitorFactory;
import Services.ServiceWFactory;
import Services.WeatherService;
import Services.iServiceFactory;

public class Controller {
	
	final Subject update = new Updater() ;
	final Subject update20 = new TwentyUpdater() ;
	final iWeatherFactory weatherF = WeatherFactory.getInstance(); 
	final iServiceFactory servicef = ServiceWFactory.getInstance(); 
	final iMonitorFactory monitorf = MonitorFactory.getInstance(); 
	private  static Controller controller;
	private ArrayList<GeneralMonitor> created = new ArrayList<GeneralMonitor>(); 
	private ArrayList<String> services = new ArrayList<String>(); 
	protected Controller(){
	

}
	public static Controller getInstance(){
		if (controller== null ){
			return controller = new Controller(); 
		}
		else{
     return controller;
	}
}

public void createMonitor(String location, String monType,String service, ArrayList<String>weatherData){ 

    WeatherService webService =  null;
    try {
	 webService = servicef.createService(service);
	} catch (AxisFault e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
    GeneralMonitor monitor = null; 
    ArrayList<WeatherMonitor> weatherMonitors ;
    weatherMonitors = new ArrayList<WeatherMonitor>();
    for ( int i = 0 ; i< weatherData.size(); i++){
    	weatherMonitors.add( weatherF.getWeatherMonitor(weatherData.get(i),webService));}
    
   //Check if the monitor is already create if so add a view instead
       boolean view = false ;
       
    for(int a = 0 ; a < created.size() ; a++){
    	 
    			if (created.get(a).getType().equalsIgnoreCase(monType)){
    				System.out.println(created.get(a).getType());
    				System.out.println(created.get(a).getType().equalsIgnoreCase(monType));
    	if ( (created.get(a).getName().equalsIgnoreCase( location))){
    		System.out.println("LOC"+ (created.get(a).getName().equals( location)));
    		if ((services.get(a)).equalsIgnoreCase(service)){
    			System.out.println( "Services" +(services.get(a)).equals(service)); 
    		 
        ArrayList<WeatherMonitor> checkWeather =created.get(a).getWeatherData();
        		for (int b = 0 ; b < checkWeather.size(); b++){
        			System.out.println("WeatherString "+ weatherData.get(b));
        			System.out.println("Weather(inlist)"+ checkWeather.get(b).getType());
        			System.out.println("Weather"+ weatherData.get(b).equals(checkWeather.get(b).getType()));
        			System.out.println("Array"+ b + checkWeather.toString());
        		if(	(weatherData.get(b).equalsIgnoreCase((checkWeather.get(b).getType())))){
        		     view = true ;
        		    		 monitor = created.get(a);}
        		     else{
        		    	 view = false;
        		     }
        		}
        		}
        		
        	
             	}    }   
    			if( view == true){
    				 monitor = created.get(a);
    				 System.out.print(monitor);
    			}
    	}
    			
    			
    
    
   if (view == false){
	   System.out.println("Creats Monitor");
	 monitor = monitorf.getMonitor(monType, weatherMonitors,location);
	 System.out.println(monitor +"List "+  monitor.getWeatherData().toString());
	 created.add(monitor);
	 services.add(service); 
	 
    
    Observer o = null; 

    
    
           if( service =="MelbournWeather2"){
        	   System.out.println(weatherMonitors.toString());
        	   System.out.println(monitor);
        	   System.out.println(update);
        	   monitor.setSubject(update);
        	   o = monitor;
        	   System.out.println(o.toString()); 
        	   System.out.println(o);
        	   o.update();
        	   update.attach(o);
          
       
   
           }
        	   
        	   if (service =="MelbourneTimelapse"){
        		   monitor.setSubject(update20);
        		   o = monitor ; 
        		   o.update();
        		   update20.attach(o); 
        		  
        	   }
        	 
 }
   else {
	   System.out.println("Creats View");
   System.out.println(monitor);
   System.out.println("Creats View/////////////////////////////////////////////////////////////");
	   monitor.addView(); 
	   
}
}
}
