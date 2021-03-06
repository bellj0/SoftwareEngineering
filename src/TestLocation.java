import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Brian
 * Tests the methods in the Location class
 *
 */

public class TestLocation {
	Location libraryLoc;

	@Before
	public void setUp() throws Exception {
		libraryLoc = Location.LIBRARY;
	}

	@After
	public void tearDown() throws Exception {
		libraryLoc = null;
	}

	@Test
	public void getSetPosXTest() {
		// Initial x position for the library is 370
		libraryLoc.setPos_x(150);
		
		// Checks if the setPos_x successfully set the x position to 150 and that the getPos_x returns the value
		assertEquals(150, libraryLoc.getPos_x());
	}
	
	@Test
	public void getSetPosYTest() {
		// Initial y position for the library is 232
		libraryLoc.setPos_y(200);
		
		// Checks if the setPos_y successfully set the y position to 200 and that the getPos_y returns the value
		assertEquals(200, libraryLoc.getPos_y());
	}
	
	@Test
	public void toStringTest() {
		// This is what the toString() method should output for the Library
		String correctString = "LIBRARY";
		
		// Checks if the correctString matches the string generated by the toString() method
		assertEquals(correctString, libraryLoc.toString());
	}

}
