package model;

/*contains Dice Functionality*/
public class Dice {
	
	/*random function 
	implemented for rollingdice*/
	
	public int rollDice() {
		int random = (int) Math.round(Math.random()+1);
		return random;
		
	}

}
