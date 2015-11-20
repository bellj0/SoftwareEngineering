/**
 * This module analyzes the location of the incident and the available vehicles of the needed type
 *  in order to determine the closest available vehicle to send to the incident. 
 *  @author Stephanie Douglass
 */
public class VehicleSelectionAnalysis 
{
	Vehicle selectedVehicle;

/**
 * Constructor that chooses and sets the selected vehicle based on the type of vehicle needed and the incident's location.
 * @param type The type of vehicle that is needed.
 * @param location The location of the incident. 
 */
	public VehicleSelectionAnalysis(String type, Location location)
	{
		setSelectedVehicle(getClosestVehicle(type, location));
	}

/**
 * 
 * @param type The type of vehicle that is needed. 
 * @param location The location of the incident.
 * @return Vehicle object representing the closest available vehicle to the specified location.
 */
	public Vehicle getClosestVehicle(String type, Location location)
	{
/*		Vehicle closest = new Vehicle(type, location);
			for (Vehicle v: closest.getAvailableVehicles())
			{
					  
			}
				
		return closest;*/ 
		
		
		//adding this to fix compiler errors
		return null;
	}
	
/**
 * Sets the selected vehicle	
 * @param vehicle The vehicle to be selected. 
 */
	public void setSelectedVehicle(Vehicle vehicle)
	{
		selectedVehicle = vehicle;
	}

/**
 * Returns the selected vehicle. 
 * @return Vehicle object that has been selected by the module. 
 */
	public Vehicle getSelectedVehicle()
	{
		return selectedVehicle;
	}

}
