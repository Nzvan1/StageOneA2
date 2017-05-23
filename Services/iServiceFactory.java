package Services;

import org.apache.axis2.AxisFault;

public interface iServiceFactory {
public  WeatherService createService( String name) throws AxisFault; 
}
