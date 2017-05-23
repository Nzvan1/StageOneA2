package weatherData;


import javax.swing.JLabel;

public class Rainfall implements WeatherMonitor {

	private String name;
	private iRainfall service; 
	private String type; 



	private String rainfall; 
	public Rainfall(iRainfall service) { 
		this.service =service; 
		
		this.type = "rainfall"; 
	}
	@Override
	public String getData() {
		return rainfall;
	}
	public void update(String name ) {

		this.rainfall = service.getRainfall(this.name); 

	}


	// Called to display output in the JTextArea 
	@Override
	public JLabel display(){


		JLabel  lbl  = new JLabel ( "\n\tRainfall:\t" + this.getData());
		lbl.setSize(400, 30);

		return lbl;
	}
	@Override
	public String getType() {
		
		return this.type;
		
	}
	

}   




