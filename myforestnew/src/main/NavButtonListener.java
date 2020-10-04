package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
/**
 * This is a generic ActionListener for Navigation between different pages of the project
 * @author Gruppe 1
 *
 */


public class NavButtonListener implements ActionListener {
	
	String destinationPage;
	JFrame frame;
	DBConnection dbConnection;
	public static final String MAIN_MENU = "main";
	public static final String CHAT_PAGE = "chat";
	public static final String SHOP_PAGE = "shop";
	public static final String TASK_PAGE  = "task";
	public static final String PROBLEM_PAGE  = "problem";
	List<Problem> dataProblems, dataProblemsInProgress;
	List<Area> dataAreas;
	List<Status> dataStatus;
	
	
	 public NavButtonListener(JFrame frame, String destinationPage) {
		 this.destinationPage = destinationPage;
		 this.frame = frame;
		 dataProblems = new ArrayList<Problem>();
		 dataAreas = new ArrayList<Area>();
		 dataStatus = new ArrayList<Status>();
			try {
			dbConnection = new DBConnection();
			dataProblems = dbConnection.getAllProblems();
			dataAreas = dbConnection.getAllAreas();
			dataStatus = dbConnection.getAllStatuses();
			dataProblemsInProgress = dbConnection.getProblemsInProgress();
			dbConnection.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		 }
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(destinationPage) {
		case(MAIN_MENU):
			frame.setContentPane(new MainMenu(frame));
			break;
		case(CHAT_PAGE):
			frame.setContentPane(new ChatPage(frame));
			break;
		case(SHOP_PAGE):
			frame.setContentPane(new ShopPage(frame));
			break;
		case(PROBLEM_PAGE):
			frame.setContentPane(new ProblemPage(frame, dataProblems, dataAreas, dataStatus));
			break;
		case(TASK_PAGE):
			frame.setContentPane(new TaskPage(frame, dataProblemsInProgress, dataAreas, dataStatus));
			break;
		}
		frame.setVisible(true);
	}

}
