package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*JpanelUtils inherits JPanel and ActionListener
 * it Contains Buttons,Images, shark and eagle's positions
 * Text Fields and list of BoxDimensions*/
public class JPanelUtils extends JPanel {

	public ImageIcon image2, startImageIcon, aboutusImageIcon, resetImageIcon, eagleImageIcon, sharkImageIcon;
	public ImageIcon rollingDiceImageIcon, diceImageIcon, startGifImageIcon;
	public Image board, evs, startImage, eagleImage, sharkImage, rollingDiceImage, diceImage;
	public JButton aboutUsButton, rollDiceButton, resetButton, startButton;
	public int numberOnDice;

	public JTextField tx1;
	public JTextField boardDimensionTextField;
	public JTextField getNumberOfPiecesTextField;
	public List<Integer> sharkObstacles;
	public List<Integer> eaglesObstacles;

	public JPanelUtils() {
		setBackground(Color.BLACK);

		image2 = new ImageIcon(getClass().getResource("/Images/eagle-vs-shark.png"));
		evs = image2.getImage();

		startGifImageIcon = new ImageIcon(getClass().getResource("/Images/start.gif"));

		startImageIcon = new ImageIcon(getClass().getResource("/Images/start.jpeg"));
		startImage = startImageIcon.getImage();

		aboutusImageIcon = new ImageIcon(getClass().getResource("/Images/about.gif"));

		resetImageIcon = new ImageIcon(getClass().getResource("/Images/reset.png"));

		eagleImageIcon = new ImageIcon(getClass().getResource("/Images/Eagle.png"));
		eagleImage = eagleImageIcon.getImage();

		sharkImageIcon = new ImageIcon(getClass().getResource("/Images/Shark.png"));
		sharkImage = sharkImageIcon.getImage();

		rollingDiceImageIcon = new ImageIcon(getClass().getResource("/Images/Dice.gif"));
		rollingDiceImage = rollingDiceImageIcon.getImage();

		setLayout(null);
		aboutUsButton = new JButton(aboutusImageIcon);
		aboutUsButton.setBounds(50, 120, 100, 30);
		add(aboutUsButton);

		resetButton = new JButton(resetImageIcon);
		resetButton.setBounds(50, 180, 100, 30);
		add(resetButton);

		rollDiceButton = new JButton("Roll");
		rollDiceButton.setBounds(50, 500, 100, 30);
		add(rollDiceButton);
		rollDiceButton.setForeground(Color.red);
		rollDiceButton.setEnabled(false);

		startButton = new JButton(startGifImageIcon);
		startButton.setBounds(40, 620, 120, 50);
		add(startButton);

		Font font = new Font("Bauhaus 93", Font.ITALIC, 20);

		tx1 = new JTextField("game to be started");
		tx1.setBounds(0, 230, 215, 35);
		add(tx1);
		tx1.setBackground(Color.BLACK);
		tx1.setForeground(Color.GREEN);
		tx1.setFont(font);
		tx1.setEditable(false);

		boardDimensionTextField = new JTextField("Board Dimensions");
		boardDimensionTextField.setBounds(0, 15, 215, 35);
		add(boardDimensionTextField);
		boardDimensionTextField.setBackground(Color.BLACK);
		boardDimensionTextField.setForeground(Color.GREEN);
		boardDimensionTextField.setFont(font);
		

		getNumberOfPiecesTextField = new JTextField("No of Pieces");
		getNumberOfPiecesTextField.setBounds(0, 50, 215, 35);
		add(getNumberOfPiecesTextField);
		getNumberOfPiecesTextField.setBackground(Color.BLACK);
		getNumberOfPiecesTextField.setForeground(Color.GREEN);
		getNumberOfPiecesTextField.setFont(font);

	}

	/* Draw all Images and Checking Winner */

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(new Color(4, 129, 255));
		graphics.fillRect(0, 0, 215, 735);

		graphics.drawImage(evs, 930, 30, 100, 700, this);

		graphics.drawImage(startImage, 10, 620, 200, 80, this);

		graphics.drawImage(sharkImage, 10, 280, this);
		graphics.drawImage(eagleImage, 10, 360, this);

		graphics.drawImage(rollingDiceImage, 10, 420, this);
		graphics.drawImage(diceImage, 110, 420, this);
		String dimensionOfBoard = boardDimensionTextField.getText();
		int sizeOfBoard = 0;
		if (!dimensionOfBoard.isEmpty() && dimensionOfBoard != null) {
			try {
				sizeOfBoard = Integer.parseInt(dimensionOfBoard);
			}
			catch (Exception e) {
			}
			
		}

		if (sizeOfBoard > 4 && sizeOfBoard < 11) {
			sharkObstacles.add((int) Math.round(Math.random()* (sizeOfBoard*sizeOfBoard - sizeOfBoard + 1) + sizeOfBoard));
			int xCoordinateOfCell = 220;
			int yCoordinateOfCell = 630;
			int cellNo = 0;
			for (int row = 1; row <= sizeOfBoard; row++) {
				for (int col = 1; col <= sizeOfBoard; col++) {
					cellNo++;
					if (cellNo % 2 == 0) {
						graphics.setColor(Color.WHITE);
					} else {
						graphics.setColor(Color.RED);
					}
					graphics.fillRect(xCoordinateOfCell, yCoordinateOfCell, 70, 70);
					if (row % 2 == 0) {
						xCoordinateOfCell -= 70;
					} else {
						xCoordinateOfCell += 70;
					}

				}
				if (row % 2 == 0) {

					xCoordinateOfCell += 70;
				} else {

					xCoordinateOfCell -= 70;
				}
				yCoordinateOfCell -= 70;
			}

		}
	}
}
