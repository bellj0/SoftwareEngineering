import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class VehicleCommandGUI extends JFrame {
	
	private ImageIcon rowanMap;
	private JLabel mapLabel;
	
	private ImageIcon closestVehicle;
	private ImageIcon incidentLocation;
	
	

	private JPanel contentPane;
	private JCheckBox vehicleType_1;
	private JCheckBox vehicleType_2;
	private JCheckBox vehicleType_3;
	private JCheckBox vehicleType_4;
	private JCheckBox vehicleType_5;
	private JCheckBox vehicleType_6;
	private JCheckBox vehicleType_7;
	private JCheckBox vehicleType_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleCommandGUI frame = new VehicleCommandGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VehicleCommandGUI() {
		setTitle("Vehicle Command and Control System");
		setResizable(false);
		
		rowanMap = new ImageIcon(getClass().getResource("rowanMap.jpg"));
		mapLabel = new JLabel(rowanMap);
		mapLabel.setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(mapLabel, BorderLayout.NORTH);
		
		JPanel userInput = new JPanel();
		userInput.setLayout(new FlowLayout());
		
		
		JPanel recVehicle = new JPanel();
		recVehicle.setToolTipText("Recommended Vehicles");
		recVehicle.setBorder(new LineBorder(Color.GRAY));
		
		vehicleType_1 = new JCheckBox("vehicleType_1");
		
		vehicleType_2 = new JCheckBox("vehicleType_2");
		
		vehicleType_3 = new JCheckBox("vehicleType_3");
		
		vehicleType_4 = new JCheckBox("vehicleType_4");
		
		vehicleType_5 = new JCheckBox("vehicleType_5");
		
		vehicleType_6 = new JCheckBox("vehicleType_6");
		
		vehicleType_7 = new JCheckBox("vehicleType_7");
		
		vehicleType_8 = new JCheckBox("vehicleType_8");

		userInput.add(recVehicle);
		recVehicle.setLayout(new GridLayout(0, 2, 0, 0));
		recVehicle.add(vehicleType_1);
		recVehicle.add(vehicleType_2);
		recVehicle.add(vehicleType_3);
		recVehicle.add(vehicleType_4);
		recVehicle.add(vehicleType_5);
		recVehicle.add(vehicleType_6);
		recVehicle.add(vehicleType_7);
		recVehicle.add(vehicleType_8);
		
		
		
		
		
		
		
		contentPane.add(userInput, BorderLayout.CENTER);
	}

}
