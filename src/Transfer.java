import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Transfer extends JFrame implements ActionListener{
	
	public JFrame frame= new JFrame();
	 
	JLabel transferamount;
	JLabel transferto; 
	JTextField amounttext;
	JTextField totext;
	JButton transferButton ;
	JButton goback;
	String money;
	String id;
	double amount;
	double idNum;
	
	Transfer(){
		 ImageIcon icon = new ImageIcon("ic.png");//create an image icon
		 frame.setIconImage(icon.getImage());//change icon of frame
		 frame.getContentPane().setBackground(new Color(0x006666));

		 frame.setSize(450, 300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(null);
		 frame.setVisible(true);

		 transferamount =new JLabel("TRANSFERED AMOUNT");
		 transferto =new JLabel("CREDIT CARD TRANSFERED TO");
		 transferamount.setBounds(25,20,200,25);
		 transferto.setBounds(25, 60, 200, 25);
		 transferamount.setForeground(Color.white);
		 transferto.setForeground(Color.white);
		 
		 amounttext= new JTextField();
		 amounttext.setBounds(220, 20, 165, 25);
		 frame.add(amounttext);
		 frame.setVisible(true);
		 
		 totext= new JTextField();
		 totext.setBounds(220, 60, 165, 25);
		 frame.add(totext);
		 frame.setVisible(true);
		 
		 frame.add(transferamount);
		 frame.add(transferto);
		
	 	goback= new JButton("Go Back");
	 	goback.setBounds(100,200, 250, 25);
	 	goback.addActionListener(this);
	 	frame.add(goback);
			    
	 	transferButton= new JButton("Transfer");
	 	transferButton.setBounds(100,150, 250, 25);
	 	transferButton.addActionListener(this);
	 	frame.add(transferButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource()==goback) {
			frame.dispose();
			buttons create = new buttons();
			}
		if (e.getSource()==transferButton) {
			money = amounttext.getText();
			id = totext.getText();
			if (CopiedAccount.isNumeric(money)== true && CopiedAccount.isNumeric(id)== true) {
				amount=	MyFrame.CurrentAccount.testnum(money);
          		idNum=	MyFrame.CurrentAccount.testnum(id);
              	
          		Boolean correctid = false;
          		for (CopiedAccount account : MyFrame.accounts) {
	 			
          			if(account.customerID == idNum && account.customerID !=MyFrame.CurrentAccount.customerID) {
          				correctid=true;
          				if(amount<=MyFrame.CurrentAccount.balance) {
          					int confirm=JOptionPane.showConfirmDialog( null, "Are You Sure You Want To Transfer "+amount+" From Your Account"+" "
          							+ "to "+ account.customerName+"?", "alert", JOptionPane.OK_CANCEL_OPTION);
			
          					if(confirm==0)
          						MyFrame.CurrentAccount.trans(amount ,account);	
          					}
          				else{
          					JOptionPane.showMessageDialog(null, "Not Enough Balance",
		    		      "	Hey!", JOptionPane.ERROR_MESSAGE);
          					}
          				break;	
          				}
          			}   
          		if(!correctid) { 
          			JOptionPane.showMessageDialog(null, "Incorrect ID",
          					"Hey!", JOptionPane.ERROR_MESSAGE);
		               	}
          		}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Input",
						"Hey!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
