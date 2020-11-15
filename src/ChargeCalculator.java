import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChargeCalculator extends JFrame{
	
	private JButton calculateChargeButton;
	private JPanel panel;
	private Ship ship;
	
	
	
	public ChargeCalculator(Ship aShip) {
		
		ship = aShip;
		panel = new JPanel();		
		calculateChargeButton = new JButton("Calculate Charge");
		
		panel.add(calculateChargeButton);
				
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		calculateChargeButton.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Charge Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Total charge: " + ship.getTotalCharge() );			
		}
	}
	
	

}
