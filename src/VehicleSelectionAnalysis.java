/**
 * This module analyzes the location of the incident and the available vehicles of the needed type
 *  in order to determine the closest available vehicle to send to the incident. 
 *  @author Stephanie Douglass
 */
public class VehicleSelectionAnalysis 
{
	private Vehicle selectedVehicle;
	private VehicleData vehicleData = VehicleData.getInstance();
	

	

/**
 * Constructor that chooses and sets the selected vehicle based on the type of vehicle needed and the incident's location.
 * @param type The type of vehicle that is needed.
 * @param location The location of the incident. 
 */
	public VehicleSelectionAnalysis(VehicleType type, VehicleData vehicleData, Location location)
	{
		setSelectedVehicle(getClosestVehicle(type, vehicleData, location));
	}

	/**
	 * 
	 * @param vehicleData object where the list of available vehicles will be retrieved from. 
	 * @param location The location of the incident.
	 * @return Vehicle object representing the closest available vehicle to the specified location.
	 */
		public Vehicle getClosestVehicle(VehicleType type, VehicleData vehicleData, Location location)
		{
			Vehicle closest = null;
			int currentDistance;
			int smallestDistance = 0;
			
		for (Vehicle v : vehicleData.returnAvailable()) 
		{
			if (v.getVehicleType().equals(type)) 
			{
				TravelingCalculations travelCalc = new TravelingCalculations(v,
						location);
				currentDistance = travelCalc.calculateDistance();

				if (smallestDistance == 0) 
				{
					smallestDistance = currentDistance;
					closest = v;
				} 
				else if (currentDistance < smallestDistance) 
				{
					smallestDistance = currentDistance;
					closest = v;
				}
			}
		}
					
			return closest;
			
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
