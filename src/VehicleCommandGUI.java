import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class VehicleCommandGUI extends JFrame {
	
	private ImageIcon rowanMap;
	private JLabel mapLabel;
	
	private ImageIcon closestVehicle;
	private ImageIcon incLocation;

	private JPanel contentPane;
	private JCheckBox vehicleType_1;
	private JCheckBox vehicleType_2;
	private JCheckBox vehicleType_3;
	private JCheckBox vehicleType_4;
	private JCheckBox vehicleType_5;
	private JCheckBox vehicleType_6;
	private JCheckBox vehicleType_7;
	private JCheckBox vehicleType_8;

	private JButton btnReportIncident;
	private JButton btnReset;
	private JButton btnPrintLog;

	private JPanel incidentSelection;
	private JPanel locationSelection;
	private JLabel lblIncidentUrgencySelection;
	private JLabel lblLocationSelection;
	private JList listOfLocations;
	private JList listOfIncidentLevels;
	private Component verticalStrut;
	private JComboBox<IncidentType> incidentSelectionComboBox;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private JLabel lblNewLabel;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleCommandGUI frame = new VehicleCommandGUI();
					frame.setVisible(true);
					frame.pack();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 950, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5,5));
	
		
		rowanMap = new ImageIcon(getClass().getResource("rowanMap.jpg"));
		closestVehicle = new ImageIcon(getClass().getResource("closest.jpg"));
		incLocation = new ImageIcon(getClass().getResource("location.jpg"));
		
		mapLabel = new JLabel(rowanMap);
		
		contentPane.add(mapLabel, BorderLayout.NORTH);
		
		JPanel userInput = new JPanel();
		FlowLayout fl_userInput = new FlowLayout();
		fl_userInput.setVgap(10);
		fl_userInput.setHgap(75);
		userInput.setLayout(fl_userInput);
		
		
		JPanel recVehicle = new JPanel();
		recVehicle.setLayout(new BorderLayout(0, 10));
		recVehicle.setToolTipText("Recommended Vehicles");
		recVehicle.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		
		JLabel recVehiclesLabel = new JLabel("Recommended Vehicle Types");
		recVehiclesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel recVehicleBoxes = new JPanel();
		recVehicleBoxes.setLayout(new GridLayout(0, 2, 10, 0));
		
		vehicleType_1 = new JCheckBox("vehicleType_1");
		vehicleType_2 = new JCheckBox("vehicleType_2");
		vehicleType_3 = new JCheckBox("vehicleType_3");
		vehicleType_4 = new JCheckBox("vehicleType_4");
		vehicleType_5 = new JCheckBox("vehicleType_5");
		vehicleType_6 = new JCheckBox("vehicleType_6");
		vehicleType_7 = new JCheckBox("vehicleType_7");
		vehicleType_8 = new JCheckBox("vehicleType_8");
		
		recVehicleBoxes.add(vehicleType_1);
		recVehicleBoxes.add(vehicleType_2);
		recVehicleBoxes.add(vehicleType_3);
		recVehicleBoxes.add(vehicleType_4);
		recVehicleBoxes.add(vehicleType_5);
		recVehicleBoxes.add(vehicleType_6);
		recVehicleBoxes.add(vehicleType_7);
		recVehicleBoxes.add(vehicleType_8);
		
		
		recVehicle.add(recVehiclesLabel, BorderLayout.NORTH);
		recVehicle.add(recVehicleBoxes);
		
		userInput.add(recVehicle);
		
		JPanel buttonsPanel = new JPanel();
		FlowLayout fl_buttonsPanel = new FlowLayout();
		fl_buttonsPanel.setHgap(50);
		buttonsPanel.setLayout(fl_buttonsPanel);

		
		btnReportIncident = new JButton("Report Inicident");
		btnReportIncident.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		btnPrintLog = new JButton("Print Log");
		btnPrintLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});	
		
		
		btnReset = new JButton("Reset Form");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				contentPane.remove(mapLabel);
				
				rowanMap = new ImageIcon(getClass().getResource("rowanMap.jpg"));
				mapLabel = new JLabel(rowanMap);
				
				contentPane.add(mapLabel, BorderLayout.NORTH);
				
				// Reset/unselect all of the recommended vehicles
				vehicleType_1.setSelected(false);
				vehicleType_2.setSelected(false);
				vehicleType_3.setSelected(false);
				vehicleType_4.setSelected(false);
				vehicleType_5.setSelected(false);
				vehicleType_6.setSelected(false);
				vehicleType_7.setSelected(false);
				vehicleType_8.setSelected(false);
				
				// Resets the selection of a location
				listOfLocations.clearSelection();
				listOfLocations.ensureIndexIsVisible(0);
				
				listOfIncidentLevels.clearSelection();
				
				incidentSelectionComboBox.removeAllItems();
				incidentSelectionComboBox.setEnabled(false);
				
			}
		});
		

	
		
		buttonsPanel.add(btnReportIncident);
		buttonsPanel.add(btnPrintLog);
		buttonsPanel.add(btnReset);
		
		
	
		contentPane.add(userInput, BorderLayout.CENTER);
		
		incidentSelection = new JPanel();
		incidentSelection.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userInput.add(incidentSelection);
		incidentSelection.setLayout(new BoxLayout(incidentSelection, BoxLayout.Y_AXIS));
		
		verticalStrut_4 = Box.createVerticalStrut(3);
		incidentSelection.add(verticalStrut_4);
		
		lblIncidentUrgencySelection = new JLabel("Incident Urgency Level");
		lblIncidentUrgencySelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIncidentUrgencySelection.setHorizontalAlignment(SwingConstants.CENTER);
		incidentSelection.add(lblIncidentUrgencySelection);
		
		
		listOfIncidentLevels = new JList(UrgencyLevel.values());
		listOfIncidentLevels.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				incidentSelectionComboBox.removeAllItems();
				incidentSelectionComboBox.setEnabled(true);
				
				switch(listOfIncidentLevels.getSelectedValue().toString())
				{
				case "LOW":
				{
					for(IncidentType type : IncidentType.getLowIncidents())
					{
						incidentSelectionComboBox.addItem(type);
					}
					break;
				}
				case "MEDIUM":
				{
					for(IncidentType type : IncidentType.getMediumIncidents())
					{
						incidentSelectionComboBox.addItem(type);
					}
					break;
				}
				case "HIGH":
				{
					for(IncidentType type : IncidentType.getHighIncidents())
					{
						incidentSelectionComboBox.addItem(type);
					}
					break;
				}
				default:
					incidentSelectionComboBox.setEnabled(false);
					break;
				}
				
			}
		});
		
		verticalStrut_1 = Box.createVerticalStrut(8);
		incidentSelection.add(verticalStrut_1);
		listOfIncidentLevels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfIncidentLevels.setVisibleRowCount(3);
		JScrollPane urgencyScoll = new JScrollPane(listOfIncidentLevels);
		incidentSelection.add(urgencyScoll);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setForeground(Color.GRAY);
		incidentSelection.add(verticalStrut_2);
		
		lblNewLabel = new JLabel("Incident Selection");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incidentSelection.add(lblNewLabel);
		
		verticalStrut_3 = Box.createVerticalStrut(8);
		incidentSelection.add(verticalStrut_3);
		
		incidentSelectionComboBox = new JComboBox<IncidentType>();
		incidentSelectionComboBox.setEnabled(false);
		incidentSelection.add(incidentSelectionComboBox);
		
		
		
		
		locationSelection = new JPanel();
		locationSelection.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userInput.add(locationSelection);
		locationSelection.setLayout(new BorderLayout(5, 10));
		
		
		
		lblLocationSelection = new JLabel("Location Selection");
		lblLocationSelection.setHorizontalAlignment(SwingConstants.CENTER);
				
		locationSelection.add(lblLocationSelection, BorderLayout.NORTH);
		
		listOfLocations = new JList(Location.values());
		
		// Will be used to repaint the map with the location indicated (if I can figure out how)
		listOfLocations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Location incidentLocation;
				incidentLocation = (Location)listOfLocations.getSelectedValue();
				
				
			}
		});
		
		listOfLocations.setVisibleRowCount(7);
		listOfLocations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane locationScroll = new JScrollPane(listOfLocations);
		
		locationSelection.add(locationScroll, BorderLayout.CENTER);
		
		
		contentPane.add(buttonsPanel, BorderLayout.SOUTH);
		
	}
	
}
