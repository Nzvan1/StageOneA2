package Services;

import weatherData.iRainfall;
import weatherData.iTemperature;
import weatherData.iTime;

public abstract class  WeatherService implements iRainfall, iTime ,iTemperature   {
  public abstract String[] getLocations(); 
  public abstract String getTemperature(String n); 
  public abstract String getRainfall(String n); 
  public abstract String getTime(String n ); 
}
