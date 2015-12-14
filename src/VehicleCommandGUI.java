import java.awt.*;
import java.io.*;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class VehicleCommandGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox vehicleType;
	private JCheckBox resetType;
	private JCheckBox reccType;

	private JButton btnReportIncident;
	private JButton btnReset;
	private JButton btnPrintLog;

	private JPanel incidentSelection;
	private JPanel locationSelection;
	private JLabel lblIncidentUrgencySelection;
	private JLabel lblLocationSelection;
	private JList listOfLocations;
	private JList listOfIncidentLevels;
	private JComboBox<IncidentType> incidentSelectionComboBox;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private JLabel lblIncidentSelection;
	private Component verticalStrut_3;
	private Component verticalStrut_4;

	private ArrayList<VehicleType> recommendedVehicleTypes;
	private ArrayList<VehicleType> typeOfVehicleNeeded;
	private ArrayList<Vehicle> incVehicles;
	private BufferedImage mapDisplay;
	private BufferedImage locDisplay;
	private BufferedImage closestDisplay;
	private mapImage bs;
	
	private VehicleSelectionAnalysis carChooser;

	/**
	 * Create the frame.
	 */
	public VehicleCommandGUI() {
		VehicleData vehicleInfo = VehicleData.getInstance();
		vehicleInfo.updateAvailable();
		incVehicles = new ArrayList<>();
		typeOfVehicleNeeded = new ArrayList<>();
		recommendedVehicleTypes = new ArrayList<>();

		setTitle("Vehicle Command and Control System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 950, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		

		mapDisplay = null;
		try {
			mapDisplay = ImageIO.read( new File( "src//rowanMap.jpg" ) );
		} catch (IOException e) {
			e.printStackTrace();
		}

		bs = new mapImage( mapDisplay );
		getContentPane().add(bs, BorderLayout.NORTH);


		JPanel userInput = new JPanel();
		FlowLayout fl_userInput = new FlowLayout();
		fl_userInput.setVgap(10);
		fl_userInput.setHgap(75);
		userInput.setLayout(fl_userInput);

		JPanel recVehicle = new JPanel();
		recVehicle.setLayout(new BorderLayout(0, 10));
		recVehicle.setToolTipText("Additional Vehicles");
		recVehicle.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));

		JLabel recVehiclesLabel = new JLabel("Additional Vehicle Types");
		recVehiclesLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel recVehicleBoxes = new JPanel();
		recVehicleBoxes.setLayout(new GridLayout(0, 2, 10, 0));

		for (VehicleType type : VehicleType.values()) {
			vehicleType = new JCheckBox(type.toString());
			recVehicleBoxes.add(vehicleType);
		}

		recVehicle.add(recVehiclesLabel, BorderLayout.NORTH);
		recVehicle.add(recVehicleBoxes);

		userInput.add(recVehicle);

		JPanel buttonsPanel = new JPanel();
		FlowLayout fl_buttonsPanel = new FlowLayout();
		fl_buttonsPanel.setHgap(50);
		buttonsPanel.setLayout(fl_buttonsPanel);

		btnReportIncident = new JButton("Report Incident");
		btnReportIncident.addMouseListener(new MouseAdapter() {
			private AvailabilityManager manager;

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!(incidentSelectionComboBox.getSelectedItem() == null || listOfLocations
						.getSelectedValue() == null)) 
				{
					recommendedVehicleTypes.clear();
					incVehicles.clear();
					typeOfVehicleNeeded.clear();
					reccType = new JCheckBox();

					for (Component comp : recVehicleBoxes.getComponents()) {
						reccType = (JCheckBox) comp;
						if (reccType.isSelected()) {
							for (VehicleType compareType : VehicleType.values()) {
								if (compareType.toString().equals(
										reccType.getText())) {
									recommendedVehicleTypes.add(compareType);
								}
							}
						}
					}
					typeOfVehicleNeeded = Incident
							.typeOfVehicleNeeded((IncidentType) incidentSelectionComboBox
									.getSelectedItem());
					for (VehicleType recType : recommendedVehicleTypes) {
						if (!(typeOfVehicleNeeded.contains(recType))) {
							typeOfVehicleNeeded.add(recType);
						}
					}
					for(VehicleType car : typeOfVehicleNeeded)
					{
						VehicleSelectionAnalysis vehicleChooser = new VehicleSelectionAnalysis(car, (Location)listOfLocations.getSelectedValue());
						incVehicles.add(vehicleChooser.getSelectedVehicle());
					}


					//Creates the incident
					Incident incident = new Incident(
							(IncidentType)incidentSelectionComboBox.getSelectedItem(),
							(Location)listOfLocations.getSelectedValue(),
							incVehicles,
							(UrgencyLevel)listOfIncidentLevels.getSelectedValue());
					
					for (Vehicle car : incident.getVehicles())
					{
						manager = new AvailabilityManager(incident, car, incident.getLocation());
						manager.manage();
					}

					//Creates the log
					Log log = new Log("Log " + incident.getNumber());
					try{
					log.generateLogEntry(incident);
					}
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
					
					// message pops up to let the user know that the incident was successfully reported
					JOptionPane.showMessageDialog(null, incident.getType() + " at " + incident.getLocation().toString() 
							+ " was successfully reported.", "Success!!", JOptionPane.INFORMATION_MESSAGE);
					
					//resets the GUI buttons
					resetType = new JCheckBox();
					for (Component comp : recVehicleBoxes.getComponents()) {
						resetType = (JCheckBox) comp;
						resetType.setSelected(false);
					}

					// Resets the selection of a location
					listOfLocations.clearSelection();
					listOfLocations.ensureIndexIsVisible(0);

					listOfIncidentLevels.clearSelection();

					incidentSelectionComboBox.removeAllItems();
					incidentSelectionComboBox.setEnabled(false);

					recommendedVehicleTypes.clear();
					
					getContentPane().remove(bs);
					mapDisplay = null;
					try {
						mapDisplay = ImageIO.read( new File( "src//rowanMap.jpg" ) );
					} catch (IOException eRR) {
						eRR.printStackTrace();
					}

					bs = new mapImage( mapDisplay );
					getContentPane().add(bs, BorderLayout.NORTH);
				}
			}
		});

		/**
		 * Opens the folder where the logs are located on mouse click
		 */
		btnPrintLog = new JButton("Open Logs");
		btnPrintLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try{
				        Desktop.getDesktop().open(new File("src\\Logs"));
				    }catch(IOException e1){}
			}


		});


		btnReset = new JButton("Reset Form");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				getContentPane().remove(bs);

				mapDisplay = null;
				try {
					mapDisplay = ImageIO.read(new File("src//rowanMap.jpg"));
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}

				mapImage bs = new mapImage(mapDisplay);
				getContentPane().add(bs, BorderLayout.NORTH);

				resetType = new JCheckBox();
				for (Component comp : recVehicleBoxes.getComponents()) {
					resetType = (JCheckBox) comp;
					resetType.setSelected(false);
				}

				// Resets the selection of a location
				listOfLocations.clearSelection();
				listOfLocations.ensureIndexIsVisible(0);

				listOfIncidentLevels.clearSelection();

				incidentSelectionComboBox.removeAllItems();
				incidentSelectionComboBox.setEnabled(false);

				recommendedVehicleTypes.clear();
			}
		});

		buttonsPanel.add(btnReportIncident);
		buttonsPanel.add(btnPrintLog);
		buttonsPanel.add(btnReset);

		contentPane.add(userInput, BorderLayout.CENTER);

		incidentSelection = new JPanel();
		incidentSelection
		.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userInput.add(incidentSelection);
		incidentSelection.setLayout(new BoxLayout(incidentSelection,
				BoxLayout.Y_AXIS));

		verticalStrut_4 = Box.createVerticalStrut(3);
		incidentSelection.add(verticalStrut_4);

		lblIncidentUrgencySelection = new JLabel("Incident Urgency Level");
		lblIncidentUrgencySelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIncidentUrgencySelection
		.setHorizontalAlignment(SwingConstants.CENTER);
		incidentSelection.add(lblIncidentUrgencySelection);

		listOfIncidentLevels = new JList(UrgencyLevel.values());
		listOfIncidentLevels.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				incidentSelectionComboBox.removeAllItems();
				incidentSelectionComboBox.setEnabled(true);

				switch (listOfIncidentLevels.getSelectedValue().toString()) {
				case "LOW": {
					for (IncidentType type : IncidentType.getLowIncidents()) {
						incidentSelectionComboBox.addItem(type);
					}
					break;
				}
				case "MEDIUM": {
					for (IncidentType type : IncidentType.getMediumIncidents()) {
						incidentSelectionComboBox.addItem(type);
					}
					break;
				}
				case "HIGH": {
					for (IncidentType type : IncidentType.getHighIncidents()) {
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
		listOfIncidentLevels
		.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfIncidentLevels.setVisibleRowCount(3);
		JScrollPane urgencyScoll = new JScrollPane(listOfIncidentLevels);
		incidentSelection.add(urgencyScoll);

		verticalStrut_2 = Box.createVerticalStrut(20);
		incidentSelection.add(verticalStrut_2);

		lblIncidentSelection = new JLabel("Incident Selection");
		lblIncidentSelection.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIncidentSelection.setHorizontalAlignment(SwingConstants.CENTER);
		incidentSelection.add(lblIncidentSelection);

		verticalStrut_3 = Box.createVerticalStrut(8);
		incidentSelection.add(verticalStrut_3);

		incidentSelectionComboBox = new JComboBox<IncidentType>();
		incidentSelectionComboBox.setEnabled(false);
		incidentSelection.add(incidentSelectionComboBox);

		locationSelection = new JPanel();
		locationSelection
		.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		userInput.add(locationSelection);
		locationSelection.setLayout(new BorderLayout(5, 10));

		lblLocationSelection = new JLabel("Location Selection");
		lblLocationSelection.setHorizontalAlignment(SwingConstants.CENTER);

		locationSelection.add(lblLocationSelection, BorderLayout.NORTH);

		listOfLocations = new JList<Object>(Location.values());
		listOfLocations.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				Location incidentLocation;
				
				getContentPane().remove(bs);
				mapDisplay = null;
				locDisplay = null;
				closestDisplay = null;
				
				if(!listOfLocations.isSelectionEmpty())
				{
				incidentLocation = (Location) listOfLocations
						.getSelectedValue();
					try 
					{
						mapDisplay = ImageIO
							.read(new File("src//rowanMap.jpg"));
						locDisplay = ImageIO
								.read(new File("src//location.jpg"));
						
						closestDisplay = ImageIO
								.read(new File("src//closest.jpg"));

					} 
					catch (IOException er) 
					{
						er.printStackTrace();
					}
					bs = new mapImage(mapDisplay);
					getContentPane().add(bs, BorderLayout.NORTH);
					
					carChooser = new VehicleSelectionAnalysis(VehicleType.STANDARD_CRUISER,incidentLocation);
					bs.addLocImage(locDisplay, incidentLocation);
					bs.addLocImage(closestDisplay, carChooser.getClosestVehicle(VehicleType.STANDARD_CRUISER, incidentLocation).getLocation());
					
					
					
				}
				else
				{
					try 
					{
						mapDisplay = ImageIO
							.read(new File("src//rowanMap.jpg"));


					} 
					catch (IOException er) 
					{
						er.printStackTrace();
					}
					bs = new mapImage(mapDisplay);
					getContentPane().add(bs, BorderLayout.NORTH);
				}

				

				pack();
				repaint();
				
				
			}
		});
		
		// Will be used to repaint the map with the location indicated (if I can
		// figure out how)
		listOfLocations.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Location incidentLocation;
				incidentLocation = (Location) listOfLocations
						.getSelectedValue();
				
				getContentPane().remove(bs);
				mapDisplay = null;
				try 
				{
					mapDisplay = ImageIO
							.read(new File("src//rowanMap.jpg"));
					locDisplay = ImageIO
							.read(new File("src//location.jpg"));
					
					closestDisplay = ImageIO
							.read(new File("src//closest.jpg"));
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}

				bs = new mapImage(mapDisplay);
				getContentPane().add(bs, BorderLayout.NORTH);
				
				carChooser = new VehicleSelectionAnalysis(VehicleType.STANDARD_CRUISER,incidentLocation);
				bs.addLocImage(locDisplay, incidentLocation);
				bs.addLocImage(closestDisplay, carChooser.getClosestVehicle(VehicleType.STANDARD_CRUISER, incidentLocation).getLocation());
				

				pack();
				repaint();
			}
		});

		listOfLocations.setVisibleRowCount(7);
		listOfLocations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane locationScroll = new JScrollPane(listOfLocations);

		locationSelection.add(locationScroll, BorderLayout.CENTER);

		contentPane.add(buttonsPanel, BorderLayout.SOUTH);

	}
}

