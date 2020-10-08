import javax.swing.*;
import java.awt.*;
import java.net.URL;


/**
 * 
 * @author Gruppe 1
 * Menubar used for navigation between pages 
 * 
 *
 */
public class MenuBar extends JPanel {
	private JButton mainButton,shopButton, chatButton, problemsButton, tasksButton ;
	
	public MenuBar(JFrame parentFrame ) {
		setLayout(new GridLayout(1,5));
		URL url = MenuBar.class.getResource("Icon.png");
	    Icon icon = new ImageIcon(url);
	    
	    
		mainButton 		= new JButton(icon);
		shopButton 		= new JButton("Shop");
		chatButton 		= new JButton("Chat");
		problemsButton 	= new JButton("Probleme");
		tasksButton	 	= new JButton("Aufgaben");
		
		
	    mainButton.addActionListener(new NavButtonListener( parentFrame, NavButtonListener.MAIN_MENU));
	    shopButton.addActionListener(new NavButtonListener( parentFrame, NavButtonListener.SHOP_PAGE));
	    chatButton.addActionListener(new NavButtonListener( parentFrame, NavButtonListener.CHAT_PAGE));
	    problemsButton.addActionListener(new NavButtonListener( parentFrame, NavButtonListener.PROBLEM_PAGE));
	    tasksButton.addActionListener(new NavButtonListener( parentFrame, NavButtonListener.TASK_PAGE));
	    
	    tasksButton.setBackground(Color.WHITE);
	    mainButton.setBackground(Color.WHITE);
	    problemsButton.setBackground(Color.WHITE);
	    shopButton.setBackground(Color.WHITE);
	    chatButton.setBackground(Color.WHITE);
	    
	    setBackground(Color.white);
	    
	    add(problemsButton);
	    add(tasksButton);
	    add(mainButton);
	    add(shopButton);
	    add(chatButton);
	}
}
