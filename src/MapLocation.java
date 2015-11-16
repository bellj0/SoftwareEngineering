import java.util.ArrayList;

public class MapLocation 
{
	
	private ArrayList<Integer> position = new ArrayList<Integer>();
	
	public ArrayList<Integer> getPosition(Vehicle vehicle) 
	{
		
		Location where = vehicle.getLocation();
		
		position.clear();
		position.add((Integer)where.getPos_x());
		position.add((Integer)where.getPos_y());
		
		return position;
	}

	// Don't think this will be used
	public void setPosition(Vehicle vehicle, ArrayList<Integer> position) 
	{
		this.position = position;
	}
	
	public ArrayList<Integer> getPosition(Location location) 
	{
		position.clear();
		
		position.add((Integer)location.getPos_x());
		position.add((Integer)location.getPos_y());
		return position;
	}

	// Don't think this will be used
	public void setPosition(Location location, ArrayList<Integer> position) 
	{
		this.position = position;
	}

}
