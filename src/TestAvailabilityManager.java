import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestAvailabilityManager
{
	private Incident incident;
	private Vehicle vehicle;
	private ArrayList<Vehicle> assignedVehicles;
	private Location location = Location.LIBRARY;
	private AvailabilityManager manager;
	
	@Before
	public void setUp() throws Exception 
	{
		assignedVehicles = new ArrayList<>();
		vehicle = new Vehicle(VehicleType.STANDARD_CRUISER,location);
		assignedVehicles.add(vehicle);
		incident = new Incident(900,"December 4th, 2015",IncidentType.STABBING,location,assignedVehicles,UrgencyLevel.HIGH);
		manager = new AvailabilityManager(incident,vehicle,location);
	}

	@After
	public void tearDown() throws Exception 
	{
		incident = null;
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testCalculateAvailabilityTime() 
	{
		System.out.println(manager.calculateAvailabilityTime(incident));
		assertEquals(30000,manager.calculateAvailabilityTime(incident));
	}
	
	
	@Test
	public void testSetAvailabilityClockBefore(){
		manager.setAvailabilityClock(3000,vehicle);
		assertEquals(false,vehicle.isAvailable());
	}
	
	@Test
	public void testSetAvailabilityClockAfter() throws InterruptedException{
		manager.setAvailabilityClock(3000,vehicle);
		Thread.sleep(4000);
		assertEquals(true,vehicle.isAvailable());
	}
}
