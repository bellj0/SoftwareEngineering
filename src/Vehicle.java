/**
 * This module represents the individual vehicles in the Rowan PD force.  
 */

public class Vehicle 
{
	private String vehicleType;
	private Location location;
	private boolean available;

/**
 * Creates a new vehicle object and stores it in the list of all vehicles.
 * @param type The vehicle's type (cruiser, K9, etc).
 * @param location The current location of the vehicle.
 */
	public Vehicle(String type, Location location)
	{
		setVehicleType(type);
		setLocation(location);	
	}

/**
 * Sets the vehicle's type. 
 * @param type The type of the current vehicle.
 */
	public void setVehicleType(String type) throws IllegalArgumentException, NullPointerException
	{
		if (type.equals(""))
		{
			throw new IllegalArgumentException("Vehicle type cannot be an empty string.");
			//to-do : redirect them to re-enter it / or choose car based on best information available
		}
		else if (type.equals(null))
		{
			throw new NullPointerException("Vehicle type cannot be null.");
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
 * Sets a vehicle's availability status to either true or false based on the value of the boolean parameter supplied.
 * @param available Boolean value representing whether the vehicle is available (true) or unavailable (false).
 */
	public void setAvailability(boolean available)
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

/**
 * Overrides the equals method. The two vehicles are equal if their vehicle types and their locations are both equal. 
 * @param firstVehicle The first vehicle being compared. 
 * @param secondVehicle The second vehicle being compared.
 * @return True if they are equal, otherwise return false.
 */
	public boolean equals(Vehicle firstVehicle, Vehicle secondVehicle) {
		if (firstVehicle.getVehicleType().equals(secondVehicle.getVehicleType()) && firstVehicle.getLocation().equals(secondVehicle.getLocation()))
			return true;
		else
			return false;
	}
	
}
