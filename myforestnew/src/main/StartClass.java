import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the starting point of the MyForest Application
 * @author Gruppe 1
 *
 */
public class StartClass extends JFrame {
	private Container c, content;
	
	public StartClass() {
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		MenuBar navMenuBar = new MenuBar(this);
		Container content = new HomeScreen(this);
		c.add(navMenuBar, BorderLayout.NORTH);
		c.add(content, BorderLayout.CENTER);
		
	}
	public static void main(String[] args) {
		JFrame start = new StartClass();
		start.setContentPane(new HomeScreen(start));
		start.setTitle("My Forest");
		start.setSize(1500, 1000);
		start.setVisible(true);
		start.setBackground(Color.white);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setContent(Container content) {
		this.content = content; 
		c.add(content, BorderLayout.CENTER);
	}
}
