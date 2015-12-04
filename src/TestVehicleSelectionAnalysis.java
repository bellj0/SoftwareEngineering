import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestVehicleSelectionAnalysis 
{
	private Location loc1;
	private Location loc2;
	private Location loc3;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private VehicleData vehicleData = VehicleData.getInstance();
	private VehicleSelectionAnalysis vehicleSelect;
	
	@Before
	public void setUp() throws Exception 
	{
		this.loc1 = Location.BOOKSTORE;
		this.loc2 = Location.EDGEWOOD;
		this.loc3 = Location.BUNCE;
		this.vehicle1 = new Vehicle(VehicleType.K9, loc1);
		this.vehicle2 = new Vehicle(VehicleType.K9, loc2);
		vehicleData.addToAll(vehicle1);
		vehicleData.addToAll(vehicle2);
		vehicleData.updateAvailable();
		vehicleSelect = new VehicleSelectionAnalysis(vehicle1.getVehicleType(), vehicleData, loc1);
	}

	@After
	public void tearDown() throws Exception 
	{
		loc1 = null;
		loc2 = null;
		vehicle1 = null;
		vehicle2 = null;
		vehicleData = null;
		vehicleSelect = null;
	}

	/**
	@Test
	public void testVehicleSelectionAnalysis() 
	{
		assert(true);
	}
	*/

	@Test
	public void testGetClosestVehicle() 
	{
		Vehicle testVehicle = vehicleSelect.getClosestVehicle(VehicleType.K9, vehicleData, loc3);
		assert(testVehicle.equals(vehicle1, testVehicle));
	}

	@Test
	public void testSetandGetSelectedVehicle() 
	{
		vehicleSelect.setSelectedVehicle(vehicle1);
		assertEquals(vehicle1, vehicleSelect.getSelectedVehicle());
	}


}
