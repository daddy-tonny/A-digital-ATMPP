import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private JButton confirmButton;
    private JButton cancelButton;
    private JTextField enterAmountTextField;
    private JPasswordField passwordTextField;
    private JCheckBox showPasswordCheckBox;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        JFrame frame = new JFrame();
        frame.setTitle("CONFIRM TRANSACTION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);  // Center the window

        // Use GridBagLayout for responsive design
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components

        JLabel label1 = new JLabel("Enter Amount:");
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label1, gbc);

        enterAmountTextField = new JTextField(20);
        enterAmountTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        frame.add(enterAmountTextField, gbc);

        JLabel label2 = new JLabel("Password:");
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(label2, gbc);

        passwordTextField = new JPasswordField(20);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridx = 1;
        frame.add(passwordTextField, gbc);

        // Checkbox for showing/hiding password
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(showPasswordCheckBox, gbc);

        confirmButton = new JButton("CONFIRM");
        confirmButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(confirmButton, gbc);

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(this);
        gbc.gridx = 1;
        frame.add(cancelButton, gbc);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String amountText = enterAmountTextField.getText().trim();
            String password = new String(passwordTextField.getPassword()).trim();

            boolean allFieldsFilled = true;

            enterAmountTextField.setBackground(Color.WHITE);
            passwordTextField.setBackground(Color.WHITE);

            // Check if the amount is a valid number
            if (amountText.isEmpty() || !isNumeric(amountText)) {
                enterAmountTextField.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                allFieldsFilled = false;
            }

            if (password.isEmpty()) {
                passwordTextField.setBackground(Color.RED);
                allFieldsFilled = false;
            }

            if (allFieldsFilled) {
                showLoadingAnimation();
            }
        } else if (e.getSource() == cancelButton) {
            enterAmountTextField.setText("");
            passwordTextField.setText("");
            enterAmountTextField.setBackground(Color.WHITE);
            passwordTextField.setBackground(Color.WHITE);
        } else if (e.getSource() == showPasswordCheckBox) {
            if (showPasswordCheckBox.isSelected()) {
                passwordTextField.setEchoChar((char) 0);
            } else {
                passwordTextField.setEchoChar('•');
            }
        }
    }

    // Check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Show loading animation before displaying the result
    private void showLoadingAnimation() {
        JDialog loadingDialog = new JDialog((JFrame) null, "Loading", true);
        JLabel loadingLabel = new JLabel("Processing...", JLabel.CENTER);
        loadingDialog.add(loadingLabel);
        loadingDialog.setSize(200, 100);
        loadingDialog.setLocationRelativeTo(null);

        // Use SwingWorker to display loading animation without freezing the UI
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(2000);  // Simulate 2 seconds delay
                return null;
            }

            @Override
            protected void done() {
                loadingDialog.dispose();
                showTransactionResult();
            }
        };

        worker.execute();
        loadingDialog.setVisible(true);
    }

    // Show transaction result dialog
    private void showTransactionResult() {
        String amountText = enterAmountTextField.getText().trim();
        JOptionPane.showMessageDialog(null, "Transaction successful! Amount is : " + amountText, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
