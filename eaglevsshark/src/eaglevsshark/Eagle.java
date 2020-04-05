package eaglevsshark;

public class Eagle implements Player {


	@Override
	public int getMovement(String piece, int numberOnDice) {
		
		if(numberOnDice == 1) {
			if(piece.equalsIgnoreCase("E1")) {
				return 1;
			}
			
			else if(piece.equalsIgnoreCase("E2")) {
				return 2;
			}
			
			else if(piece.equalsIgnoreCase("E3")) {
				return 3;
			}
		}
		else if(numberOnDice == 0) {
			if(piece.equalsIgnoreCase("E1")) {
				return -1;
			}
			
			else if(piece.equalsIgnoreCase("E2")) {
				return -2;
			}
			
			else if(piece.equalsIgnoreCase("E3")) {
				return -3;
			}
		}
		return 0;
	}

}
