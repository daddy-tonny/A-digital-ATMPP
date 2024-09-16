import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class myFrame extends JFrame implements ActionListener {

    private JTextField nameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField birthdayField;
    private JTextField numberField;
    private JTextField emailField;
    private JButton button1;
    private JButton button2;
    private JLabel birthErrorLabel;
    private JLabel passwordErrorLabel;
    private JLabel phoneErrorLabel;
    private JCheckBox showPasswordCheckBox;

    myFrame() {
        // Set up the frame
        this.setTitle("Registration Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 500);
        this.setForeground(Color.blue);
        this.setLocationRelativeTo(null);  // Center the window on the screen


        // Use BorderLayout to center components
        this.setLayout(new BorderLayout());

        // Create a panel for the form components
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10)); // 8 rows, 2 columns, with 10px gaps

        // Create and add labels and fields
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField(20);
        formPanel.add(confirmPasswordField);

        formPanel.add(new JLabel("Phone Number (+237):"));
        numberField = new JTextField(20);
        formPanel.add(numberField);

        formPanel.add(new JLabel("Birthday (MM/dd/yyyy):"));
        birthdayField = new JTextField(20);
        formPanel.add(birthdayField);

        // Error Labels
        birthErrorLabel = new JLabel("Incorrect Format");
        birthErrorLabel.setForeground(Color.RED);
        birthErrorLabel.setVisible(false);
        formPanel.add(birthErrorLabel);

        passwordErrorLabel = new JLabel("Passwords do not match");
        passwordErrorLabel.setForeground(Color.RED);
        passwordErrorLabel.setVisible(false);
        formPanel.add(passwordErrorLabel);

        phoneErrorLabel = new JLabel("Phone number must start with +237");
        phoneErrorLabel.setForeground(Color.RED);
        phoneErrorLabel.setVisible(false);
        formPanel.add(phoneErrorLabel);

        // Add the form panel to the center of the frame
        JPanel centerPanel = new JPanel(new GridBagLayout());  // Center components
        centerPanel.add(formPanel);
        this.add(centerPanel, BorderLayout.CENTER);

        // Show password checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        JPanel checkboxPanel = new JPanel();
        formPanel.add(showPasswordCheckBox);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);  // Show password
                confirmPasswordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');  // Hide password
                confirmPasswordField.setEchoChar('*');
            }
        });

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        button1 = new JButton("Register");
        button2 = new JButton("Cancel");
        button1.addActionListener(this);
        button2.addActionListener(this);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Add Focus Listeners
        birthdayField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                birthErrorLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                validateBirthday();
            }
        });

        // Make the frame visible
        this.setVisible(true);
    }

    // Validate birthday format (MM/dd/yyyy)
    private void validateBirthday() {
        String birthdayText = birthdayField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthdayText);
            birthdayField.setBackground(Color.WHITE);
            birthErrorLabel.setVisible(false);
        } catch (ParseException e) {
            birthdayField.setBackground(Color.RED);
            birthErrorLabel.setVisible(true);
        }
    }

    // Check if passwords match
    private boolean doPasswordsMatch() {
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        if (!password.equals(confirmPassword)) {
            passwordErrorLabel.setVisible(true);
            return false;
        } else {
            passwordErrorLabel.setVisible(false);
            return true;
        }
    }

    // Validate phone number format (+237)
    private boolean validatePhoneNumber() {
        String phoneNumber = numberField.getText();
        if (!phoneNumber.startsWith("+237")) {
            phoneErrorLabel.setVisible(true);
            numberField.setBackground(Color.RED);
            return false;
        } else {
            phoneErrorLabel.setVisible(false);
            numberField.setBackground(Color.WHITE);
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            System.exit(0);
        } else if (e.getSource() == button1) {
            boolean allFieldsFilled = !nameField.getText().isEmpty() && !emailField.getText().isEmpty()
                    && passwordField.getPassword().length > 0 && confirmPasswordField.getPassword().length > 0
                    && !birthdayField.getText().isEmpty() && !numberField.getText().isEmpty();

            if (allFieldsFilled && doPasswordsMatch() && validatePhoneNumber() && validateBirthdayInput()) {
                // Show loading animation
                showLoadingAnimation();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields correctly.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showLoadingAnimation() {
        // Create a loading dialog
        JDialog loadingDialog = new JDialog(this, "Loading", true);
        JLabel loadingLabel = new JLabel("Please wait...", JLabel.CENTER);
        loadingDialog.getContentPane().add(loadingLabel);
        loadingDialog.setSize(200, 100);
        loadingDialog.setLocationRelativeTo(this);

        // Use SwingWorker to display the loading animation without freezing the UI
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a delay (e.g., loading)
                Thread.sleep(3000); // 3 seconds delay
                return null;
            }

            @Override
            protected void done() {
                loadingDialog.dispose();
                // Show the registration confirmation dialog after loading
                showRegistrationDialog();
            }
        };

        worker.execute();
        loadingDialog.setVisible(true);
    }

    private void showRegistrationDialog() {
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to Register?",
                "Confirm Registration", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            openNewPage();
        }
    }

    private void openNewPage() {
        JOptionPane.showMessageDialog(this, "Registration successful!");
        JFrame newPage = new JFrame("New Page");
        newPage.setSize(650, 700);
        newPage.setVisible(true);
    }

    // Validate birthday input
    private boolean validateBirthdayInput() {
        String birthdayText = birthdayField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(birthdayText);
            birthdayField.setBackground(Color.WHITE);
            birthErrorLabel.setVisible(false);
            return true;
        } catch (ParseException e) {
            birthdayField.setBackground(Color.RED);
            birthErrorLabel.setVisible(true);
            return false;
        }
    }

}

