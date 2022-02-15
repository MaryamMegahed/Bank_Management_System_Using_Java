	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	
	public class MyFrame extends JFrame implements ActionListener {
	 
		private static JFrame frame;
		private static JLabel namelabel;
		private static JLabel CClabel;
		private static JButton login;
		private static JPasswordField CCtext;
		private static JTextField usertext;
		public  static String custmerName;
		public  static String custmerId;
		public boolean valiedAccount = false ;
		static int  number ;
		public boolean test;
	
		static public	CopiedAccount account0 =new  CopiedAccount ("alaa" ,  1101,8521 );
		static public  CopiedAccount account1 =new  CopiedAccount ("mariam" , 2361 ,9632);
		static public CopiedAccount account2 =new  CopiedAccount("mariam" , 3561 ,7891);
		static public CopiedAccount account3 =new  CopiedAccount ("aya" , 4789,4567 );
		static public CopiedAccount account4 =new  CopiedAccount ("sara" ,5644 ,1234);
		static public TheVip account5 =new TheVip ("samir" , 100100 , 100, 78945 );
		static public TheVip account6 =new TheVip ("ali" , 500500  , 1500000,45612);
		static public CopiedAccount accounts [] = {account0, account1, account2, account3,account4,account5,account6};
		static CopiedAccount CurrentAccount =new CopiedAccount(MyFrame.getname(),0, MyFrame.getPasscode());

		public void start() {
			
			ImageIcon icon = new ImageIcon("ic.png");			
			frame= new JFrame();
			JPanel panel= new JPanel();
			frame.add(panel);
			panel.setLayout(null);
	 
			namelabel= new JLabel("NAME");
			namelabel.setBounds(25,20,200,25);
			panel.add(namelabel);
	 
			usertext= new JTextField();
			usertext.setBounds(200, 20, 165, 25);
			panel.add(usertext);
			frame.setVisible(true);
	 
			CClabel= new JLabel("PASSCODE");
			CClabel.setBounds(25,60,200,25);
			panel.add(CClabel);
	 
		    CCtext= new JPasswordField(25);  
			CCtext.setBounds(200, 60, 165, 25);
			panel.add(CCtext);
				
			frame.setVisible(true);
		   	frame.setTitle("BANK");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);   
			frame.setSize(425,200); 
			frame.setIconImage(icon.getImage());
				
			login= new JButton("LOGIN");
			login.setBounds(250, 100, 80, 25);
            login.addActionListener(this);
	        panel.add(login);
	        login.setFocusable(true);
	        frame.getContentPane().setBackground(new Color(0x006666));
	        }
	 
		@Override
		public void actionPerformed(ActionEvent e) { 	
			if (e.getSource()==login) { 
				frame.dispose();
				custmerName = usertext.getText();
				custmerId = CCtext.getText();
				if (isNumeric(custmerId)){
					number = (int)CurrentAccount.testnum(custmerId);
					for (CopiedAccount copiedAccount : accounts){
						if(copiedAccount.customerName.equals(custmerName)&& copiedAccount.customerPasscode==number ) {
							valiedAccount=true;
							char option = '\0';
							CurrentAccount=copiedAccount;
							buttons create = new buttons();
						}
					}
					if(!valiedAccount) {
						JOptionPane.showMessageDialog(null, "InValied account ! please try again",
								"Hey!", JOptionPane.ERROR_MESSAGE);
						MyFrame newframe =new MyFrame();			
						newframe.start();
						}				
					} 
					else {
					
						JOptionPane.showMessageDialog(null, "Invalid Input",
								"Hey!", JOptionPane.ERROR_MESSAGE);
						MyFrame newframe =new MyFrame();			
		        		newframe.start();
						}
					}
					
			}
	
		public static String getname () {
			String name2 = custmerName;
			return name2;
		}
		public static  int getPasscode () {
			return number;			
		}					
		private static boolean isNumeric(String str){
			return str != null && str.matches("[0-9.]+");
		}	
		public  CopiedAccount  getAccount ( ) {			
					return CurrentAccount;
		}
	}
