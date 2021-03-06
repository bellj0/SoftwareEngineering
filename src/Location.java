/**
 * This enum holds the x/y position of a location in reference to the
 * map located in the gui. These positions are vital to calculating the
 * distance between an incident and a vehicle.
 *  @author Joshua Bell
 */
public enum Location 
{
	LIBRARY(370,232), 		REC_CENTER(329,153), 
	ESBY_GYM(300,161), 		JAMES(246,161), 
	ROBINSON(270,212), 		WILSON(200,223), 
	ROWAN(141,216),			WESTBY(256,280), 
	SCIENCE(292,261), 		HAWTHORN(315,317), 
	BOZORTH(331,358), 		BUNCE(400,366), 
	MEMORIAL(412,309), 		ENTERPRISE(699,178),
	LAUREL(444,317), 		OAK(476,303), 
	EVERGREEN(524,237), 	MULLICA(560,209), 
	MIMOSA(386,158), 		WILLOW(433,104), 
	CHESTNUT(506,48),		EDGEWOOD(414,69), 
	TRIAD(54,356), 			TOWNHOUSES(253,353), 
	WHITNEY(613,187), 		ROWAN_BLVD(694,209), 
	ROBO(707,114), 			SAVITZ(339,224),
	STUDENT_CENTER(423,208), WINANS(467,198), 
	BOLE(450,400), 			HOLLYBUSH(524,308), 
	LINDEN(447,287), 		MARRIOT(637,153),
	BOOKSTORE(735, 190);

	private int pos_x;   // position on map in x
	private int pos_y; // position on map in y

	/**
	 * Enum constructor that takes the x- and y- positions of the location
	 * as parameters.
	 * @param pos_x
	 * @param pos_y
	 */
	Location(int pos_x, int pos_y) 
    {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
	
    /**
     * Returns the x-position of the location.
     * @return
     */
    public int getPos_x() 
    {
		return pos_x;
	}
	
    /**
     * Returns the y-position of the location.
     * @return
     */
    public int getPos_y() 
    {
		return pos_y;
	}    
	
    /**
     * Used to change the x-position of a location.
     * @param pos_x
     */
    public void setPos_x(int pos_x) 
    {
		this.pos_x = pos_x;
	}

	/**
	 * Used to change the y-position of a location.
	 * @param pos_y
	 */
	public void setPos_y(int pos_y) 
	{
		this.pos_y = pos_y;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() 
	{
		String name = super.toString();
		String newName = "";
		
		if(name.contains("_"))
		{
			for (char c : name.toCharArray())
			{
				if(c == '_')
					newName += " ";
				else
					newName += c;
			}
			return newName;
		}
		return name;
	}
	
}
