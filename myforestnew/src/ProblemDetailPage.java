import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * 
 * @author Gruppe 1 
 * 
 * Container to display one Problem 
 *
 */
public class ProblemDetailPage extends Container{
	
	JFrame parentFrame;
	JPanel menuBar, panelMiddle;
	JTable table;
	JButton btnChangeStatus;
	JComboBox<String> cboxStatuses;
	List<Status> statuses;
	
	
	public ProblemDetailPage(JFrame parentFrame, Problem problem) {
		try {
			DBConnection dbConnection = new DBConnection();
			 statuses = dbConnection.getAllStatuses();
			 dbConnection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String[] statusDescriptions = new String[statuses.size()]; 
		int i = 0;
		for(Status status : statuses) {
			statusDescriptions[i] = status.getDescription(); 
			i++;
		}
		
		cboxStatuses = new JComboBox<String>(statusDescriptions);
		btnChangeStatus = new JButton("Change Status");
		
        menuBar = new MenuBar(parentFrame);
        
        add(menuBar, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        setVisible(true);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cboxStatuses.getSelectedItem();
			
			
		}
		
	}
}
