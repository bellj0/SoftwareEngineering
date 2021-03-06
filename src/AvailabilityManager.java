
/**
 * This class is in charge of managing the length of time before a vehicle will become 
 * available after being deployed to another incident.

 * @author Ryan Stump
 *
 */
public class AvailabilityManager {
	private TravelingCalculations calculation;
	private Incident incident;
	private static Vehicle vehicle;
	private Location location;
	
	public AvailabilityManager(Incident incident, Vehicle vehicle,Location location){
		this.incident = incident;
		this.vehicle = vehicle;
		this.location = location;
	}
	
	/**
	 * Used for other classes to set a vehicle unavailable for the correct amount of time.
	 */
	public void manage(){
		calculation = new TravelingCalculations(vehicle,location);
		int time = calculateAvailabilityTime(incident) + calculation.convertDistanceToTime();
		
		setAvailabilityClock(time, vehicle);
	}
	
	
	
	/**
	 * Returns the time it will take before a vehicle can become available again after 
	 * responding to the incident. Determined by the urgency level of the incident.
	 * A low urgency will take 10 seconds, medium urgency will take 20 seconds,
	 * and a high urgency incident will take 30 seconds for the vehicle to become available.
	 * 
	 * @param incident The incident
	 * 
	 * @return  The time it will take for a vehicle to be available to respond to another
	 * incident if needed.
	 */
	public int calculateAvailabilityTime(Incident incident){
		UrgencyLevel urgency = incident.getUrgency();
		int threadTime = 0;
		
		if(urgency.equals(UrgencyLevel.LOW))
			threadTime = 10000; // 10 seconds
		else if(urgency.equals(UrgencyLevel.MEDIUM))
			threadTime = 20000; //20 seconds
		else
			threadTime = 30000; //30 seconds
		
		return threadTime;
	}
	
	/**
	 * A new thread is created and sleeps for the amount of time given.  After the time has passed, 
	 * it changes the vehicle from unavailable to available.
	 * @param time	   The time it will take for the vehicle to become available.
	 * @param vehicle  The vehicle
	 */
	public void setAvailabilityClock (int time, Vehicle vehicle){
		
		vehicle.setAvailability(false);
		new Threads(time).start();
	}

	static class Threads extends Thread{
		int time;
		
		public Threads(int time){
			this.time = time;
		}
		
		@Override
		public void run(){
			try{Thread.sleep(time);
			vehicle.setAvailability(true);}
			catch (Exception ignored) {}
			
		}
	}
}
