/**
 * This module is to get the x/y position of a location in reference to the
 * map located in the gui. These positions are vital to calculating the
 * distance between an incident and a vehicle.
 *  @author Joshua Bell
 */

import java.util.ArrayList;

public class MapLocation 
{
	
	private ArrayList<Integer> position = new ArrayList<Integer>();
	
	/**
	 * Gets the position (x & y) of a given vehicle.
	 * @param vehicle
	 * @return position
	 */
	public ArrayList<Integer> getPosition(Vehicle vehicle) 
	{
		
		Location where = vehicle.getLocation();
		
		position.clear();
		position.add((Integer)where.getPos_x());
		position.add((Integer)where.getPos_y());
		
		return position;
	}

	
	/**
	 * Gets the position (x & y) of a given location.
	 * @param location
	 * @return position
	 */
	public ArrayList<Integer> getPosition(Location location) 
	{
		position.clear();
		
		position.add((Integer)location.getPos_x());
		position.add((Integer)location.getPos_y());
		return position;
	}


}
