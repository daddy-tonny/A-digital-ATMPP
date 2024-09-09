import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    // Declare buttons and fields as class variables to be used in actionPerformed
    private JButton confirmButton;
    private JButton cancelButton;
    private JTextField enterAmountTextField;
    private JPasswordField passwordTextField;
    private JCheckBox showPasswordCheckBox;  // Checkbox to show/hide password

    public static void main(String[] args) {
        new Main();  // Create an instance of Main to set up GUI
    }

    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("CONFIRM TRANSACTION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Using null layout for manual placement
        frame.setSize(650, 500);
        frame.setBackground(Color.BLUE);

        JLabel label1 = new JLabel("Enter Amount:");
        label1.setBounds(20, 40, 240, 15);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));

        enterAmountTextField = new JTextField();
        enterAmountTextField.setBounds(180, 40, 290, 25);
        enterAmountTextField.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(20, 80, 240, 15);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordTextField = new JPasswordField();  // Use JPasswordField for security
        passwordTextField.setBounds(180, 80, 290, 25);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 18));

        // Checkbox to show/hide password
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(480, 80, 150, 25);
        showPasswordCheckBox.setForeground(Color.BLACK); // Checkbox text color to white
        showPasswordCheckBox.addActionListener(this);  // Add action listener to the checkbox

        confirmButton = new JButton("CONFIRM");
        confirmButton.setBounds(165, 150, 120, 35);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);  // Add action listener to the button

        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(320, 150, 120, 35);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);  // Add action listener to the button

        frame.add(label1);
        frame.add(label2);
        frame.add(enterAmountTextField);
        frame.add(passwordTextField);
        frame.add(showPasswordCheckBox);  // Add checkbox to the frame
        frame.add(confirmButton);
        frame.add(cancelButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            // Check if both fields are filled
            String accountNumber = enterAmountTextField.getText().trim();
            String password = new String(passwordTextField.getPassword()).trim();

            boolean allFieldsFilled = true;  // Flag to check if all fields are filled

            // Reset field colors
            enterAmountTextField.setBackground(Color.WHITE);
            passwordTextField.setBackground(Color.WHITE);

            // Check if account number field is empty
            if (accountNumber.isEmpty()) {
               enterAmountTextField.setBackground(Color.RED);  // Highlight in red
                allFieldsFilled = false;
            }

            // Check if password field is empty
            if (password.isEmpty()) {
                passwordTextField.setBackground(Color.RED);  // Highlight in red
                allFieldsFilled = false;
            }

            if (allFieldsFilled) {
                // All fields are filled, show success message
                JOptionPane.showMessageDialog(null, "Transaction successful!\nAccount Number: " + accountNumber);
            } else {
                // Show error message if any field is empty
                JOptionPane.showMessageDialog(null, "Please fill all text fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelButton) {
            // Action for cancel button
            enterAmountTextField.setText("");  // Clear account number text field
            passwordTextField.setText("");  // Clear password field
            enterAmountTextField.setBackground(Color.WHITE);  // Reset field color
            passwordTextField.setBackground(Color.WHITE);  // Reset field color
        } else if (e.getSource() == showPasswordCheckBox) {
            // Toggle password visibility based on checkbox state
            if (showPasswordCheckBox.isSelected()) {
                passwordTextField.setEchoChar((char) 0);  // Show password
            } else {
                passwordTextField.setEchoChar('•');  // Hide password with bullet character
            }
        }
    }
}

