package main;
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
public class AddProblemForm extends JFrame {
	private JScrollPane sp, sp2, sp3;
	private JComboBox<String> baummenu;
	private JComboBox<Integer> gebietmenu;
	private JTextArea standortTextArea, bildTextArea, problemTextArea;
	private JLabel lblProblem, lblBaumart, lblStandort, lblBild, lblGebiet;
	private JFrame frame = this;

	public AddProblemForm() {
		Container c = getContentPane();
        c.setLayout(new GridLayout(10, 1));
        String[] namen = new String []
                {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
        Integer[] gebiet = new Integer []
                {1,2,3,4,5,6,7,8,9};
        lblProblem = new JLabel("Problembeschreibung:");
        lblBaumart = new JLabel("Baumart:");
        lblGebiet = new JLabel("Gebiet:");
        lblStandort = new JLabel("Standortkoordinaten:");
        lblBild = new JLabel("Bild:");
        problemTextArea = new JTextArea();
        problemTextArea.setLineWrap(true);
        sp = new JScrollPane(problemTextArea);
        baummenu = new JComboBox<String>(namen);
        gebietmenu = new JComboBox<Integer>(gebiet);
        standortTextArea = new JTextArea();
        sp2 = new JScrollPane(standortTextArea);
        bildTextArea = new JTextArea();
        sp3 = new JScrollPane(bildTextArea);
        JButton knopf = new JButton("Hinzufuegen");
        knopf.addActionListener(new ButtonListener());
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
				
				int area = (int) gebietmenu.getSelectedItem();
 
				DBConnection dbConnection = new DBConnection();
				dbConnection.insertProblem(new Problem(0, description, area, 4, baum));
				
				frame.dispose();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
