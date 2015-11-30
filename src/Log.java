import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Brian
 * The purpose of this module is to record all of the information regarding an incident into a text file.
 */
public class Log {
	private String fileName;
	private String logEntry;
	
	/**
	 * Creates a new log object that will write to the specified text file
	 * @param fileName of the text file to write to.  If a file with that name doesn't exist a file will automatically be created with that name
	 */
	public Log(String fileName)
	{
		setFileName(fileName);
	}
	
	/**
	 * Sets the file that the logger will write to
	 * @param fileName of the text file to write to.
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * Returns the logger's file name
	 * @return String of the logger's file name
	 */
	public String getFileName()
	{
		return this.fileName;
	}
	
	/**
	 * Returns the logEntry
	 * @return String of the logEntry to be written to a file
	 */
	public String getLogEntry()
	{
		return this.logEntry;
	}
	
	/**
	 * Sets the log entry and formats the information
	 * @param incident to retrieve the data to set the log entry
	 */
	public void setLogEntry(Incident incident)
	{
		int incidentNum = incident.getNumber();
		int time = incident.getTime();
		String date = incident.getDate();
		IncidentType type = incident.getType();
		Location location = incident.getLocation();
		ArrayList<Vehicle> assignedVehicles = new ArrayList<Vehicle>();
		assignedVehicles = incident.getVehicles();
		
		// Log Entry example: Incident: 01 | Date: November 19 2015 | Time: 800 | Type: Stabbing | Location: James Hall | Responding Vehicle(s) SC01, SC02
		this.logEntry = "Incident " + incidentNum + " | " + "Date: " + date + " | " + "Time: " + time + " | " + "Type: " + type + " | "
				+ "Location: " + location + "Responding Vehicle(s) " + getRespondingVehicles(assignedVehicles);
	}
	
	/**
	 * Creates a string that has a list of all of the vehicles that are responding to an incident
	 * @param assignedVehicles
	 * @return String containing all of the vehicles to an incident
	 */
	public String getRespondingVehicles(ArrayList<Vehicle> assignedVehicles)
	{
		String respondingVehicles = "";
		
		// Loops through the passed assignedVehicles ArrayList to generate the string
		for (Vehicle vehicle : assignedVehicles)
		{
			// Appends the vehicles's type and assigned number to the string
			respondingVehicles += (vehicle.getVehicleType().toString() + vehicle.getVehicleNumber() + " ");
		}
		
		return respondingVehicles;
	}
	
	/**
	 * Generates a log entry for an incident
	 * @param incident that contains the data that will be written to an existing log.
	 */
	public void generateLogEntry(Incident incident) throws IOException
	{
		// Sends the incident object to be formatted into a string
		setLogEntry(incident);
		
		try 
		{
			// Uses the logger's fileName variable to write to a specified log file.
			// If the file doesn't exist it will create a new file
			// If the file contains data the writer will append the new data
			// The file will be stored in the Logs folder in the project and will be a .txt file
			BufferedWriter writer = new BufferedWriter(new FileWriter("/Logs/" + fileName + ".txt", true));
			
			// Takes the formatted string that was generated from setLogEntry(incident) and prints it to the log
			writer.write(getLogEntry());
			
			// Creates a new line after it generates the log entry to make it easier to read.
			writer.newLine();
			
			// Closes the BufferedWriter
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
