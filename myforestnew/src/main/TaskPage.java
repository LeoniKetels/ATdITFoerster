import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


/**
 * 
 * @author Gruppe 1
 * Container to display Tasks in a table
 */

//will be extended so one can click a button to set the status to completed
public class TaskPage extends Container{
	
	private JFrame parentFrame;
	private JPanel  panelMiddle;
	private MenuBar menuBar;
	private JTable table;
	private JScrollPane scrollpane;
	
	public TaskPage(JFrame parentFrame, List<Problem> dataProblems, List<Area> areas, List<Status>status) {
		
		
		if (!dataProblems.isEmpty()) {
			table = new JTable();
			ProblemTableModel tableModel = new ProblemTableModel(dataProblems, areas, status);
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
