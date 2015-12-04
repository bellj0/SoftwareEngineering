import java.util.ArrayList;
import java.util.Random;

/**
 * This module creates 2 ArrayLists, one for currently available vehicles, and one for all vehicles in the force. 
 * @author Stephanie Douglass
 */
public class VehicleData 
{
	
	private static ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>();
	private static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	private static VehicleData vehicleData = new VehicleData();
	
	private VehicleData() 
	{
		Random rn = new Random();
		int num;
		
		for(VehicleType type : VehicleType.values())
		{
			
			if(type.equals(VehicleType.STANDARD_CRUISER))
			{
				num = rn.nextInt(7) + 3;
				for(int i = 0;i < num; i++)
				{
					addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
				}
				
			}
			else if(type.equals(VehicleType.SUV))
			{
				num = rn.nextInt(3) + 2;
				for(int i = 0;i < num; i++)
				{
					addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
				}
			}
			else if(type.equals(VehicleType.AMBULANCE))
			{
				num = rn.nextInt(2) + 1;
				for(int i = 0;i < num; i++)
				{
					addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
				}
			}
			else if(type.equals(VehicleType.FIRE_TRUCK))
			{
				num = rn.nextInt(1) + 1;
				for(int i = 0;i < num; i++)
				{
					addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
				}
			}
			else if(type.equals(VehicleType.K9))
			{
				num = rn.nextInt(3) + 1;
				for(int i = 0;i < num; i++)
				{
					addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
				}
			}
			else
			{
				addToAll(new Vehicle(type,Location.values()[rn.nextInt(Location.values().length)]));
			}
			
		}
		for(Vehicle car : allVehicles)
		{
			car.setAvailability(true);
		}
			updateAvailable();
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
	
	public static VehicleData getInstance()
	{
		return vehicleData;
	}

}
