public class VehicleSelectionAnalysis 
{
	Vehicle selectedVehicle;
	


	public VehicleSelectionAnalysis()
	{
	
	}
	
	public Vehicle getClosestVehicle(Location location)
	{
		Vehicle closest = null;
			for (Vehicle v: closest.getAvailableVehicles())
			{
			  // need compare method to compare the location of the incident to the vehicle's location
			}
				
		return closest;
	}
	
	public void setSelectedVehicle(Vehicle vehicle)
	{
		selectedVehicle = vehicle;
	}
	
	public Vehicle getSelectedVehicle()
	{
		return selectedVehicle;
	}

}
