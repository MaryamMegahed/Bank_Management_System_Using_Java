import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel Balance ;
	JButton goback;

	Balance(){
		
		ImageIcon icon = new ImageIcon("ic.png");
     
		//Setting the Frame Design
		 frame.setSize(450, 300);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(null);
		 frame.setVisible(true);
	 	 frame.setIconImage(icon.getImage());
	     frame.getContentPane().setBackground(new Color(0x006666));
	     
	     //Setting the components
	     Balance= new JLabel("Your balance is   "+ MyFrame.CurrentAccount.getBalance()+" $");
	     Balance.setBounds(50,50,250,25);
	     Balance.setFont(Balance.getFont().deriveFont((float) 15.0));
	     Balance.setForeground(Color.white);
	     frame.add(Balance);

	     goback= new JButton("Go back");
	     goback.setBounds(100,150, 250, 25);
	     goback.addActionListener(this);
	     goback.setFocusable(false);
	     frame.add(goback);
	     }

	//Setting action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==goback) {
			frame.dispose();
			buttons create = new buttons();
		}
	}
}