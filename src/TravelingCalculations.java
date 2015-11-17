
/**
 * The purpose of this class is to accurately determine the distance from a particular 
 * vehicle to a particular incident.
 * 
 * @author Ryan Stump
 *
 */
public class TravelingCalculations {
	/**
	 * Calculates the distance from the vehicle to the incident in the x direction
	 * @param vehcile The vehicle
	 * @param location The location that the vehicle is traveling to
	 * @return The distance from the vehicles current location to the location.
	 */
	public int calculateDistanceX(Vehicle vehicle, Location location){
		Location currentLocation = vehicle.getLocation();
		 
		int currentX = currentLocation.getPos_x();
		int newX = location.getPos_x();
		int distance = Math.abs(newX - currentX);
		
		return distance;
	}
	
	/**
	 * Calculates the distance from the vehicle to the incident in the y direction 
	 * @param vehcile The vehicle
	 * @param location The location that the vehicle is traveling to
	 * @return The distance from the vehicles current location to the location.
	 */
	public int calculateDistanceY(Vehicle vehicle, Location location){
		Location currentLocation = vehicle.getLocation();
		
		int currentY = currentLocation.getPos_y();
		int newY = location.getPos_y();
		int distance = Math.abs(newY - currentY);
		
		return distance;
		
	}
}
