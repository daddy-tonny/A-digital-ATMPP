package bosstonny;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




public class SignIn extends JFrame {
	
	final private Font mainFont =new Font("Segoe print",Font.BOLD,18);
	//creating a new text field as a global variable
	JTextField   tfUserName ,tfPassword;
	JLabel IbWelcome;
	
	public void initialize() {
		
		
		/*********form panel********/
		JLabel IbUserName = new JLabel("UserName");
	IbUserName.setFont( mainFont);
	
	tfUserName= new JTextField();
	tfUserName.setFont(mainFont);
	
		
		JLabel  IbPassword = new JLabel("Password");
		IbPassword.setFont(mainFont);
		
		tfPassword= new JTextField();
		tfPassword.setFont(mainFont);
		
		//form panel containing the above components
		JPanel formPanel =new JPanel();
		formPanel.setLayout(new GridLayout(4,1,5,5));
		//making form Panel transparent
		formPanel.setOpaque(false);
		
		//adding the  different components to the form panel
		
	formPanel.add(IbUserName);
	formPanel.add(tfUserName);
	formPanel.add(IbPassword);
	formPanel.add(tfPassword);
	
		
	/******	welcome Label******/
	
		IbWelcome =new JLabel();
		
		IbWelcome.setFont(mainFont);
	/*****button****panel****/
		JButton btnOK =new JButton("OK");
		btnOK.setFont(mainFont);
		//adding a listener to the button
		
	btnOK.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String UserName = tfUserName.getText();
			String Password= tfPassword.getText();
			IbWelcome.setText("Hello" + UserName +"" + Password);
		}
		
	});
		
		JButton btnExit =new JButton("Exit");
		btnExit.setFont(mainFont);
		
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// TODO Auto-generated method stub
				tfUserName.setText("");
				tfPassword.setText(" ");
				IbWelcome.setText(" ");
				
				
				
			}
			
		});
		
		//Creating the panel that contains two Button
		JPanel ButtonPanel =new JPanel();
		ButtonPanel.setLayout(new GridLayout(1,2,5,5));
		ButtonPanel.add(btnOK);
		ButtonPanel.add(btnExit);
		ButtonPanel.setOpaque(false);
		
		
		
		
		//creating the main panel of the frame
		JPanel mainPanel =new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(128,123,245));
		//adding dimension to the main panel
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//adding the form panel to the main panel
		mainPanel.add(formPanel,BorderLayout.NORTH);
		mainPanel.add(IbWelcome,BorderLayout.CENTER);
		mainPanel.add(ButtonPanel,BorderLayout.SOUTH);
		
		add(mainPanel);
		
		
		setTitle("DIGITAL ATM");
		setSize(500,500);
		setMinimumSize(new Dimension(300,400));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
		
		
	};
	
	public static void main(String[] args) {
		
		SignIn signin =new SignIn();
		
		signin.initialize();
		
		
		
		
		
		
		
	}
	
	

}
