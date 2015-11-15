import java.util.ArrayList;

public class Incident {
	private int incidentNumber;
	private int time;
	private String date;
	private String type;
	private String location;
	private ArrayList<Vehicle> assignedVehicles = new ArrayList<>();
	private String urgency;
	
	public int getNumber(){
		return incidentNumber;
	}
	
	public void setNumber(int number){
		incidentNumber = number;
		
	}
	
	public int getTime(){
		return time;
	}
	
	public void setTime(int newTime){
		time = newTime;
	}

	public String getDate(){
		return date;
	}
	
	public void setDate(String newDate){
		date = newDate;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String newType){
		type = newType;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setLocation(String newLocation){
		location = newLocation;
	}
	
	public ArrayList<Vehicle> getVehicles (){
		return assignedVehicles;
	}
	
	public void setVehicles(ArrayList<Vehicle> newVehicles){
		assignedVehicles = newVehicles;
	}
	
	public String getUrgency(){
		return urgency;
	}
	
	public void setUrgency(String newUrgency){
		urgency = newUrgency;
	}
	
}
