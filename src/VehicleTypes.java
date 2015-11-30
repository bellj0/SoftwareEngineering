import java.util.ArrayList;


public class VehicleTypes {

	private ArrayList<String> vehicles = new ArrayList<>();
	
	public ArrayList<String> typeOfVehicle(String incidentName){
		ArrayList<String> vehicleNames = new ArrayList<>();
		
		if(incidentName.equals("Theft")||incidentName.equals("Vandalism")||incidentName.equals("Disturbing the Peace")
				|| incidentName.equals("Drugs") || incidentName.equals("Domestic Abuse") || incidentName.equals("Stabbing")
				|| incidentName.equals("Dog Attack")){
			vehicleNames.add("Standard Cruiser");
		}
		else if(incidentName.equals("Fire")){
			vehicleNames.add("Fire Truck");
			vehicleNames.add("Ambulance");
		}
		
		else if(incidentName.equals("Bomb Threat")){
			vehicleNames.add("Bomb Squad");
			vehicleNames.add("Standard Cruiser");
		}
		else if(incidentName.equals("Hostage Situation")){
		vehicleNames.add("Standard Cruiser");
		vehicleNames.add("SUV");
		}
		else if (incidentName.equals("Suicide Attempt")){
			vehicleNames.add("Standard Cruiser");
			vehicleNames.add("Ambulance");
			
		}
		else if (incidentName.equals("Shooting")){
			vehicleNames.add("Standard Cruiser");
			vehicleNames.add("Swat");
		}
		else if (incidentName.equals("Riot")){
			vehicleNames.add("Riot");
			
		}
		else{}
		
		return vehicleNames;
		}
	
}
