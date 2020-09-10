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
	public JComboBox<String> baummenu;
	public JTextArea standortfeld, bildFeld, problemFeld;
	public JLabel problem, baumart, standort, bild;
	public JFrame frame = this;

	public ProblemForm() {
		Container c = getContentPane();
		c.setLayout(new GridLayout(10, 1));

		String[] namen = new String[] { "Eiche", "Buche", "Tanne", "Ahorn", "Kastanie" };

		problem = new JLabel("Problembeschreibung:");
		baumart = new JLabel("Baumart:");
		standort = new JLabel("Standortkoordinaten:");
		bild = new JLabel("Bild:");

		problemFeld = new JTextArea();
		problemFeld.setLineWrap(true);

		sp = new JScrollPane(problemFeld);
		baummenu = new JComboBox<String>(namen);
		
		standortfeld = new JTextArea();
		sp2 = new JScrollPane(standortfeld);
		
		bildFeld = new JTextArea();
		sp3 = new JScrollPane(bildFeld);
		
		JButton knopf = new JButton("Hinzufügen");
		knopf.addActionListener(new ButtonListener());

		c.add(problem);
		c.add(sp);
		c.add(baumart);
		c.add(baummenu);
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

				DBConnection dbConnection = new DBConnection();
				dbConnection.insertProblem(new Problem(description, 1, 1, baum));
				dbConnection.close();

				frame.dispose();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}