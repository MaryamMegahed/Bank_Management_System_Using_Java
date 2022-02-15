import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Status implements ActionListener {
	
	JFrame frame= new JFrame();
	JButton goback;
	JLabel statusLabel ;
	
	Status() {
		ImageIcon icon = new ImageIcon("ic.png");//create an image icon
		frame.setIconImage(icon.getImage());//change icon of frame
		frame.getContentPane().setBackground(new Color(0x006666));

		frame.setSize(450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		String Status= MyFrame.CurrentAccount.Status() ;
		statusLabel= new JLabel("Your Status Is: "+Status+" $");
		statusLabel.setBounds(56,40,400,25);
		frame.add(statusLabel);
		statusLabel.setForeground(Color.white);

		goback= new JButton("Go back");
		goback.setBounds(100,200, 250, 25);
		goback.addActionListener(this);
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