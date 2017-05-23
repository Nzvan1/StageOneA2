package weatherData;

import Services.WeatherService;

public interface iWeatherFactory {
 public WeatherMonitor getWeatherMonitor(String monitorType, WeatherService service);
}
