import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * @author Gruppe 1 
 * 
 * Container to display Chat
 *
 */

//This is more or less a placeholder to show what we would have liked the application to be able to do 
//but we decided not to implement an actual Chat-Function

public class ChatPage extends Container{
    JPanel panel1, panelNavigation;
    JLabel label;
    JFrame parentFrame;
    JButton btnBack;
    
    public ChatPage (JFrame parentFrame) {
    this.parentFrame = parentFrame;
    setLayout(new BorderLayout());
    panel1 = new JPanel();
    panelNavigation = new MenuBar(parentFrame);
    URL url = ChatPage.class.getResource("Chat.png");           
    ImageIcon bild = new ImageIcon(url);
    label = new JLabel (bild);
    panel1.add(label);
    add(panelNavigation, BorderLayout.NORTH);
    add(panel1, BorderLayout.CENTER);
    
   
    }
    
}