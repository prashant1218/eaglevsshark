package model;

public interface Player {

	int getMovement(String piece, int numberOnDice);

	int isCapturePlayer(int position[],int positionOfPiece);

}
