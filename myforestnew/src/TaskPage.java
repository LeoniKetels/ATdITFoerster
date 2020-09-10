import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 * 
 * @author Gruppe 1
 * Container to display Tasks in a table
 */
public class TaskPage extends Container{
	
	JFrame parentFrame;
	JPanel menuBar, panelMiddle;
	JTable table;
	JScrollPane scrollpane;
	
	public TaskPage(JFrame parentFrame) {
		List<Problem> data = new ArrayList<Problem>();
		try {
		DBConnection dbConnection = new DBConnection();
		data = dbConnection.getProblemsInProgress();
		dbConnection.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (!data.isEmpty()) {
			table = new JTable();
			ProblemTableModel tableModel = new ProblemTableModel(data);
			table.setModel(tableModel);
			table.setSize(200,200);
			
			scrollpane = new JScrollPane(table);
			panelMiddle = new JPanel();
			panelMiddle.add(scrollpane);
			
	        
		}else {
        panelMiddle = new JPanel();
		JLabel warnung = new JLabel("Keine Aufgaben in Bearbeitung");
		panelMiddle.add(warnung);
		}
		
		this.parentFrame = parentFrame;
		setLayout(new BorderLayout());
		
        menuBar = new MenuBar(parentFrame);
        
        add(menuBar, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        setVisible(true);
	}
	
	}
