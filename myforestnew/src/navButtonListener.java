import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 * This is a generic ActionListener for Navigation between different pages of the project
 * @author Gruppe 1
 *
 */
public class navButtonListener implements ActionListener {
	
	String destinationPage;
	JFrame frame;
	public static final String MAIN_MENU = "main";
	public static final String CHAT_PAGE = "chat";
	public static final String SHOP_PAGE = "shop";
	public static final String TASK_PAGE  = "task";
	public static final String PROBLEM_PAGE  = "problem";
	
	
	 public navButtonListener(JFrame frame, String destinationPage) {
		 this.destinationPage = destinationPage;
		 this.frame = frame;
		 }
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(destinationPage) {
		case(MAIN_MENU):
			frame.setContentPane(new MainMenu(frame));
			break;
		case(CHAT_PAGE):
			frame.setContentPane(new ChatPage(frame));
			break;
		case(SHOP_PAGE):
			frame.setContentPane(new ShopPage(frame));
			break;
		case(PROBLEM_PAGE):
			frame.setContentPane(new ProblemPage(frame));
			break;
		case(TASK_PAGE):
			frame.setContentPane(new TaskPage(frame));
			break;
		}
		frame.setVisible(true);
		
	}

}
