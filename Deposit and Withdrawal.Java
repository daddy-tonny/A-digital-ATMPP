import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ATMWalletApp {
    private JFrame mainFrame;
    private double atmBalance = 1000.0; // Example ATM balance
    private double bankBalance = 2000.0; // Example Bank balance
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ATMWalletApp().createMainFrame());
    }

    private void createMainFrame() {
        mainFrame = new JFrame("ATMWALLET");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridBagLayout());

        // Centralized account balance label
        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Buttons for Deposit and Withdrawal
        JButton depositButton = createCustomButton("Deposit");
        JButton withdrawButton = createCustomButton("Withdraw");

        depositButton.addActionListener(e -> showDepositOptions());
        withdrawButton.addActionListener(e -> showWithdrawalOptions());

        // Layout constraints for the grid
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mainFrame.add(depositButton, gbc);

        gbc.gridx++;
        mainFrame.add(withdrawButton, gbc);

        mainFrame.setVisible(true);
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 50));  // Adjust button size
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjust font size
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    private void showDepositOptions() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton depositToATMButton = createCustomButton("Deposit to ATM");
        JButton depositToBankButton = createCustomButton("Deposit to Bank");

        depositToATMButton.addActionListener(e -> showDepositToATMFrame());
        depositToBankButton.addActionListener(e -> showDepositToBankFrame());

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> createMainFrame());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        mainFrame.add(depositToATMButton, gbc);

        gbc.gridx++;
        mainFrame.add(depositToBankButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showWithdrawalOptions() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton withdrawFromBankButton = createCustomButton("Withdraw from Bank");
        JButton withdrawFromATMButton = createCustomButton("Withdraw from ATM");

        withdrawFromBankButton.addActionListener(e -> showWithdrawFromBankFrame());
        withdrawFromATMButton.addActionListener(e -> showWithdrawFromATMFrame());

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> createMainFrame());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        mainFrame.add(withdrawFromBankButton, gbc);

        gbc.gridx++;
        mainFrame.add(withdrawFromATMButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showDepositToATMFrame() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel amountLabel = new JLabel("Deposit Amount:");
        JTextField amountField = new JTextField(10);

        JLabel providerLabel = new JLabel("Mobile Money Provider:");
        JComboBox<String> providerComboBox = new JComboBox<>(new String[]{"MTN", "ORANGE"});

        JLabel mobileLabel = new JLabel("Mobile Number:");
        JTextField mobileField = new JTextField(10);

        JButton depositButton = createCustomButton("Deposit");
        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                atmBalance += amount;
                transactionHistory.add("Deposited $" + amount + " to ATM via " + providerComboBox.getSelectedItem() + " on " + LocalDateTime.now());
                JOptionPane.showMessageDialog(mainFrame, "Deposit successful!");
                createMainFrame();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Please enter a valid amount.");
            }
        });

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> showDepositOptions());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(amountLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(providerLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(providerComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(mobileLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainFrame.add(depositButton, gbc);

        gbc.gridy++;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showDepositToBankFrame() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel amountLabel = new JLabel("Deposit Amount:");
        JTextField amountField = new JTextField(10);

        JLabel bankLabel = new JLabel("Choose Bank:");
        JComboBox<String> bankComboBox = new JComboBox<>(new String[]{"NFC Bank", "UBA Bank", "ECOBANK", "SOCIETE GENERAL"});

        JLabel accountLabel = new JLabel("Bank Account Number:");
        JTextField accountField = new JTextField(10);

        JButton depositButton = createCustomButton("Deposit");
        depositButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if (atmBalance >= amount) {
                atmBalance -= amount;
                transactionHistory.add("Deposited $" + amount + " to " + bankComboBox.getSelectedItem() + " on " + LocalDateTime.now());
                JOptionPane.showMessageDialog(mainFrame, "Deposit successful!");
                createMainFrame();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Insufficient ATM balance!");
            }
        });

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> showDepositOptions());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(amountLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(bankLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(bankComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(accountLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(accountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainFrame.add(depositButton, gbc);

        gbc.gridy++;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showWithdrawFromBankFrame() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("Bank Balance: $" + bankBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel amountLabel = new JLabel("Withdraw Amount:");
        JTextField amountField = new JTextField(10);

        JButton withdrawButton = createCustomButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if (bankBalance >= amount) {
                bankBalance -= amount;
                atmBalance += amount;
                transactionHistory.add("Withdrew $" + amount + " from Bank to ATM on " + LocalDateTime.now());
                JOptionPane.showMessageDialog(mainFrame, "Withdrawal successful!");
                createMainFrame();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Insufficient Bank balance!");
            }
        });

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> showWithdrawalOptions());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(amountLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainFrame.add(withdrawButton, gbc);

        gbc.gridy++;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void showWithdrawFromATMFrame() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setLayout(new GridBagLayout());

        JLabel balanceLabel = new JLabel("ATM Balance: $" + atmBalance, SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel amountLabel = new JLabel("Withdraw Amount:");
        JTextField amountField = new JTextField(10);

        JLabel providerLabel = new JLabel("Mobile Money Provider:");
        JComboBox<String> providerComboBox = new JComboBox<>(new String[]{"MTN", "ORANGE"});

        JLabel mobileLabel = new JLabel("Mobile Number:");
        JTextField mobileField = new JTextField(10);

        JButton withdrawButton = createCustomButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            double amount = Double.parseDouble(amountField.getText());
            if (atmBalance >= amount) {
                atmBalance -= amount;
                transactionHistory.add("Withdrew $" + amount + " from ATM to " + providerComboBox.getSelectedItem() + " on " + LocalDateTime.now());
                JOptionPane.showMessageDialog(mainFrame, "Withdrawal successful!");
                createMainFrame();
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Insufficient ATM balance!");
            }
        });

        JButton cancelButton = createCustomButton("Cancel");
        cancelButton.addActionListener(e -> showWithdrawalOptions());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        mainFrame.add(balanceLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(amountLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(providerLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(providerComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainFrame.add(mobileLabel, gbc);

        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainFrame.add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainFrame.add(withdrawButton, gbc);

        gbc.gridy++;
        mainFrame.add(cancelButton, gbc);

        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
