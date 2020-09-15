import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Gruppe 1
 * Form to add a new Problem to the database
 *
 */
public class ProblemForm extends JFrame {
	private JScrollPane sp, sp2, sp3;
	private JComboBox<String> baummenu, gebietmenu;
	private JTextArea standortfeld, bildFeld, problemFeld;
	private JLabel problem, baumart, standort, bild;
	private JFrame frame = this;

	public ProblemForm() {
		Container c = getContentPane();
        c.setLayout(new GridLayout(10, 1));
        String[] namen = new String []
                {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
        String[] gebiet = new String []
                {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
        JLabel problem = new JLabel("Problembeschreibung:");
        JLabel baumart = new JLabel("Baumart:");
        JLabel gebiet1 = new JLabel("Gebiet:");
        JLabel standort = new JLabel("Standortkoordinaten:");
        JLabel bild = new JLabel("Bild:");
        problemFeld = new JTextArea();
        problemFeld.setLineWrap(true);
        sp = new JScrollPane(problemFeld);
        baummenu = new JComboBox<String>(namen);
        gebietmenu = new JComboBox<String>(gebiet);
        standortfeld = new JTextArea();
        sp2 = new JScrollPane(standortfeld);
        bildFeld = new JTextArea();
        sp3 = new JScrollPane(bildFeld);
        JButton knopf = new JButton("Hinzufuegen");
        c.add(problem);
        c.add(sp);
        c.add(baumart);
        c.add(baummenu);
        c.add(gebiet1);
        c.add(gebietmenu);
        c.add(standort);
        c.add(sp2);
        c.add(bild);
        c.add(sp3);
        c.add(knopf);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			try {
				String description = problemFeld.getText();
				String baum = (String) baummenu.getSelectedItem();
				
				//not really pretty or clean but the easiest way to do this rn :/
				int area = gebietmenu.getSelectedIndex();
 
				DBConnection dbConnection = new DBConnection();
				dbConnection.insertProblem(new Problem(0, description, area, 1, baum));
				dbConnection.close();

				frame.dispose();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	 public static void main(String[] args) {
	        ProblemForm fenster = new ProblemForm();
	        fenster.setTitle("Problem");
	        fenster.setSize(500, 300);
	        fenster.setVisible(true);
	        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

}
