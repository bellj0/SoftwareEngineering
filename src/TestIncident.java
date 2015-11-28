import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


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
		vehicle1 = new Vehicle("Cruiser",location);
		vehicle2 = new Vehicle("Fire Truck", location);
		assignedVehicles.add(vehicle1);
		assignedVehicles.add(vehicle2);
		incident = new Incident(1,900,"December 4th, 2015","Stabbing",location,assignedVehicles,"High");
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
	public void testSetTime() 
	{
		incident.setTime(1000);
		assertEquals(1000,incident.getTime());
		incident.setTime(900);
	}

	@Test
	public void testGetDate() 
	{
		assertEquals("December 4th, 2015", incident.getDate());
	}

	@Test
	public void testSetDate() 
	{
		incident.setDate("December 5th, 2015");
		assertEquals("December 5th, 2015",incident.getDate());
		incident.setDate("December 4th, 2015");
	}

	@Test
	public void testGetType() 
	{
		assertEquals("Stabbing",incident.getType());
	}

	@Test
	public void testSetType() 
	{
		incident.setType("Fire");
		assertEquals("Fire", incident.getType());
		incident.setType("Stabbing");
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
		assertEquals("Cruiser7 Fire Truck8 ", incident.vehiclesToString());
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
		
		assertEquals("High", incident.getUrgency());
	}
	
	@Test
	public void testSetUrgency() 
	{
		incident.setUrgency("Medium");
		assertEquals("Medium", incident.getUrgency());
		incident.setUrgency("High");
	}

}
