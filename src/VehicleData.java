import java.util.ArrayList;

/**
 * This module creates 2 ArrayLists, one for currently available vehicles, and one for all vehicles in the force. 
 * @author Stephanie Douglass
 */
public class VehicleData 
{
	
	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>();
	private ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	
	public VehicleData() 
	{
	}
	
	/**
	 * Adds a vehicle to the ArrayList of all vehicles.
	 * @param vehicle The vehicle to be added to the list.
	 */
	public void addToAll(Vehicle vehicle)
	{
		allVehicles.add(vehicle);
	}
	
	/**
	 * Adds a vehicle to the ArrayList of available vehicles.
	 * @param vehicle The vehicle to be added to the list. 
	 */
	public void addtoAvailable(Vehicle vehicle)
	{
		availableVehicles.add(vehicle);
	}
	
	/**
	 * Clears and then updates the list of available vehicles.
	 */
	public void updateAvailable()
	{
		availableVehicles.clear();
		
		for (Vehicle v: allVehicles)
		{
			if (v.isAvailable())
			{
				availableVehicles.add(v);
			}
		}
	}
	
	/**
	 * Returns the current list of available vehicles.
	 * @return ArrayList of the available vehicles.
	 */
	public ArrayList<Vehicle> returnAvailable()
	{
		return availableVehicles;
	}
	
	/**
	 * Returns the current list of all vehicles.
	 * @return
	 */
	public ArrayList<Vehicle> returnAll()
	{
		return allVehicles;
	}

}
