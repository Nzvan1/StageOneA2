package Monitors;

import java.util.ArrayList;









import obsPattern.Subject;
import weatherData.WeatherMonitor;


public class GraphMonitor extends GeneralMonitor  {
	private String name; 
	private ArrayList<WeatherMonitor> weatherMonitors;
	private ArrayList<GraphView> views ;
	private String type; 
	private Subject subject ;

	

	public GraphMonitor(String name, ArrayList<WeatherMonitor>  w   ){
		this.name = name; 
		this.type = "graph"; 
		
		this.weatherMonitors = w; 

		this.views = new ArrayList<GraphView>();
		addView(); 
	}
	public String getType(){
		return this.type; 
	}
	public void setSubject(Subject s ){
		this.subject =s ;
	}
	@Override
	public void addView(){
		GraphView v = new GraphView(this);
		this.views.add(v );
		if((this.views.size()>1)){
		v.update();}
	}

	public void removeView(GraphView graphView){
		this.views.remove(graphView); 
		if(this.views.isEmpty()){
			 System.out.println("Dettach");
		this.subject.detach(this);}
	}
	public String getName(){
		return this.name; 
	}

	 

	public void setName( String name){
		this.name = name ;} 
		
		public  ArrayList<WeatherMonitor> getWeatherData(){
			return this.weatherMonitors;
		}
		public void setWeatherMonitor( ArrayList<WeatherMonitor> w){
			this.weatherMonitors = w; }
			
	 public void update(){
		 ArrayList<WeatherMonitor>  w  = getWeatherData(); 
		
		 for ( int i =0 ; i< w.size(); i++){
			( w.get(i)).update(this.name); }

		 for ( int a =0 ; a< this.views.size(); a++){
			 this.views.get(a).update();
		 
		 }
		 
			 
	 }
}
