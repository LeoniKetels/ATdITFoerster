import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ProblemPage extends Container{
	
	JFrame parentFrame;
	JPanel menuBar, panelMiddle;
	JTable table;
	JScrollPane scrollpane;
	
	public ProblemPage(JFrame parentFrame) {
		List<Problem> data = new ArrayList<Problem>();
		try {
		DBConnection dbConnection = new DBConnection();
		data = dbConnection.getAllProblems();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		ProblemTableModel tableModel = new ProblemTableModel(data);
		table.setModel(tableModel);
		
		scrollpane = new JScrollPane(table);
		
		this.parentFrame = parentFrame;
		setLayout(new BorderLayout());
		
        menuBar = new MenuBar(parentFrame);
        
        add(menuBar, BorderLayout.NORTH);
        add(scrollpane, BorderLayout.CENTER);
        setVisible(true);

		
	}
	
}
