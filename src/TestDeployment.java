import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Tests the methods in the Deployment class
 * @author Brian
 *
 */

public class TestDeployment {
	Incident incident, incident2;
	ArrayList<Vehicle> vehicles;
	Deployment deployment;
	Vehicle v1, v2;
	
	@Before
	public void setUp() throws Exception {
		vehicles = new ArrayList<Vehicle>();
		Vehicle v1 = new Vehicle(VehicleType.AMBULANCE, Location.BOLE);
		Vehicle v2 = new Vehicle(VehicleType.SUV, Location.BOOKSTORE);
		vehicles.add(v1);
		vehicles.add(v2);
		
		incident = new Incident(3, 1200, "Test Date", IncidentType.STABBING, Location.LIBRARY, vehicles, UrgencyLevel.HIGH);
	}

	@After
	public void tearDown() throws Exception {
		vehicles = null;
		v1 = null;
		v2 = null;
		incident = null;
		incident2 = null;
		deployment = null;
	}
	
	@Test
	public void getSetIncidentTest() {
		// The deployment constructor calls the setIncident(Incident incident) method to set the incident
		deployment = new Deployment(incident);
		
		incident2 = deployment.getIncident();
		
		assertEquals(incident, incident2);
	}

	@Test
	public void deployTest() {
		deployment = new Deployment(incident);
		
		deployment.deploy();
		
		boolean availCheck = false;
		
		// Loops through the vehicles ArrayList, if the vehicle is available availCheck is set to false and the loop terminates
		for (Vehicle vehicle : vehicles)
		{
			if (vehicle.isAvailable())
			{	
				availCheck = false;
				break;
			}
			else
				availCheck = true;
		}
		
		assert(availCheck);
	}

}
