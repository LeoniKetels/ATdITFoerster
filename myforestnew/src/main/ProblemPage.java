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
	private JButton btnAdd;
	List<Problem> problems; 
	List<Area> areas; 
	List<Status> statuses; 
	
	
	public ProblemPage(JFrame parentFrame, List<Problem> problems,List<Area> areas, List<Status> statuses ) {
		this.parentFrame = parentFrame;
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ButtonListener());
		
		table = new JTable();
		ProblemTableModel tableModel = new ProblemTableModel(problems, areas, statuses);
		table.setModel(tableModel);
		table.setSize(200,200);
		
		scrollpane = new JScrollPane(table);
		panelMiddle = new JPanel();
		panelMiddle.add(btnAdd);
		panelMiddle.add(scrollpane);
		setLayout(new BorderLayout());
		
        menuBar = new MenuBar(parentFrame);
        
        add(menuBar, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        setVisible(true);
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
