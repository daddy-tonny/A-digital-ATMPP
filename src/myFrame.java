import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class myFrame extends JFrame implements ActionListener {

        private JTextField nameField;
        private JTextField passwordField;
        private JTextField confirmPasswordField;
        private JTextField birthField;
        private JTextField numberField;
        private JTextField emailField;
        private JButton button1;
        private JButton button2;
        private JFrame newPage;

        myFrame() {
            // Set up the frame
            this.setTitle("Registration Page");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null); // Using null layout for manual placement
            this.setSize(650, 700);
            this.setBackground(Color.BLUE);

            // Create and add labels
            addLabel("NAME:", 20, 50);
            addLabel("PASSWORD:", 20, 90);
            addLabel("CONFIRM PASSWORD:", 20, 130);
            addLabel("BIRTHDAY:", 20, 170);
            addLabel("PHONE NUMBER:", 20, 210);
            addLabel("EMAIL:", 20, 250);

            // Create and add text fields
            nameField = addTextField(250, 55);
            passwordField = addTextField(250, 95);
            confirmPasswordField = addTextField(250, 135);
            birthField = addTextField(250, 175);
            numberField = addTextField(250, 215);
            emailField = addTextField(250, 255);

            // Create and add buttons
            button1 = createButton("OK", 250, 300);
            button2 = createButton("EXIT", 450, 300);
            button1.addActionListener(this);
            button2.addActionListener(this);
            // Adds action listener to the EXIT button

            this.setVisible(true);
        }

        private JLabel addLabel(String text, int x, int y) {
            JLabel label = new JLabel(text);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            label.setBounds(x, y, 250, 30);
            label.setHorizontalTextPosition(JLabel.LEFT);
            this.add(label);
            return label;
        }

        private JTextField addTextField(int x, int y) {
            JTextField textField = new JTextField();
            textField.setFont(new Font("Arial", Font.PLAIN, 21));
            textField.setBounds(x, y, 350, 26);
            this.add(textField);
            return textField;
        }

        private JButton createButton(String text, int x, int y) {
            JButton button = new JButton(text);
            button.setBounds(x, y, 130, 45);
            button.setFocusable(false);
            this.add(button);
            return button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                //this.setVisible(fa);
               int confirm = JOptionPane.showConfirmDialog(null,"do you want to Register?",
                       "confirm registration", JOptionPane.YES_NO_OPTION);
               if (confirm == JOptionPane.YES_NO_OPTION){
                   this.setVisible(false);
                   JFrame newPage = new JFrame("New Page");
                   newPage.setSize(650,700);
                   newPage.add(new JLabel("this is the new page!"));

                   newPage.setVisible(true);
               }

            }
        }
    }



