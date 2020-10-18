package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * 
 * @author Gruppe 1 
 * Container to display Problems in a table 
 *
 */

//will be extended so one can click a button to set the status to in progress

public class ProblemPage extends Container{
	
	private JFrame parentFrame;
	private JPanel panelMiddle;
	private MenuBar menuBar;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnAdd, refreshButton;
	List<Problem> problems; 
	List<Area> areas; 
	List<Status> statuses; 
	DBConnection dbConnection;
	
	
	public ProblemPage(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		
		if(problems == null) {
			getData();
		}
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ButtonListener());
		
		refreshButton = new JButton("refresh");
		refreshButton.addActionListener(new NavButtonListener(parentFrame, NavButtonListener.PROBLEM_PAGE));
		
		table = new JTable();
		ProblemTableModel tableModel = new ProblemTableModel(problems, areas, statuses);
		table.setModel(tableModel);
		table.setSize(200,200);
		
		scrollpane = new JScrollPane(table);
		panelMiddle = new JPanel();
		panelMiddle.add(btnAdd);
		panelMiddle.add(refreshButton);
		panelMiddle.add(scrollpane);
		setLayout(new BorderLayout());
		
        menuBar = new MenuBar(parentFrame);
        
        add(menuBar, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        setVisible(true);
	}
	private void getData(){
			try {
			dbConnection = new DBConnection();
			problems = dbConnection.getAllProblems();
			areas = dbConnection.getAllAreas();
			statuses = dbConnection.getAllStatuses();
			
			}catch(Exception e) {
				new ErrorFrame("Es gab einen Fehler bei der Datenbankverbindung.","Prüfen Sie, ob Sie alle Schritte zur erfolgreichen Datenbankverbindung durchgeführt haben.");
				  }
	 }
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ProblemForm fenster = new ProblemForm();
	        fenster.setTitle("Problem hinzufügen");
	        fenster.setSize(500, 300);
	        fenster.setVisible(true);
		}
		
	}

}
