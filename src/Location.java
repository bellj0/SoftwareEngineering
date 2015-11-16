/**
 * Changed class to enum, just to temporarily fix the compiler errors
 * 
 *
 */


public class Location 
{
	/**
	 * 
	 * Putting this enum in a comment just to temporarily fix the compiler errors.

	LIBRARY( , ), 			REC_CENTER( , ), 
	ESBY_GYM( , ), 			JAMES( , ), 
	ROBINSON( , ), 			WILSON( , ), 
	ROWAN( , ),				WESTBY( , ), 
	SCIENCE( , ), 			HAWTHORN( , ), 
	BOZORTH( , ), 			BUNCE( , ), 
	MEMORIAL( , ), 			ENTERPRISE( , ),
	LAUREL( , ), 			OAK( , ), 
	EVERGREEN( , ), 		MULLICA( , ), 
	MIMOSA( , ), 			WILLOW( , ), 
	CHESNUT( , ),			EDGEWOOD( , ), 
	TRIAD( , ), 			TOWNHOUSES( , ), 
	WHITNEY( , ), 			ROWAN_BLVD( , ), 
	ROBO( , ), 				SAVITZ( , ),
	STUDENT_CENTER( , ), 	WINANS( , ), 
	BOLE( , ), 				HOLLYBUSH( , ), 
	LINDEN( , ), 			MARRIOT( , ),
	BOOKSTORE( , );
	
	*/
	
	private int pos_x;   // position on map in x
	private int pos_y; // position on map in y

	Location(int pos_x, int pos_y) 
    {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
	
    public int getPos_x() 
    {
		return pos_x;
	}
	
    public int getPos_y() 
    {
		return pos_y;
	}    
	
    public void setPos_x(int pos_x) 
    {
		this.pos_x = pos_x;
	}

	public void setPos_y(int pos_y) 
	{
		this.pos_y = pos_y;
	}
	
}
