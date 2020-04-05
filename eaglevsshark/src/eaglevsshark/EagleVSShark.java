package eaglevsshark;

public class EagleVSShark {
	
	public static void main(String args[]) {
		
		BoardUtils boardUtils = new BoardUtils();
		boardUtils.setVisible(true);
		boardUtils.setBounds(200, 100, 1000, 735);
		boardUtils.setDefaultCloseOperation(boardUtils.EXIT_ON_CLOSE);
		boardUtils.setTitle("Eagle VS Shark");
	}

}
