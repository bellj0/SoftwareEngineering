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
	public void testSetNumber() 
	{
		IncidentNumberingSystem system = new IncidentNumberingSystem();
		int firstNumber = system.incrementNumber();
		
		IncidentNumberingSystem system2 = new IncidentNumberingSystem();
		int secondNumber = system2.incrementNumber();
		
		assertEquals(firstNumber+1,secondNumber);
	}
}
