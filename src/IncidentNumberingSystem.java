import java.io.File;
import java.io.FilenameFilter;

/**
 * The purpose of this class is to control the numbering process of the incidents. 
 * @author Ryan Stump
 *
 */
public class IncidentNumberingSystem {
	private Incident incident;
	
	public IncidentNumberingSystem(Incident incident){
		this.incident = incident;
	}
	
	/**
	 * Used by other classes to set the number of an incident.
	 */
	public void setNumber(){
		incrementAndAssign(incident);
	}
	
	/**
	 * Finds the most recent incident number and increments it by one
	 */
	private void incrementAndAssign(Incident incident){
		int number = 0;
		String path = "/Logs/";
		File[] files = finder(path);
		number = files.length;
		
		incident.setNumber((number+1));
	}
	
	/**
	 * Returns a list of all .txt files in the directory
	 * 
	 * @param dirName The directory being searched
	 * @return All of the text files in the directory
	 */
	private File[] finder(String dirName){
    	File dir = new File(dirName);

    	return dir.listFiles(new FilenameFilter() { 
    	         public boolean accept(File dir, String filename)
    	              { return filename.endsWith(".txt"); }
    	} );
    }
}
