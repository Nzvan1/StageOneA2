package Services;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import melbourneweathertimelapse.ExceptionException;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetLocationsResponse;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetWeather;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetWeatherResponse;





public class MelTimeLapseAdapter extends WeatherService{
	static MelbourneWeatherTimeLapseStub MelTimelapse;
	
	private String temp;
	private String rainfall;
	private 	GetWeatherResponse weatherResponse; 
	 
	public MelTimeLapseAdapter()  {
		try {
		MelTimelapse = new MelbourneWeatherTimeLapseStub(); 
		}
		catch( AxisFault a){
			a.printStackTrace();
		}
		}
	public void getWeatherData(){
		
	}
	public String[] getLocations(){

			GetLocationsResponse LocationsResponse = null;
			try {
				LocationsResponse = MelTimelapse.getLocations();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] Locations = LocationsResponse.get_return();
			return Locations;
	  }
	  public String getTemperature(String name){

	
			String[] weather = this.weatherResponse.get_return();
			this.temp = weather[1]; 
			double kelvin = Double.parseDouble((temp));
			kelvin = kelvin - 273.15 ; 
			this.temp = Double.toString( kelvin) ; 
		  
		  return this.temp; 
	  }
	  public String getRainfall(String name){
		
			
			String[] weather = this.weatherResponse.get_return();
			this.rainfall = weather[2]; 
			double rainConversion = (Double.parseDouble(this.rainfall)*10 ); 
			this.rainfall=(String.valueOf(rainConversion)); 
			
			return this.rainfall; 
	  }
	  public String getTime(String name ){
		  GetWeather weatherRequest = new GetWeather();
			weatherRequest.setLocation(name);
			GetWeatherResponse weatherResponse = null;
			try {
				this.weatherResponse = MelTimelapse.getWeather(weatherRequest);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] weather = this.weatherResponse.get_return();
			return weather[0]; 
			 
	  }
	   
	}


