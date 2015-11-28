import java.util.ArrayList;

/**
 * The purpose of this class is to store all of the data of an incident.
 * @author Ryan Stump
 *
 */
public class Incident {
	
	private int incidentNumber; // The number of the incident
	private int time; // The time the incident occurred
	private String date; // The date the incident occurred
	private String type; // The type of incident
	private Location location; // The location of the incident
	private ArrayList<Vehicle> assignedVehicles = new ArrayList<>(); // The vehicles assigned to be deployed to the incident
	private String urgency; // The urgency of the incident
	
	
	public Incident(int incidentNumber, int time, String date, String type, Location location,
			ArrayList<Vehicle> assignedVehicles, String urgency){
		this.incidentNumber = incidentNumber;
		this.time = time;
		this.date = date;
		this.type = type;
		this.location = location;
		this.assignedVehicles = assignedVehicles;
		this.urgency = urgency;
		
	}
	/**
	 * Returns the number of the incident.
	 * @return The number of the incident
	 */
	public int getNumber(){
		return incidentNumber;
	}
	
	/**
	 * Sets the incident to the incident number
	 * @param number The number of the incident
	 */
	public void setNumber(int number){
		incidentNumber = number;
		
	}
	
	/**
	 * Returns the time that the incident was submitted by the user
	 * @return The time the incident was submitted
	 */
	public int getTime(){
		return time;
	}
	
	/**
	 * Sets the time that the incident was submitted by the user
	 * @param newTime The time submitted by the user.
	 */
	public void setTime(int newTime){
		time = newTime;
	}

	/**
	 * Returns the date that the incident was submitted by the user
	 * @return
	 */
	public String getDate(){
		return date;
	}
	
	/**
	 * Sets the date that the incident was submitted by the user
	 * @param newDate The date the incident was submitted
	 */
	public void setDate(String newDate){
		date = newDate;
	}
	
	/**
	 * Returns the type of incident
	 * @return The type of incident
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * Sets the type of incident
	 * @param newType The type of incident
	 */
	public void setType(String newType){
		type = newType;
	}
	
	/**
	 * Returns the location where the incident occurred
	 * @return The location of the incident
	 */
	public Location getLocation(){
		return location;
	}
	
	/**
	 * Sets the location where the incident occurred
	 * @param newLocation The location of the incident
	 */
	public void setLocation(Location newLocation){
		location = newLocation;
	}
	
	/**
	 * Returns a list of vehicles that are sent to respond to the incident
	 * @return A list of vehicles that are assigned to the incident
	 */
	public ArrayList<Vehicle> getVehicles (){
		return assignedVehicles;
	}
	
	/**
	 * Sets a list of vehicles that are sent to respond to the incident
	 * @param newVehicles A list of vehicles that are assigned to the incident
	 */
	public void setVehicles(ArrayList<Vehicle> newVehicles){
		assignedVehicles = newVehicles;
	}
	
	/**
	 * Returns the urgency level of the incident
	 * @return The urgency level of the incident
	 */
	public String getUrgency(){
		return urgency;
	}
	
	/**
	 * Sets the urgency level of the incident. Either low, medium, or high.
	 * @param newUrgency The urgency level of the incident
	 */
	public void setUrgency(String newUrgency){
		urgency = newUrgency;
	}
	
	public String vehiclesToString(){
		String result = "";
		ArrayList<Vehicle> vehicles = getVehicles();
		for(int i=0;i<vehicles.size();i++){
			result += vehicles.get(i).getName() + " ";
		}
		return result;
	}
	
}
