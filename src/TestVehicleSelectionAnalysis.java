import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestVehicleSelectionAnalysis 
{
	private Location loc1;
	private Location loc2;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private VehicleSelectionAnalysis vehicleSelect = new VehicleSelectionAnalysis(vehicle1.getVehicleType(), loc1);
	
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

	@Test
	public void testVehicleSelectionAnalysis() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetClosestVehicle() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetSelectedVehicle() 
	{
		vehicleSelect.setSelectedVehicle(vehicle1);
		assertEquals(vehicle1, vehicleSelect.getSelectedVehicle());
	}

	@Test
	public void testGetSelectedVehicle() 
	{
		fail("Not yet implemented");
	}

}
