package weatherData;

import javax.swing.JLabel;





public interface WeatherMonitor  {
	public  JLabel display();
	public void update(String name ); 
	public String getData();
    public String getType();
 
}

//We assume that in terms of having more than one monitor per location 
//this imply that we have more than one kind of weather monitor for example temperature and/or rainfall