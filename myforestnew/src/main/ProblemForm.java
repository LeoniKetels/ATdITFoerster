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
	private JTextArea standortTextArea, bildTextArea, problemTextArea;
	private JLabel lblProblem, lblBaumart, lblStandort, lblBild, lblGebiet;
	private JFrame frame = this;

	public ProblemForm() {
		Container c = getContentPane();
        c.setLayout(new GridLayout(10, 1));
        String[] namen = new String []
                {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
        String[] gebiet = new String []
                {"A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"};
        lblProblem = new JLabel("Problembeschreibung:");
        lblBaumart = new JLabel("Baumart:");
        lblGebiet = new JLabel("Gebiet:");
        lblStandort = new JLabel("Standortkoordinaten:");
        lblBild = new JLabel("Bild:");
        problemTextArea = new JTextArea();
        problemTextArea.setLineWrap(true);
        sp = new JScrollPane(problemTextArea);
        baummenu = new JComboBox<String>(namen);
        gebietmenu = new JComboBox<String>(gebiet);
        standortTextArea = new JTextArea();
        sp2 = new JScrollPane(standortTextArea);
        bildTextArea = new JTextArea();
        sp3 = new JScrollPane(bildTextArea);
        JButton knopf = new JButton("Hinzufuegen");
        c.add(lblProblem);
        c.add(sp);
        c.add(lblBaumart);
        c.add(baummenu);
        c.add(lblGebiet);
        c.add(gebietmenu);
        c.add(lblStandort);
        c.add(sp2);
        c.add(lblBild);
        c.add(sp3);
        c.add(knopf);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			try {
				String description = problemTextArea.getText();
				String baum = (String) baummenu.getSelectedItem();
				
				//this only works because the index in the Combobox is the same as the DB id 
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
