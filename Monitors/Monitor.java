package Monitors;


import java.util.ArrayList;






import obsPattern.Subject;
import weatherData.WeatherMonitor;


public class Monitor extends GeneralMonitor {
private String name; 
private ArrayList<WeatherMonitor> weatherMonitors;

private ArrayList<MonitorView> views;
private Subject subject; 
private String type ;

public Monitor(String name, ArrayList<WeatherMonitor>  w ){
	this.name = name; 
	this.type = "text"; 
	this.weatherMonitors = w; 

	this.views = new ArrayList<MonitorView>();
	addView(); 
	//loc.add(this); 
}
@Override
public String getType(){
	return this.type; 
}

@Override
public String getName(){
	return this.name; 
}
public void setName( String name){
	this.name = name ;} 

@Override
public void setSubject(Subject s ){
	this.subject =s ;
}
@Override
public void addView(){
	MonitorView v = new MonitorView(this);
	this.views.add(v );
	if((this.views.size()>1)){
	v.update();}
}

public void removeView(MonitorView v){
	
	this.views.remove(v); 
	if (views.isEmpty()){
		 System.out.println("Dettach");
	this.subject.detach(this);}
}
@Override	
	public  ArrayList<WeatherMonitor> getWeatherData(){
		return this.weatherMonitors;
	}
	public void setWeatherData( ArrayList<WeatherMonitor> w){
		this.weatherMonitors = w; }
		

	
	 @Override
	public void update(){
			// Don't update if there are no view for the location  

			 if (!(views.isEmpty())){
			 
			
				 
			
			 for ( int i =0 ; i< this.weatherMonitors.size(); i++){
				( weatherMonitors.get(i)).update(this.name); }

			 for ( int i =0 ; i< this.views.size(); i++){
				 this.views.get(i).update();
			 
			 }
	 
 
	
			 
	 }
		
 
 
 }
}