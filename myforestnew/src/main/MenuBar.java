package main;
import javax.swing.*;

import java.awt.*;
import java.net.URL;


/**
 * 
 * @author Gruppe 1
 * Menubar used for navigation between pages 
 * 
 *
 */
public class MenuBar extends JPanel {
	private JButton btnMain, btnShop, btnChat, btnProblems, btnTasks ;
	
	public MenuBar(JFrame parentFrame ) {
		setLayout(new GridLayout(1,5));
		URL url = MenuBar.class.getResource("../resources/Icon.png");
	    Icon icon = new ImageIcon(url);
	    
	    
		btnMain 		= new JButton(icon);
		btnShop 		= new JButton("Shop");
		btnChat 		= new JButton("Chat");
		btnProblems 	= new JButton("Probleme");
		btnTasks	 	= new JButton("Aufgaben");
		
		
	    btnMain.addActionListener(new NavButtonListener( parentFrame, Pages.MAIN_MENU));
	    btnShop.addActionListener(new NavButtonListener( parentFrame, Pages.SHOP_PAGE));
	    btnChat.addActionListener(new NavButtonListener( parentFrame, Pages.CHAT_PAGE));
	    btnProblems.addActionListener(new NavButtonListener( parentFrame, Pages.PROBLEM_PAGE));
	    btnTasks.addActionListener(new NavButtonListener( parentFrame, Pages.TASK_PAGE));
	    
	    btnTasks.setBackground(Color.WHITE);
	    btnMain.setBackground(Color.WHITE);
	    btnProblems.setBackground(Color.WHITE);
	    btnShop.setBackground(Color.WHITE);
	    btnChat.setBackground(Color.WHITE);
	    
	    setBackground(Color.white);
	    
	    add(btnProblems);
	    add(btnTasks);
	    add(btnMain);
	    add(btnShop);
	    add(btnChat);
	}
}
