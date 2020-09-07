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

import javax.swing.JTextField;


public class ProblemForm extends JFrame  {

    public JTextArea ProblemFeld;

    public JScrollPane sp;

    public JComboBox<String> Baummenu;

    public JTextArea Standortfeld;

    public JScrollPane sp2;

    public JTextArea BildFeld;

    public JScrollPane sp3;
    
    public JLabel problem, baumart, standort;
    
    public JFrame frame = this;


    public ProblemForm() {

        Container c = getContentPane();

        c.setLayout(new GridLayout(10, 1));

        String[] namen =new String []

        {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
 

        problem  = new JLabel("Problembeschreibung:");

        baumart = new JLabel("Baumart:");

        standort = new JLabel("Standortkoordinaten:");

        JLabel Bild = new JLabel("Bild:");


        ProblemFeld = new JTextArea();

        ProblemFeld.setLineWrap(true);

        sp = new JScrollPane(ProblemFeld);

        Baummenu = new JComboBox<String>(namen);

        Standortfeld = new JTextArea();

        sp2 = new JScrollPane(Standortfeld);

        BildFeld = new JTextArea();

        sp3 = new JScrollPane(BildFeld);
 

        JButton knopf = new JButton("Hinzufügen");
        knopf.addActionListener(new ButtonListener());

        c.add(problem);
        c.add(sp);
        c.add(baumart);
        c.add(Baummenu);
        c.add(standort);
        c.add(sp2);
        c.add(Bild);
        c.add(sp3);
        c.add(knopf);
    }
    
    class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			try {
				String description = ProblemFeld.getText();
				String baum = (String) Baummenu.getSelectedItem();
				
				DBConnection dbConnection = new DBConnection();
				dbConnection.insertProblem(new Problem(description,1, 1, baum ));
				dbConnection.close();
				
				frame.dispose();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
    
    


}