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
	public JScrollPane sp, sp2, sp3;
	public JComboBox<String> baummenu, gebietmenu;
	public JTextArea standortfeld, bildFeld, problemFeld;
	public JLabel problem, baumart, standort, bild;
	public JFrame frame = this;

	public ProblemForm() {
		Container c = getContentPane();
        c.setLayout(new GridLayout(10, 1));
        String[] namen = new String []
                {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
        String[] Gebiet = new String []
                {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
        JLabel Problem = new JLabel("Problembeschreibung:");
        JLabel Baumart = new JLabel("Baumart:");
        JLabel Gebiet1 = new JLabel("Gebiet:");
        JLabel Standort = new JLabel("Standortkoordinaten:");
        JLabel Bild = new JLabel("Bild:");
        problemFeld = new JTextArea();
        problemFeld.setLineWrap(true);
        sp = new JScrollPane(problemFeld);
        baummenu = new JComboBox<String>(namen);
        gebietmenu = new JComboBox<String>(Gebiet);
        standortfeld = new JTextArea();
        sp2 = new JScrollPane(standortfeld);
        bildFeld = new JTextArea();
        sp3 = new JScrollPane(bildFeld);
        JButton knopf = new JButton("Hinzufuegen");
        c.add(Problem);
        c.add(sp);
        c.add(Baumart);
        c.add(baummenu);
        c.add(Gebiet1);
        c.add(gebietmenu);
        c.add(Standort);
        c.add(sp2);
        c.add(Bild);
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
				dbConnection.insertProblem(new Problem(description, area, 1, baum));
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