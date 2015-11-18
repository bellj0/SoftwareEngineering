
/**
 * The purpose of this class is to accurately determine the distance from a particular 
 * vehicle to a particular incident.
 * 
 * @author Ryan Stump
 *
 */
public class TravelingCalculations {
	private Vehicle vehicle;
	private Location location;
	
	public TravelingCalculations(Vehicle vehicle, Location location){
		this.vehicle = vehicle;
		this.location = location;
	}
	
	/**
	 * Calculates the distance form the vehicle to the incident
	 * @return
	 */
	public int calculateDistance(){
		int distance = calculateDistanceX() + calculateDistanceY();
		
		return distance;
	}
	
	/**
	 * Converts the distance it takes to the time it takes.
	 * 
	 * THIS WILL MOST LIKELY BE CHANGED
	 * 
	 * As of now, I'm doing every 100 pixels is one second
	 * @return
	 */
	public int convertDistanceToTime(){
		int distance = calculateDistance();
		int time = 100 * distance;
		
		return time;
	}
	
	/**
	 * Calculates the distance from the vehicle to the incident in the x direction
	 * 
	 * @return The distance from the vehicles current location to the location.
	 */
	private int calculateDistanceX(){
		Location currentLocation = vehicle.getLocation();
		 
		int currentX = currentLocation.getPos_x();
		int newX = location.getPos_x();
		int distance = Math.abs(newX - currentX);
		
		return distance;
	}
	
	/**
	 * Calculates the distance from the vehicle to the incident in the y direction 
     *
	 * @return The distance from the vehicles current location to the location.
	 */
	private int calculateDistanceY(){
		Location currentLocation = vehicle.getLocation();
		
		int currentY = currentLocation.getPos_y();
		int newY = location.getPos_y();
		int distance = Math.abs(newY - currentY);
		
		return distance;
		
	}
}
