import java.util.ArrayList;

/**
 * The purpose of this class is to store all of the data of an incident.
 * @author Ryan Stump
 *
 */
public class Incident {
	
	private int incidentNumber; // The number of the incident
	private int time; // The time the incident occured
	private String date; // The date the incident occured
	private String type; // The type of incident
	private String location; // The location of the incident
	private ArrayList<Vehicle> assignedVehicles = new ArrayList<>(); // The vehicles assigned to be deployed to the incident
	private String urgency; // The urgency of the incident
	
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
	public String getLocation(){
		return location;
	}
	
	/**
	 * Sets the location where the incident occurred
	 * @param newLocation The location of the incident
	 */
	public void setLocation(String newLocation){
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
	 * @param newVehicles A list of vehicles that are assinged to the incident
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
	 * Sets the urgency level of the incident
	 * @param newUrgency The urgency level of the incident
	 */
	public void setUrgency(String newUrgency){
		urgency = newUrgency;
	}
	
}
