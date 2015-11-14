import java.util.ArrayList;

public class Vehicle 
{
	private String vehicleType;
	private Location location;
	private boolean available;
	private ArrayList<Vehicle> availableVehicles = new ArrayList<Vehicle>();
	private ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();


	public Vehicle(String type, Location location)
	{
		setVehicleType(type);
		setLocation(location);	
		allVehicles.add(this);
	}

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
	
	public String getVehicleType()
	{
		return this.vehicleType;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public Location getLocation()
	{
		return this.location;
	}
	
	public ArrayList<Vehicle> getAvailableVehicles()
	{
		for (Vehicle v: allVehicles){
			if (v.isAvailable() == true)
			{
				availableVehicles.add(v);
			}
		}
		
		return availableVehicles;
	}
	
	public void setAvailable(boolean available){
		this.available = available;
	}
	
	public boolean isAvailable()
	{
		return this.available;
	}

}
