import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Ryan
 * Tests the methods in the Incident class
 *
 */
public class TestIncident
{
	private Incident incident;
	private ArrayList<Vehicle> assignedVehicles;
	Vehicle vehicle1;
	Vehicle vehicle2;
	
	
	@Before
	public void setUp() throws Exception 
	{
		//location
		//assigned vehicles
		Location location = Location.LIBRARY;
		assignedVehicles = new ArrayList<>();
		vehicle1 = new Vehicle(VehicleType.STANDARD_CRUISER,location);
		vehicle2 = new Vehicle(VehicleType.FIRE_TRUCK, location);
		assignedVehicles.add(vehicle1);
		assignedVehicles.add(vehicle2);
		incident = new Incident(IncidentType.STABBING,location,assignedVehicles,UrgencyLevel.HIGH);
	}

	@After
	public void tearDown() throws Exception 
	{
		incident = null;
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testGetNumber() 
	{
		assertEquals(1, incident.getNumber());
	}

	@Test
	public void testSetNumber() 
	{
		incident.setNumber(2);
		assertEquals(2, incident.getNumber());
		incident.setNumber(1);
	}
	
	@Test
	public void testGetTime() 
	{
		assertEquals(900,incident.getTime());
	}
	

	@Test
	public void testGetType() 
	{
		assertEquals(IncidentType.STABBING,incident.getType());
	}

	@Test
	public void testSetType() 
	{
		incident.setType(IncidentType.FIRE);
		assertEquals(IncidentType.FIRE, incident.getType());
		incident.setType(IncidentType.STABBING);
	}

	@Test
	public void testGetLocation() 
	{
		assertEquals(Location.LIBRARY, incident.getLocation());
	}
	
	@Test
	public void testSetLocation() 
	{
		incident.setLocation(Location.ROBINSON);
		assertEquals(Location.ROBINSON, incident.getLocation());
		incident.setLocation(Location.LIBRARY);
	}
	
	@Test
	public void testGetVehicles() 
	{
		assertEquals("STANDARD CRUISER7 FIRE TRUCK8 ", incident.vehiclesToString());
	}
	
	@Test
	public void testSetVehicles() 
	{
		incident.setVehicles(null);
		assertEquals(null, incident.getVehicles());
		assignedVehicles.add(vehicle1);
		assignedVehicles.add(vehicle2);
	}
	
	@Test
	public void testGetUrgency() 
	{
		
		assertEquals(UrgencyLevel.HIGH, incident.getUrgency());
	}
	
	@Test
	public void testSetUrgency() 
	{
		incident.setUrgency(UrgencyLevel.MEDIUM);
		assertEquals(UrgencyLevel.MEDIUM, incident.getUrgency());
		incident.setUrgency(UrgencyLevel.HIGH);
	}

}
