import java.util.*;

/**
 * Created to hold all of the types of incidents, sorted by their urgency level.
 * 
 * @author Ryan Stump
 *
 */
public class IncidentTypes {
	
	private ArrayList<String> incidents = new ArrayList<>();
	
	public IncidentTypes(){
		incidents.add("Theft");
		incidents.add("Vandalism");
		incidents.add("Disturbing the Peace");
		incidents.add("Drugs");
		incidents.add("Dog Attack");
		incidents.add("Low");
		incidents.add("Domestic Abuse");
		incidents.add("Traffic Accident");
		incidents.add("Stabbing");
		incidents.add("Drowning");
		incidents.add("Medium");
		incidents.add("Fire");
		incidents.add("Bomb Threat");
		incidents.add("Hostage Situation");
		incidents.add("Suicide Attempt");
		incidents.add("Shooting");
		incidents.add("Riot");
		incidents.add("High");
	}
	
	/**
	 * Returns an ArrayList of all of the Low urgency incident types.
	 * @return ArrayLis of all Low urgency inicdent types
	 */
	public ArrayList<String> getLowIncidents(){
		ArrayList<String> low = new ArrayList<>();
		boolean finished = false;
		String incident;
		
		for(int i=0;!finished;i++){
			incident = incidents.get(i); 
			if(!incident.equals("Low"))
				low.add(incident);
			else
				finished = true;
		}
		return low;
	}
	
	/**
	 * Returns an ArrayList of all of the Medium urgency incident types.
	 * @return ArrayLis of all Medium urgency inicdent types
	 */
	public ArrayList<String> getMediumIncidents(){
		ArrayList<String> medium = new ArrayList<>();
		boolean finishedLow = false;
		boolean finishedMedium = false;
		int i=0;
		String incident;
		
		for(;!finishedLow;i++){
			if(incidents.get(i) != "Low"){
				//do nothing
			}
			else
				finishedLow = true;
		}
		
		for(;!finishedMedium;i++){
			incident = incidents.get(i);
			if(!incident.equals("Medium")){
				medium.add(incident);
			}
			else
				finishedMedium = true;
		}
		return medium;
	}
	
	/**
	 * Returns an ArrayList of all of the High urgency incident types.
	 * @return ArrayLis of all High urgency inicdent types
	 */
	public ArrayList<String> getHighIncidents(){
		ArrayList<String> high = new ArrayList<>();
		boolean finishedLow = false;
		boolean finishedMedium = false;
		boolean finishedHigh = false;
		int i=0;
		String incident;
		
		for(;!finishedLow;i++){
			if(incidents.get(i) != "Low"){
				//do nothing
			}
			else
				finishedLow = true;
		}
		
		for(;!finishedMedium;i++){
			if(incidents.get(i) != "Medium"){
				//do nothing
			}
			else
				finishedMedium = true;
		}
		

		for(;!finishedHigh;i++){
			incident = incidents.get(i);
			if(!incident.equals("High")){
				high.add(incident);
			}
			else
				finishedHigh = true;
		}
		
		return high;
	}
	
	/**
	 * Returns an ArrayList of all incident types.
	 * @return ArrayLis of all urgency inicdent types
	 */
	public ArrayList<String> getAllIncident(){
		return incidents;
	}
}
