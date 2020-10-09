package main;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

 /**
  * 
  * @author Gruppe 1 
  * 
  * Container to display Shop
  *
  */

//This is more or less a placeholder to show what we would have liked the application to be able to do 
//but we decided not to implement an actual Shop Page


public class ShopPage extends Container{
    private JPanel panel1;
    private MenuBar menuBar;
    private JLabel lab;
    private JFrame parentFrame;
    
    public ShopPage (JFrame parentFrame) {
    this.parentFrame = parentFrame;
    setLayout(new BorderLayout());
    panel1 = new JPanel();
    menuBar = new MenuBar(parentFrame);
    //URL url = Shop.class.getResource("Shop.png");           
    //ImageIcon bild = new ImageIcon(url);
    //lab = new JLabel (bild);
    //panel1.add(lab);
    add(menuBar, BorderLayout.NORTH);
    setBackground(Color.white);
    }
}