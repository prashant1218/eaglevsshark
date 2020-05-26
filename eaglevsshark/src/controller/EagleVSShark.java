package controller;

import view.ViewService;

/*Main Class defines the frame
  size of Frame
  Title of Frame
  Visiblity of Frame*/
public class EagleVSShark{
	
	public static void main(String args[]) {
		
		ViewService viewService = new ViewService();  
		viewService.setVisible(true);
		viewService.setBounds(200, 100, 1000, 735);
		viewService.setDefaultCloseOperation(viewService.EXIT_ON_CLOSE);
		viewService.setTitle("Eagle VS Shark");
		
	}

}
