package Monitors;

import java.util.ArrayList;

import obsPattern.Observer;
import obsPattern.Subject;
import weatherData.WeatherMonitor;

public abstract class GeneralMonitor implements Observer {
public abstract void update();
public abstract void setSubject(Subject update); 
public abstract String getType();
public abstract String getName();
public abstract void addView(); 
public abstract  ArrayList<WeatherMonitor> getWeatherData(); 
}
