package bosstonny;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountInfoDisplay extends JFrame {
    
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    // creating a new text field as a global variable
    JTextField AccountNumber, Password;

    public AccountInfoDisplay() {
        initialize();
    }

    public void initialize() {
        
        JLabel Accountnumber = new JLabel("AccountNumber");
        Accountnumber.setFont(mainFont);

        AccountNumber = new JTextField();
        AccountNumber.setFont(mainFont);

        JLabel Password1 = new JLabel("Password");
      
        Password1.setFont(mainFont);

        Password = new JTextField();
        Password.setFont(mainFont);

        JPanel MyInput = new JPanel();
        MyInput.setLayout(new GridLayout(4, 1, 5, 5));
        // making form Panel transparent
        MyInput.setOpaque(false);
        

        MyInput.add(Accountnumber);
        MyInput.add(AccountNumber);
        MyInput.add(Password1);
        MyInput.add(Password);

        JButton btnOK = new JButton("OK");
        btnOK.setFont(mainFont);
        // adding a listener to the button
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add your logic here for OK button click
                System.out.println("Account Number: " + AccountNumber.getText());
                System.out.println("Password: " + Password.getText());
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setFont(mainFont);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the program when Exit button is clicked
            }
        });

        // Creating the panel that contains two Buttons
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        ButtonPanel.add(btnOK);
        ButtonPanel.add(btnExit);
        ButtonPanel.setOpaque(false);

        // Creating the main panel of the frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 123, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Adding the form panel to the main panel
        mainPanel.add(MyInput, BorderLayout.NORTH);
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("DIGITAL ATM");
        setSize(500, 500);
        setMinimumSize(new Dimension(100, 100));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(100, 100);
        
    }

    // Adding the main method
    public static void main(String[] args) {
        new AccountInfoDisplay(); // Creates an instance of the class to display the frame
    }
}