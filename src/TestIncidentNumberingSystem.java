import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Will be able to test once Brian puts in the path of the directory where the logs will be stored
 * @author Ryan Stump
 *
 */
public class TestIncidentNumberingSystem
{
	private Incident incident;
	private Vehicle vehicle;
	private ArrayList<Vehicle> assignedVehicles;
	private Location location = Location.LIBRARY;
	
	@Before
	public void setUp() throws Exception 
	{
		assignedVehicles = new ArrayList<>();
		vehicle = new Vehicle(VehicleType.STANDARD_CRUISER,location);
		assignedVehicles.add(vehicle);
		incident = new Incident(1,900,"December 4th, 2015",IncidentType.STABBING,location,assignedVehicles,UrgencyLevel.HIGH);
	}

	@After
	public void tearDown() throws Exception 
	{
		incident = null;
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testSetNumber() 
	{
		IncidentNumberingSystem system = new IncidentNumberingSystem(incident);
		system.setNumber();
		IncidentNumberingSystem system2 = new IncidentNumberingSystem(incident);
		int previousNumber = incident.getNumber();
		Incident incident2 = new Incident(1,900,"December 4th, 2015",IncidentType.STABBING,location,assignedVehicles,UrgencyLevel.HIGH);
		system2.setNumber();
		assertEquals(previousNumber+1,incident2.getNumber());
	}
}
