import java.util.ArrayList;

/**
 * The purpose of this class is to store all of the data of an incident.
 * @author Ryan Stump
 *
 */
public class Incident {
	
	private int incidentNumber; // The number of the incident
	private String time; // The time the incident occurred
	private String date; // The date the incident occurred
	private IncidentType type; // The type of incident
	private Location location; // The location of the incident
	private ArrayList<Vehicle> assignedVehicles = new ArrayList<>(); // The vehicles assigned to be deployed to the incident
	private UrgencyLevel urgency; // The urgency of the incident
	private IncidentNumberingSystem numbering = new IncidentNumberingSystem();
	
	
	public Incident(String time, String date, IncidentType type, Location location,
			ArrayList<Vehicle> assignedVehicles, UrgencyLevel urgency){
		this.time = time;
		this.date = date;
		this.type = type;
		this.location = location;
		this.assignedVehicles = assignedVehicles;
		this.urgency = urgency;
		
		setNumber(numbering.incrementNumber());
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
	public String getTime(){
		return time;
	}
	
	/**
	 * Sets the time that the incident was submitted by the user
	 * @param newTime The time submitted by the user.
	 */
	public void setTime(String newTime){
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
	public IncidentType getType(){
		return type;
	}
	
	/**
	 * Sets the type of incident
	 * @param newType The type of incident
	 */
	public void setType(IncidentType newType){
		this.type = newType;
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
	public UrgencyLevel getUrgency(){
		return urgency;
	}
	
	/**
	 * Sets the urgency level of the incident. Either low, medium, or high.
	 * @param newUrgency The urgency level of the incident
	 */
	public void setUrgency(UrgencyLevel newUrgency){
		this.urgency = newUrgency;
	}
	
	public String vehiclesToString(){
		String result = "";
		ArrayList<Vehicle> vehicles = getVehicles();
		for(int i=0;i<vehicles.size();i++){
			result += vehicles.get(i).getName() + " ";
		}
		return result;
	}

	
	public static ArrayList<VehicleType> typeOfVehicleNeeded(IncidentType incidentName)
	{
		ArrayList<VehicleType> vehicleTypes = new ArrayList<>();
		
		if(incidentName.equals(IncidentType.THEFT)||incidentName.equals(IncidentType.VANDALISM)||incidentName.equals(IncidentType.DISTURBING_THE_PEACE)
				|| incidentName.equals(IncidentType.DOMESTIC_ABUSE) || incidentName.equals(IncidentType.STABBING)
				|| incidentName.equals(IncidentType.DOG_ATTACK))
		{
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
		}
		else if(incidentName.equals(IncidentType.FIRE))
		{
			vehicleTypes.add(VehicleType.FIRE_TRUCK);
			vehicleTypes.add(VehicleType.AMBULANCE);
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
		}
		
		else if(incidentName.equals(IncidentType.BOMB_THREAT))
		{
			vehicleTypes.add(VehicleType.BOMB_SQUAD);
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
		}
		else if(incidentName.equals(IncidentType.HOSTAGE_SITUATION))
		{
		vehicleTypes.add(VehicleType.STANDARD_CRUISER);
		vehicleTypes.add(VehicleType.SUV);
		}
		else if (incidentName.equals(IncidentType.SUICIDE_ATTEMPT))
		{
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
			vehicleTypes.add(VehicleType.AMBULANCE);
			
		}
		else if (incidentName.equals(IncidentType.SHOOTING))
		{
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
			vehicleTypes.add(VehicleType.SWAT_TEAM);
		}
		else if (incidentName.equals(IncidentType.RIOT))
		{
			vehicleTypes.add(VehicleType.RIOT_TEAM);
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
			
		}
		else
		{
			vehicleTypes.add(VehicleType.STANDARD_CRUISER);
			vehicleTypes.add(VehicleType.K9);
		}
		
		return vehicleTypes;
	}
	
}
