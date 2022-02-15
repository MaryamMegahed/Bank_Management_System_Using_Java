import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
	
public class Previoustransaction extends JFrame implements ActionListener  {
	 JFrame frame= new JFrame();
	 JButton goback;
	 JLabel previousJLabel ;
	 
	 Previoustransaction(){
		 
	 ImageIcon icon = new ImageIcon("ic.png");//create an image icon
	 frame.setIconImage(icon.getImage());//change icon of frame

	 frame.setSize(450, 300);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setLayout(null);
     frame.getContentPane().setBackground(new Color(0x006666));

     String test =MyFrame.CurrentAccount.previousTransaction ;
     previousJLabel= new JLabel(MyFrame.CurrentAccount.getPreviousTransaction());
     previousJLabel.setBounds(56,40,400,25);
     previousJLabel.setFont(previousJLabel.getFont().deriveFont((float) 20.0));
     frame.add(previousJLabel);
     previousJLabel.setForeground(Color.white);
   
     goback= new JButton("Go back");
     goback.setBounds(100,150, 250, 25);
     goback.addActionListener(this);
     goback.setFocusable(false);

     frame.add(goback);
     frame.setVisible(true);
     }
	 
 @Override
 public void actionPerformed(ActionEvent e) {
	if (e.getSource()==goback) {
		frame.dispose();
		buttons create = new buttons();
		}
	}
 }