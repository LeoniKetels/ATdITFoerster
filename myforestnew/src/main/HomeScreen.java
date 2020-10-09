package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.FlowLayout;

import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Gruppe 1
 * Container to display HomeScreen or loading page 
 *
 */
public class HomeScreen extends Container {
	private JButton start;
	private JLabel lab;
	private JPanel panel1, panel2;
	private JFrame parentFrame;
	
	public HomeScreen (JFrame parentFrame) {
	this.parentFrame = parentFrame;
	setLayout(new BorderLayout());
	panel1 = new JPanel();
	panel2 = new JPanel();
	URL url = HomeScreen.class.getResource("../resources/HomeImage.png");           
	ImageIcon bild = new ImageIcon(url);
	lab = new JLabel (bild);
	start = new JButton("Start");
	start.addActionListener(new NavButtonListener(parentFrame, NavButtonListener.MAIN_MENU ));
	panel1.add(lab);
	panel2.add(start);
	setBackground(Color.white);
	add(panel1, BorderLayout.NORTH);
	add(panel2, BorderLayout.SOUTH);
	
	}
}
