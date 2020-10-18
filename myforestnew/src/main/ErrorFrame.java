package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorFrame extends JFrame {
	
	public ErrorFrame(String errorText, String solutionRecommendation) {
		JOptionPane.showMessageDialog(this, errorText +"\n" + solutionRecommendation, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
