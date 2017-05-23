package weatherData;



import javax.swing.JLabel;

import org.apache.axis2.AxisFault;







public class Time implements WeatherMonitor {
private String timestamp ; 
private String type; 
private JLabel lblTime; 
iTime service;



public Time(iTime time) throws AxisFault{
	this.service = time;
	this.type = "time"; 
	

}
public String getData() {
	
      return this.timestamp;
   }
   
   public void update( String name) {
	 
	this.timestamp = service.getTime(name); 
	  
	   
   
}
     
   // Called to display output in the JTextArea
      
   public JLabel display(){
	this.lblTime= new JLabel();
	this.lblTime.setText( ("\n\t@ Time:\t" + getData()));
	this.lblTime.setSize(400, 30);
		return this.lblTime ;}
   
@Override
public String getType() {
	// TODO Auto-generated method stub
	return this.type; 
}


}