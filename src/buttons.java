import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class buttons extends JFrame implements ActionListener {
	
	private static JButton buttonBalance;
	private static JButton buttonDeposit;
	private static JButton buttonWithdraw;
	private static JButton buttonPT;
	private static JButton buttonTransfer;
	private static JButton buttonStatus;
	private static JButton buttonOut;

	JFrame frame = new JFrame();
	private  JLabel namelabel;
	
	public buttons() {
    	
		ImageIcon icon = new ImageIcon("ic.jpg");
		
		frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(0x006666));
        frame.setSize(850, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
	 
        buttonBalance= new JButton("Check Your Balance");
        buttonBalance.setBounds(225,100, 300, 25);
        buttonBalance.addActionListener(this);
        buttonBalance.setFocusable(false);
	    frame.add(buttonBalance);
	    
	    buttonDeposit= new JButton("Make a Deposit");
	    buttonDeposit.setBounds(225,150, 300, 25);
	    buttonDeposit.addActionListener(this);
	    buttonDeposit.setFocusable(false);
	    frame.add(buttonDeposit);
	    
	    buttonWithdraw= new JButton("Make a Withdrawal");
		buttonWithdraw.setBounds(225,200, 300, 25);
	    buttonWithdraw.addActionListener(this);
	    buttonWithdraw.setFocusable(false);
	    frame.add(buttonWithdraw);
	    
	    buttonPT= new JButton("View Previous Transaction");
	    buttonPT.setBounds(225,250, 300, 25);
	    buttonPT.addActionListener(this);
	    buttonPT.setFocusable(false);
	    frame.add(buttonPT);
	    
	    buttonTransfer= new JButton("Transfer");
		buttonTransfer.setBounds(225,300, 300, 25);
	    buttonTransfer.addActionListener(this);
	    buttonTransfer.setFocusable(false);
	    frame.add(buttonTransfer);
	    
	    buttonStatus= new JButton("View Status");
		buttonStatus.setBounds(225,350, 300, 25);
	    buttonStatus.addActionListener(this);
	    buttonStatus.setFocusable(false);
	    frame.add(buttonStatus);
		    
	    buttonOut= new JButton("sign out");
		buttonOut.setBounds(225,400, 300, 25);
		buttonOut.addActionListener(this);
	    buttonOut.setFocusable(false);
	    frame.add(buttonOut);
		    
	    namelabel= new JLabel("Welcome"+", "+ MyFrame.getname()+"!");
		namelabel.setBounds(260,20,275,35);
		namelabel.setFont(namelabel.getFont().deriveFont((float) 30.0));
		namelabel.setForeground(Color.white);
		frame.add(namelabel);
			 
		namelabel= new JLabel("Your Credit Card is " + MyFrame.CurrentAccount.customerID);
		namelabel.setBounds(270,60,275,35);
		namelabel.setFont(namelabel.getFont().deriveFont((float) 15.0));
		namelabel.setForeground(Color.white);
		frame.add(namelabel);
	}
	
	 
	 
	 
   
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==buttonBalance) {
			frame.dispose();
			Balance newBalance =new Balance();
		}
		if (e.getSource()== buttonWithdraw) {
			frame.dispose();
			Withdraw newwWithdraw = new Withdraw();
		}
		if (e.getSource()==buttonDeposit) {
			frame.dispose();
			Deposit newDeposit = new Deposit();
		}
		if (e.getSource()==buttonPT) {
			frame.dispose();
			Previoustransaction  pnew = new Previoustransaction();
		}
		if (e.getSource()==buttonTransfer) {
	          frame.dispose();
			Transfer newtransfer = new Transfer();
		}
		if (e.getSource()==buttonStatus) {
			frame.dispose();
			Status newstatus= new Status();	
		}
		if (e.getSource()==buttonOut) {
			frame.dispose();
         MyFrame newframe =new MyFrame();			
        newframe.start();
		}
	}	
}