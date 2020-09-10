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
public class ProblemPage extends Container{
	
	JFrame parentFrame;
	JPanel menuBar, panelMiddle;
	JTable table;
	JScrollPane scrollpane;
	JButton btnAdd;
	
	public ProblemPage(JFrame parentFrame) {
		List<Problem> data = new ArrayList<Problem>();
		try {
		DBConnection dbConnection = new DBConnection();
		data = dbConnection.getAllProblems();
		dbConnection.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ButtonListener());
		
		table = new JTable();
		ProblemTableModel tableModel = new ProblemTableModel(data);
		table.setModel(tableModel);
		table.setSize(200,200);
		
		scrollpane = new JScrollPane(table);
		panelMiddle = new JPanel();
		panelMiddle.add(btnAdd);
		panelMiddle.add(scrollpane);
		this.parentFrame = parentFrame;
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
	        fenster.setTitle("Problem");
	        fenster.setSize(500, 300);
	        fenster.setVisible(true);
	        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
	}
}
