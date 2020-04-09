package eaglevsshark;

public class Shark implements Player {

	@Override
	public int getMovement(String piece, int numberOnDice) {
		if (numberOnDice == 1) {
			if (piece.equalsIgnoreCase("S1")) {
				return 1;
			}

			else if (piece.equalsIgnoreCase("S2")) {
				return 2;
			}

			else if (piece.equalsIgnoreCase("S3")) {
				return 3;
			}
		} else if (numberOnDice == 2) {
			if (piece.equalsIgnoreCase("S1")) {
				return -1;
			}

			else if (piece.equalsIgnoreCase("S2")) {
				return -2;
			}

			else if (piece.equalsIgnoreCase("S3")) {
				return -3;
			}
		}
		return 0;
	}

	@Override
	public int isCapturePlayer(int position[], int positionOfPiece) {
		if (positionOfPiece != 100) {
			for (int i = 0; i < 3; i++) {
				if (position[i] == positionOfPiece) {

					return i;
				}

			}

		}
		return 0;
	}

}
