import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class TaskPage extends Container{
	
	JFrame parentFrame;
	JPanel menuBar, panelMiddle;
	JTable table;
	JScrollPane scrollpane;
	JButton btnAdd;
	
	public TaskPage(JFrame parentFrame) {
		List<Problem> data = new ArrayList<Problem>();
		try {
		DBConnection dbConnection = new DBConnection();
		data = dbConnection.getAllProblems();
		dbConnection.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
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
	
	}
