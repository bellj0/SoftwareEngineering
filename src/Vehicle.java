/**
 * This module represents the individual vehicles in the Rowan PD force.  
 */
import java.util.ArrayList;

public class Vehicle 
{
	private String vehicleType;
	private Location location;
	private boolean available;
	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>();
	private ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();

/**
 * Creates a new vehicle object and stores it in the list of all vehicles.
 * @param type The vehicle's type (cruiser, K9, etc).
 * @param location The current location of the vehicle.
 */
	public Vehicle(String type, Location location)
	{
		setVehicleType(type);
		setLocation(location);	
		allVehicles.add(this);
	}

/**
 * Sets the vehicle's type. 
 * @param type The type of the current vehicle.
 */
	public void setVehicleType(String type)
	{
		if (type.equals(null) || type.equals(""))
		{
			throw new NullPointerException("Vehicle type cannot be a null or empty string.");
			//to-do : redirect them to re-enter it / or choose car based on best information available
		}
		else
		{
			this.vehicleType = type;
		}
	}

/**
 * Returns the vehicle's type.
 * @return String that holds the vehicle's type.
 */
	public String getVehicleType()
	{
		return this.vehicleType;
	}

/**
 * Sets the vehicle's current location.
 * @param location The current location to be set.
 */
	public void setLocation(Location location)
	{
		this.location = location;
	}

/**
 * Returns the vehicle's current location. 
 * @return Location object representing the vehicle's current location.
 */
	public Location getLocation()
	{
		return this.location;
	}

/**
 * Returns the list of all vehicles that are available to respond to an incident. 
 * @return ArrayList containing all available vehicles.
 */
	public ArrayList<Vehicle> getAvailableVehicles()
	{
		for (Vehicle v: allVehicles)
		{
			if (v.isAvailable() == true)
			{
				availableVehicles.add(v);
			}
		}
		
		return availableVehicles;
	}

/**
 * Sets a vehicle's availability status to either true or false based on the value of the boolean parameter supplied.
 * @param available Boolean value representing whether the vehicle is available (true) or unavailable (false).
 */
	public void setAvailablity(boolean available)
	{
		this.available = available;
	}

/**
 * Returns a vehicle's availability status. 
 * @return The availability status of the vehicle, where true is available and false is unavailable. 
 */
	public boolean isAvailable()
	{
		return this.available;
	}
	
}
