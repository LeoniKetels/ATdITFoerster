package main;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChangeStatusForm extends JFrame{
	private JFrame frame = this;
	JLabel labelCurrentStatus;
	
	public ChangeStatusForm(Problem problem) {
		String statusDescription = "";
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,1));
		DBConnection dbConnection;
		try {
			dbConnection = new DBConnection();
			int status = problem.getStatus_id();
	        statusDescription = dbConnection.getStatusById(status).getDescription();
			
		} catch (Exception e) {
			e.printStackTrace();
			new ErrorFrame("Es gab einen Fehler bei der Datenbankverbindung.","Prüfen Sie, ob Sie alle Schritte zur erfolgreichen Datenbankverbindung durchgeführt haben.");
		}
		
		labelCurrentStatus = new JLabel("jetziger Status: " + statusDescription);
		
		String[] status = {"Offen", "in Bearbeitung","Bearbeitet", "in Warteschlange"};
		JComboBox<String> statusMenu = new JComboBox<String>(status);
		
		JButton save = new JButton("Änderungen speichern");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if((statusMenu.getSelectedIndex() +1) != problem.getStatus_id()) {
					int index = statusMenu.getSelectedIndex();
					int statusId = index +1; 
					try {
						DBConnection dbConnection = new DBConnection();
						dbConnection.changeStatus(problem.getId(),statusId );
					} catch (Exception e2) {
						e2.printStackTrace();
						new ErrorFrame("Es gab einen Fehler bei der Datenbankverbindung.","Prüfen Sie, ob Sie alle Schritte zur erfolgreichen Datenbankverbindung durchgeführt haben.");
						}	
				}
				frame.dispose();
			}
		});
		
		c.add(labelCurrentStatus);
		c.add(statusMenu);
		c.add(save);
		
		
		
	
	}
}
