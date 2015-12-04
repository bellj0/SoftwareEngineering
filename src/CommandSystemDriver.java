import java.awt.EventQueue;

/**
 * This class contains the main method and instantiates the system with the necessary vehicle and incident information.
 * 
 *
 */

public class CommandSystemDriver 
{

	public static void main(String[] args) 
	
	// Create and display the application's GUI. 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					VehicleCommandGUI frame = new VehicleCommandGUI();
					frame.setVisible(true);
					frame.pack();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
		   }
		});

	}
	
	

}
