import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

	public class Withdraw implements ActionListener {
		
		JFrame frame= new JFrame();;
		 JLabel withdrawamount;
	     String Withdrawamount;
		 JTextField amounttext;
		 JButton withdrawButton;
		 JLabel Balance;
		 JButton goback;
		double withdrawamount2;
		
		 Withdraw()  {
			 ImageIcon icon = new ImageIcon("ic.png");
			 frame.setIconImage(icon.getImage());
			 
			 frame.setSize(450, 300);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setLayout(null);
			 frame.setVisible(true);
			 
			 withdrawamount =new JLabel("Withdraw Amount");
			 withdrawamount.setBounds(25,20,200,25);
			 withdrawamount.setForeground(Color.white);
				
			 amounttext= new JTextField();
			 amounttext.setBounds(200, 20, 165, 25);
			 frame.add(amounttext);
			 frame.add(withdrawamount);
			 frame.setVisible(true);
			 frame.getContentPane().setBackground(new Color(0x006666));
			 String amount = amounttext.getText();
				 
			 withdrawButton= new JButton("withdraw");
			 withdrawButton.setBounds(100,150, 250, 25);
			 withdrawButton.addActionListener(this);
			 frame.add(withdrawButton);
			 
			 goback= new JButton("Go back");
			 goback.setBounds(100,200, 250, 25);
			 goback.addActionListener(this);
			 frame.add(goback);
		}
		 
	 @Override
	 public void actionPerformed(ActionEvent e) {
			if (e.getSource()== withdrawButton) {
				Withdrawamount = amounttext.getText();
				
				if (	CopiedAccount.isNumeric(Withdrawamount)){
					withdrawamount2=	MyFrame.CurrentAccount.testnum(Withdrawamount);
					
					if (MyFrame.CurrentAccount.inDebt) 
						JOptionPane.showMessageDialog(null, "Sorry, You Can't Withdraw! You're Indebted!","Error", JOptionPane.ERROR_MESSAGE);
					else {
						MyFrame.CurrentAccount.withdraw(withdrawamount2);

					}
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Input",
							"Hey!", JOptionPane.ERROR_MESSAGE);
				
				}

			if (e.getSource()==goback) {
				frame.dispose();
				buttons create = new buttons();
			}
		}
	 }
