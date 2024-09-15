package bosstonny;
import java.awt.*;
import javax.swing.*;

public class AboutUs {
    private JFrame frame;
    private JLabel label2;

    public AboutUs() {
        frame = new JFrame("DIGITAL ATM");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));

        // Custom panel for background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(new ImageIcon("C:/Users/NEWUSER/eclipse-workspace/Firstswing/src/bosstonny/Imges/group.pg.jpg").getImage());

        // Block of text for label2
        String text = "<html>" +
                "<h1>   About Us   </h1>" +
                "<p>  Welcome to our Digital ATM project."
                + "       Our goal is to provide"
                + " easy access to financial services.</p>" +
                "<p>We are committed to ensuring security and"
                + "       convenience.</p>" +
                "<p>Contact us for more innovative projects at "
                +       "ICT UNIVERSITY OPEN 24/7.</p>" +
                "</html>";
        label2 = new JLabel(text);
        label2.setPreferredSize(new Dimension(400, 250));
        label2.setForeground(Color. BLUE ); // Change text color to white for visibility

        // Set layout and add label2 to the background panel
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(label2, BorderLayout.SOUTH); // Position the text at the bottom

        // Add the background panel to the frame
        frame.add(backgroundPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AboutUs();
    }

    // Custom JPanel to handle background image
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image, scaling it to fit the entire panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


