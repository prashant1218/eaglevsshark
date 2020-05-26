package view;

import javax.swing.JFrame;

public class ViewService extends JFrame {
	
	JPanelUtils jpanel;
	public ViewService() {
		jpanel = new JPanelUtils();
		add(jpanel);
	}

}
