package weatherData;

import org.apache.axis2.AxisFault;

import Services.WeatherService;


public class WeatherFactory implements iWeatherFactory {
	private static WeatherFactory instance; 
	 protected WeatherFactory() {
	      // Exists only to defeat instantiation.
	   }
	   public static WeatherFactory getInstance() {
	      if(instance == null) {
	         instance = new WeatherFactory();
	      }
	      return instance;
	   }
	   

		   //use get monitor method to get object of type monitor 
		   public WeatherMonitor getWeatherMonitor(String monitorType,WeatherService service ){
			   WeatherMonitor data = null; 
		      if(monitorType == null){
		          data = null;
		      }		
		      if(monitorType.equalsIgnoreCase("RAINFALL")){
		    	
		          data = new Rainfall((iRainfall)service);
		         
		      } if(monitorType.equalsIgnoreCase("TEMPERATURE")){
		    	 
		          data = new Temperature((iTemperature) service);
		         
		      } if(monitorType.equalsIgnoreCase("TIME")){
		    	 
		         try {
					data = new Time((iTime)(service));
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
			return data;
}
}