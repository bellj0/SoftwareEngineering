import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestTravelingCalculations
{
	private Location currentLocation = Location.LIBRARY;
	private Location newLocation = Location.ROBINSON;
	private Vehicle vehicle = new Vehicle(VehicleType.STANDARD_CRUISER,currentLocation);
	private TravelingCalculations calculation = new TravelingCalculations(vehicle,newLocation);
	
	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
	
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testCalculateDistance() 
	{
		assertEquals(120,calculation.calculateDistance());
	}
	
	@Test
	public void testConvertDistanceToTime() 
	{
		assertEquals(12000,calculation.convertDistanceToTime());
	}
}
