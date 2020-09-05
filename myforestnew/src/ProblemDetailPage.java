import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;


 


 

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;


 

public class ProblemDetailPage extends JFrame  {


 

    public JTextArea ProblemFeld;

    public JScrollPane sp;

    public JTextArea Baummenu;

    public JTextArea Standortfeld;

    public JScrollPane sp2;

    public JTextArea BildFeld;

    public JScrollPane sp3;

    


 

    public ProblemDetailPage() {

        Container c = getContentPane();

        c.setLayout(new GridLayout(10, 1));

        String[] namen =new String []

        {"Eiche", "Buche", "Tanne", "Ahorn", "Kastanie"};
 

        JLabel Problem = new JLabel("Problembeschreibung:");

        JLabel Baumart = new JLabel("Baumart:");

        JLabel Standort = new JLabel("Standortkoordinaten:");

        JLabel Bild = new JLabel("Bild:");


        ProblemFeld = new JTextArea();

        ProblemFeld.setLineWrap(true);

        sp = new JScrollPane(ProblemFeld);

        JComboBox Baummenu = new JComboBox(namen);

        Standortfeld = new JTextArea();

        sp2 = new JScrollPane(Standortfeld);

        BildFeld = new JTextArea();

        sp3 = new JScrollPane(BildFeld);
 

        JButton knopf = new JButton("Hinzufügen");
   

        c.add(Problem);

        c.add(sp);

        c.add(Baumart);

        c.add(Baummenu);

        c.add(Standort);

        c.add(sp2);

        c.add(Bild);

        c.add(sp3);

        c.add(knopf);
    }


 

    public static void main(String[] args) {

        ProblemDetailPage fenster = new ProblemDetailPage();

        fenster.setTitle("Problem");

        fenster.setSize(500, 300);

        fenster.setVisible(true);

        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}