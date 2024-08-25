package bosstonny;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home{
	
public static void main(String[] arg) {
	
	JFrame  frame = new JFrame();
	frame.setTitle("DIGITAL ATM");
	frame.setLayout(new BorderLayout(5,5));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500,500);
	frame.setVisible(true);
	//ImageIcon image = new ImageIcon("");
	//frame.setIconImage(image.getImage());//changes the icon of frame
	
	//frame.getContentPane().setBackground(Color.green);
	
	//creating some panel
	JPanel panel1= new JPanel();
	JPanel panel2= new JPanel();
	JPanel panel3= new JPanel();
	JPanel panel4= new JPanel();
	JPanel panel5= new JPanel();
	
	panel1.setBackground(Color.red);
	panel2.setBackground(Color.blue);
	panel3.setBackground(Color.green);
	panel4.setBackground(Color.yellow);
	panel5.setBackground(Color.white);
	
	panel1.setPreferredSize(new Dimension(100,100));
	panel2.setPreferredSize(new Dimension(100,100));
	panel3.setPreferredSize(new Dimension(100,100));
	panel4.setPreferredSize(new Dimension(100,100));
	panel5.setPreferredSize(new Dimension(100,100));
	
	frame.add(panel1,BorderLayout.NORTH);
	frame.add(panel2,BorderLayout.WEST);
	frame.add(panel3,BorderLayout.EAST);
	frame.add(panel4,BorderLayout.SOUTH);
	frame.add(panel5,BorderLayout.CENTER);
	
	//adding button to a panel
	JButton btn1 = new JButton("SIGN IN");
	JButton btn2 = new JButton("CREATE ACCOUNT");
	
	JPanel ButtonPanel = new JPanel();
	ButtonPanel.add(btn1);
	ButtonPanel.add(btn2);
	panel4.add(ButtonPanel,BorderLayout.SOUTH);
	
	//adding event listerner to the button to perform their task
	btn1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 // Create an instance of the SignIn class
	        SignIn signInForm = new SignIn();
	        // Initialize the sign-in form
	        signInForm.initialize();

		}
		
	});
	
	//THIS ARE SUB PANELS
	
	/***JPanel panel6= new JPanel();
	JPanel panel7= new JPanel();
	JPanel panel8= new JPanel();
	JPanel panel9= new JPanel();
	JPanel panel10= new JPanel();
	
	panel6.setBackground(Color.black);
	panel7.setBackground(Color.darkGray);
	panel8.setBackground(Color.gray);
	panel9.setBackground(Color.yellow);
	panel10.setBackground(Color.white);
	
	//setting panel5 with anew border layout
	panel5.setLayout(new BorderLayout());
	
	panel5.add(panel6,BorderLayout.NORTH);
	panel5.add(panel7,BorderLayout.SOUTH);
	panel5.add(panel8,BorderLayout.EAST);
	panel5.add(panel9,BorderLayout.WEST);
	panel5.add(panel10,BorderLayout.CENTER);
	//this are sub panels

	panel6.setPreferredSize(new Dimension(50,50));
	panel7.setPreferredSize(new Dimension(50,50));
	panel8.setPreferredSize(new Dimension(50,50));
	panel9.setPreferredSize(new Dimension(50,50));
	panel10.setPreferredSize(new Dimension(50,50));
	
	*/
	

	
}
	
	
	
	
}