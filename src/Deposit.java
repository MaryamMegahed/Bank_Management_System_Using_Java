import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
	JFrame frame= new JFrame();;
	JButton depositButton;
	JLabel Depositamount;
	String depositamount ;
	JTextField amounttext;
	JButton goback;
	double depositamount2;
	
	Deposit(){
	 	ImageIcon icon = new ImageIcon("ic.png");//create an image icon
		
	 	frame.setIconImage(icon.getImage());//change icon of frame
		frame.getContentPane().setBackground(new Color(0x006666));
	 	frame.setSize(450, 300);
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.setLayout(null);
	 	frame.setVisible(true); 
	 	
	 	Depositamount =new JLabel("deposit amount");
	 	Depositamount.setBounds(25,20,200,25);
	 	Depositamount.setForeground(Color.white);
	 	
	 	amounttext= new JTextField();
	 	amounttext.setBounds(200, 20, 165, 25);
		frame.add(amounttext);		
		frame.add(Depositamount);
		frame.setVisible(true);
		
		String deposit = amounttext.getText();
	 	depositButton= new JButton("deposit");
	 	depositButton.setBounds(100,150, 250, 25);
	 	depositButton.addActionListener(this);
	 	frame.add(depositButton);

	 	goback= new JButton("Go back");
	 	goback.setBounds(100,200, 250, 25);
	 	goback.addActionListener(this);
	 	frame.add(goback);
	 	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== depositButton) {
			depositamount = amounttext.getText();
			
		if (	CopiedAccount.isNumeric(depositamount)){
			depositamount2=	 MyFrame.CurrentAccount.testnum(depositamount);
			int confirm=JOptionPane.showConfirmDialog( null, "Are You Sure You Want To Deposit "+depositamount2+" to your account?",
					"alert", JOptionPane.OK_CANCEL_OPTION);
			
			if(confirm==0){
				MyFrame.CurrentAccount.deposit(depositamount2);
                JOptionPane.showMessageDialog(null, "Done successfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                }
			}   
		else{
			JOptionPane.showMessageDialog(null, "Invalid Input",
					"Hey!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==goback) {
			frame.dispose();
			buttons create = new buttons();
		}
	}
}