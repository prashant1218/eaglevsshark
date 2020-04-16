package controller;

import javax.swing.JFrame;

import view.JPanelUtils;

public class BoardUtils extends JFrame{
	
	JPanelUtils jpanel;
	public BoardUtils() {
	
		jpanel = new JPanelUtils();
		add(jpanel);
	}

}
