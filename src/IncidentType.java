import java.util.*;

/**
 * Created to hold all of the types of incidents, sorted by their urgency level.
 * 
 * @author Josh Bell
 *
 */
public enum IncidentType {

	THEFT(UrgencyLevel.LOW), 
	VANDALISM(UrgencyLevel.LOW), 
	DISTURBING_THE_PEACE(UrgencyLevel.LOW), 
	DOG_ATTACK(UrgencyLevel.LOW),
	DRUGS(UrgencyLevel.LOW),
	PARTY(UrgencyLevel.LOW),

	DOMESTIC_ABUSE(UrgencyLevel.MEDIUM), 
	TRAFFIC_ACCIDENT(UrgencyLevel.MEDIUM), 
	STABBING(UrgencyLevel.MEDIUM), 
	DROWNING(UrgencyLevel.MEDIUM),

	FIRE(UrgencyLevel.HIGH), 
	BOMB_THREAT(UrgencyLevel.HIGH), 
	HOSTAGE_SITUATION(UrgencyLevel.HIGH), 
	SUICIDE_ATTEMPT(UrgencyLevel.HIGH), 
	SHOOTING(UrgencyLevel.HIGH), 
	RIOT(UrgencyLevel.HIGH);

	private UrgencyLevel level;

	IncidentType(UrgencyLevel level) 
	{
		this.level = level;
	}

	/**
	 * Returns an ArrayList of all of the Low urgency incident types.
	 * 
	 * @return ArrayList of all Low urgency incident types
	 */
	public static ArrayList<IncidentType> getLowIncidents() 
	{
		ArrayList<IncidentType> low = new ArrayList<>();

		for (IncidentType eachType : IncidentType.values()) 
		{
			if (eachType.level.equals(UrgencyLevel.LOW))
				low.add(eachType);
		}
		return low;
	}

	/**
	 * Returns an ArrayList of all of the Medium urgency incident types.
	 * 
	 * @return ArrayLis of all Medium urgency inicdent types
	 */
	public static ArrayList<IncidentType> getMediumIncidents() 
	{
		ArrayList<IncidentType> medium = new ArrayList<>();

		for (IncidentType eachType : IncidentType.values()) 
		{
			if (eachType.level.equals(UrgencyLevel.MEDIUM))
				medium.add(eachType);
		}
		return medium;
	}

	/**
	 * Returns an ArrayList of all of the High urgency incident types.
	 * 
	 * @return ArrayLis of all High urgency inicdent types
	 */
	public static ArrayList<IncidentType> getHighIncidents() 
	{
		ArrayList<IncidentType> high = new ArrayList<>();

		for (IncidentType eachType : IncidentType.values()) 
		{
			if (eachType.level.equals(UrgencyLevel.HIGH))
				high.add(eachType);

		}
		return high;
	}

	/**
	 * Returns an ArrayList of all incident types.
	 * 
	 * @return ArrayList of all  urgency incident types
	 */
	public ArrayList<IncidentType> getAllIncident() 
	{

		ArrayList<IncidentType> allIncidents = new ArrayList<>();

		for (IncidentType eachType : IncidentType.values()) 
		{
			allIncidents.add(eachType);
		}
		return allIncidents;
	}

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
