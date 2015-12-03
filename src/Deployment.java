import java.util.ArrayList;

/**
 * 
 * @author Brian
 * The purpose of this module is to deploy vehicles to an incident
 */
public class Deployment {
	private Incident incident;
	
	// Deploys the specified vehicles to an incident
	public Deployment(Incident incident)
	{
		setIncident(incident);
	}
	
	/**
	 * Sets the incident
	 * @param incident to be set
	 */
	public void setIncident(Incident incident)
	{
		this.incident = incident;
	}
	
	/**
	 * Returns the incident
	 * @return incident
	 */
	public Incident getIncident()
	{
		return incident;
	}
	
	/**
	 * Deploys the incident
	 * @param incident
	 */
	public void deploy()
	{
		// Gathers the assigned vehicles to an incident
		ArrayList<Vehicle> assignedVehicles = new ArrayList<Vehicle>();
		assignedVehicles = incident.getVehicles();
				
		// Parses through the list of assigned vehicles and manages them with the AvailabilityManager
		// The vehicles are set to unavailable for a specified time based on their urgency level
		for (Vehicle vehicle : assignedVehicles)
		{
			AvailabilityManager availabilityManager = new AvailabilityManager(incident, vehicle, incident.getLocation());
			availabilityManager.manage();
		}
	}
}
