import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Stephanie
 * Tests the methods in the Vehicle class
 *
 */
public class TestVehicle 
{
	private Location loc1;
	private Location loc2;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	
	@Before
	public void setUp() throws Exception 
	{
		this.loc1 = Location.BOOKSTORE;
		this.loc2 = Location.EDGEWOOD;
		this.vehicle1 = new Vehicle(VehicleType.STANDARD_CRUISER, loc1);
		this.vehicle2 = new Vehicle(VehicleType.K9, loc2);
	}

	@After
	public void tearDown() throws Exception 
	{
		loc1 = null;
		loc2 = null;
		vehicle1 = null;
		vehicle2 = null;
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testVehicle() 
	{
		Location loc3 = Location.CHESTNUT;
		Vehicle vehicle3 = new Vehicle(VehicleType.STANDARD_CRUISER, loc3);
		assertEquals(VehicleType.STANDARD_CRUISER, vehicle3.getVehicleType());
	}

	@Test
	public void testSetVehicleType() 
	{
		vehicle1.setVehicleType(VehicleType.SUV);
		assertEquals(VehicleType.SUV, vehicle1.getVehicleType());
	}
	
	@Test
	public void testSetVehicleTypeEmptyString() 
	{
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Vehicle type cannot be an empty string.");
		vehicle1.setVehicleType(null);		
	}
	
	@Test
	public void testSetVehicleNullInput() 
	{
		exception.expect(NullPointerException.class);
		vehicle1.setVehicleType(null);
	}

	@Test
	public void testGetVehicleType() 
	{
		assertEquals(VehicleType.K9, vehicle2.getVehicleType());
	}

	@Test
	public void testSetLocation() 
	{
		vehicle2.setLocation(loc1);
		assertEquals(1, loc1.getPos_x());
		assertEquals(5, loc1.getPos_y());
	}

	@Test
	public void testGetLocation() 
	{
		Location tempLoc1 = vehicle1.getLocation();
		Location tempLoc2 = vehicle2.getLocation();
		
		assertEquals(1, tempLoc1.getPos_x());
		assertEquals(5, tempLoc1.getPos_y());
		
		assertEquals(3, tempLoc2.getPos_x());
		assertEquals(4, tempLoc2.getPos_y());
		
	}

	@Test
	public void testSetAvailability() 
	{
		vehicle1.setAvailability(true);
		vehicle2.setAvailability(false);
		
		assertEquals(true, vehicle1.isAvailable());
		assertEquals(false, vehicle2.isAvailable());
		
	}

	@Test
	public void testIsAvailable() 
	{
		vehicle2.setAvailability(true);
		
		assertEquals(false, vehicle1.isAvailable());
		assertEquals(true, vehicle2.isAvailable());
	}

}
