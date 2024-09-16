import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
    
    public MainFrame() {
     //cree un panel pour contenir les boutons 
     JPanel Panel = new JPanel();
     Panel.setLayout(new GridLayout(2, 1));

     //cree plusieurs boutons
     JButton button1 = new JButton("Transfer Money");
     button1.setSize(100, 50);
     JButton button2 = new JButton("Check Balance");
     button2.setSize(100, 50);
    

    //cree des ecouteurs daction
    button1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewFrame newFrame1 = new NewFrame("TransferMoney");
            newFrame1.setVisible(true); 
        }
        
    });
       
         //cree des ecouteurs daction
    button2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewFrame newFrame2 = new NewFrame("Check Balance");
            newFrame2.setVisible(true); 
        }
        
    }); 
    

//ajoute les boutons au panel
Panel.add(button1);
Panel.add(button2);


//ajoute panel a la fenetre principale
add(Panel);

// Configure la fenêtre principale
        setTitle("Transactions");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre
    }

    public static void main(String[] args) {
        // Crée et affiche la fenêtre principale
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

}

class NewFrame extends JFrame {
    
    public NewFrame(String string) {
 //comfigure la nouvelle fenetre
    setTitle(string);
    setSize(600,400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    setLocationRelativeTo(null);

//cree un panel
    JPanel Panel = new JPanel();
    Panel.setLayout(new GridLayout(3,1));
   
     //cree NOUVEAUX boutons
     JButton buttonA = new JButton("Bank");
     JButton buttonB = new JButton("momo");
     JButton buttonC = new JButton("ATM");

    //cree des ecouteurs daction
    buttonA.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           JOptionPane.showMessageDialog(null, "button A clicked on " + string);
        }
        
    });
       
         //cree des ecouteurs daction
    buttonB.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "button B clicked on " + string);  
        }
        
    }); 
    
  //cree des ecouteurs daction
  buttonC.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "button C clicked on " + string);
    }
    
});

//ajoute les boutons au panel
Panel.add(buttonA);
Panel.add(buttonB);
Panel.add(buttonC);

//ajoute panel a la fenetre principale
add(Panel);




    }
}
