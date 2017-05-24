package Monitors;

import java.util.ArrayList;

import weatherData.WeatherMonitor;

public interface iMonitorFactory {

	public GeneralMonitor getMonitor(String Type,
			ArrayList<WeatherMonitor> weatherMonitors, String name);

}
