import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainerFrame extends JFrame {
	
	private JTextField codeField;
	private JTextField destinationField;
	private JTextField weightField;
	private JTextField powerField;
	private JButton createBulkButton;
	private JButton createRefrigeratorButton;
	private JList shipList;
	private JPanel containerPanel;
	private JPanel centralPanel;
	private ArrayList<Ship> ships;
	
	public ContainerFrame (ArrayList<Ship> someShips) {
		
		ships = someShips;
		
		codeField = new JTextField("Code");
		destinationField = new JTextField("Destination");
		weightField = new JTextField("Weight");
		powerField = new JTextField("Power");
		createBulkButton = new JButton("Create Bulk");
		createRefrigeratorButton = new JButton("Create Refrigerator");
		shipList = new JList();
		containerPanel = new JPanel();
		centralPanel = new JPanel();
		
		GridLayout grid = new GridLayout( 3, 2 );
		containerPanel.setLayout(grid);
		
		containerPanel.add(codeField);
		containerPanel.add(destinationField);
		containerPanel.add(weightField);
		containerPanel.add(powerField);
		containerPanel.add(createBulkButton);
		containerPanel.add(createRefrigeratorButton);
		
		BorderLayout border = new BorderLayout();
		centralPanel.setLayout(border);
		
		centralPanel.add(shipList, BorderLayout.NORTH);
		centralPanel.add(containerPanel, BorderLayout.CENTER);
		
		DefaultListModel model = new DefaultListModel();
		
		for(Ship ship : ships) {
			model.addElement(ship.getName());
		}
		
		shipList.setModel(model);
		
		this.setContentPane(centralPanel);
		
		ButtonListener listener = new ButtonListener();
		createBulkButton.addActionListener(listener);
		createRefrigeratorButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String code = codeField.getText();
			String destination = destinationField.getText();			
			String selectedShipName = shipList.getSelectedValue().toString();			
			Ship selectedShip = null;
			
			for(Ship ship : ships) {
				if(ship.getName().equals(selectedShipName)) 
					selectedShip = ship;
				}
				
				if(e.getSource() == createBulkButton) {
					String weightText = weightField.getText();
					int weight = Integer.parseInt(weightText);
					Bulk newContainer = new Bulk(code, destination, weight);
					selectedShip.addContainer(newContainer);					
				}
				else {
					String powerText = powerField.getText();
					double power = Double.parseDouble(powerText);
					Refrigerator newContainer = new Refrigerator(code, destination, power);
					selectedShip.addContainer(newContainer);
				}
				System.out.println("Selected Ship Charge " + selectedShip.getTotalCharge());						    
			}
						

	}
	

}
