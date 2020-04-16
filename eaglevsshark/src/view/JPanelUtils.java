package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BoxDimensions;
import model.Dice;
import model.Eagle;
import model.Player;
import model.Shark;

public class JPanelUtils extends JPanel implements ActionListener {

	private ImageIcon image1, image2, startImageIcon, aboutusImageIcon, resetImageIcon, eagleImageIcon, sharkImageIcon;
	private ImageIcon rollingDiceImageIcon, diceImageIcon, startGifImageIcon;
	private Image board, evs, startImage, eagleImage, sharkImage, rollingDiceImage, diceImage;
	private int dimOfCell;
	private List<BoxDimensions> boxDimensions = new ArrayList<BoxDimensions>();
	private int sharkPosition[] = {0,0,0};
	private int eaglePosition[] = {0,0,0};

	private JButton aboutUsButton, rollDiceButton, resetButton, startButton;
	private JButton shark1, shark2, shark3;
	private JButton eagle1, eagle2, eagle3;
	private int numberOnDice;

	private int chance;

	private JTextField tx1;
	
	public JPanelUtils() {
		setBackground(Color.BLACK);
		image1 = new ImageIcon(getClass().getResource("/Images/Board.png"));
		board = image1.getImage();

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
		resetButton.addActionListener(this);

		rollDiceButton = new JButton("Roll");
		rollDiceButton.setBounds(50, 500, 100, 30);
		add(rollDiceButton);
		rollDiceButton.setForeground(Color.red);
		rollDiceButton.addActionListener(this);
		rollDiceButton.setEnabled(false);

		startButton = new JButton(startGifImageIcon);
		startButton.setBounds(40, 620, 120, 50);
		add(startButton);
		startButton.addActionListener(this);

		Font font = new Font("Bauhaus 93", Font.ITALIC, 20);

		tx1 = new JTextField("game to be started");
		tx1.setBounds(50, 230, 168, 35);
		add(tx1);
		tx1.setBackground(Color.BLACK);
		tx1.setForeground(Color.GREEN);
		tx1.setFont(font);
		
		shark1 = new JButton("S1");
		shark1.setBounds(30,290,60,35);
		add(shark1);
		shark1.addActionListener(this);
		shark1.setEnabled(false);
		
		shark2 = new JButton("S2");
		shark2.setBounds(90,290,60,35);
		add(shark2);
		shark2.addActionListener(this);
		shark2.setEnabled(false);
		
		shark3 = new JButton("S3");
		shark3.setBounds(150,290,60,35);
		add(shark3);
		shark3.addActionListener(this);
		shark3.setEnabled(false);
		
		
		eagle1 = new JButton("E1");
		eagle1.setBounds(30,370,60,35);
		add(eagle1);
		eagle1.addActionListener(this);
		eagle1.setEnabled(false);
		
		eagle2 = new JButton("E2");
		eagle2.setBounds(90,370,60,35);
		add(eagle2);
		eagle2.addActionListener(this);
		eagle2.setEnabled(false);
		
		eagle3 = new JButton("E3");
		eagle3.setBounds(150,370,60,35);
		add(eagle3);
		eagle3.addActionListener(this);
		eagle3.setEnabled(false);

		dimOfCell = (int) Math.sqrt((board.getHeight(this) * board.getWidth(this)) / 100);
		setBoxDimenstions();

	}

	private void setBoxDimenstions() {
		int xCoordinate = 240;
		int yCoordinate = board.getHeight(this);
		int boxNo = 1;

		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				BoxDimensions boxDimension = new BoxDimensions();
				if (i % 2 == 0) {
					boxDimension.setX(xCoordinate);
					boxDimension.setY(yCoordinate);
					boxDimension.setBoxNo(boxNo);
					boxDimension.setBoxDimension(dimOfCell);
					boxNo++;
					xCoordinate = xCoordinate - dimOfCell;
					boxDimensions.add(boxDimension);

				} else {
					boxDimension.setX(xCoordinate);
					boxDimension.setY(yCoordinate);
					boxDimension.setBoxNo(boxNo);
					boxDimension.setBoxDimension(dimOfCell);
					boxNo++;
					xCoordinate += dimOfCell;
					boxDimensions.add(boxDimension);

				}

			}
			if (i % 2 == 0) {
				xCoordinate = 240;
			} else {
				xCoordinate = 160 + board.getWidth(this);
			}
			yCoordinate -= dimOfCell;

		}
		System.out.println(boxDimensions.size());
		
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(new Color(4, 129, 255));
		graphics.fillRect(0, 0, 215, 735);
		graphics.drawImage(board, 220, 30, this);

		graphics.drawImage(evs, 910, 30, 100, 700, this);

		graphics.drawImage(startImage, 10, 620, 200, 80, this);

		graphics.drawImage(eagleImage, 10, 280, this);
		graphics.drawImage(sharkImage, 10, 360, this);

		graphics.drawImage(rollingDiceImage, 10, 420, this);
		graphics.drawImage(diceImage, 110, 420, this);
		
		if(!startButton.isEnabled() && chance%2==0) {
			tx1.setText("shark,s Turn");
		}
		else if(!startButton.isEnabled() && chance%2==1) {
			tx1.setText("Eagle's Turn");
		}
		
		graphics.setColor(Color.BLACK);
		for(int i=0;i<3;i++) {
			if(sharkPosition[i]>0) {
				graphics.drawImage(sharkImage, boxDimensions.get(sharkPosition[i] - 1).getX(),
						boxDimensions.get(sharkPosition[i]-1).getY() - 20, this);
				graphics.drawString("S"+(i+1), boxDimensions.get(sharkPosition[i]-1).getX(), boxDimensions.get(sharkPosition[i]-1).getY() - 22);
			}
			
			if(eaglePosition[i]>0) {
				graphics.drawImage(eagleImage, boxDimensions.get(eaglePosition[i] - 1).getX(),
						boxDimensions.get(eaglePosition[i]-1).getY() - 20, this);
				graphics.drawString("E"+(i+1), boxDimensions.get(eaglePosition[i] - 1).getX(), boxDimensions.get(eaglePosition[i]-1).getY() - 22);
			}
		}
		if(isPalyerWin()) {
			String winner = getNameOfPlayerWin();
			rollDiceButton.setEnabled(false);
			shark1.setEnabled(false);
			shark2.setEnabled(false);
			shark3.setEnabled(false);
			eagle1.setEnabled(false);
			eagle2.setEnabled(false);
			eagle3.setEnabled(false);
		    tx1.setText("winner is "+winner);
		}

	}

	private String getNameOfPlayerWin() {
		
		if (eaglePosition[0] == 100 && eaglePosition[1] == 100 && eaglePosition[2] == 100) {
			return "Eagle";
		} else if (sharkPosition[0] == 100 && sharkPosition[1] == 100 && sharkPosition[2] == 100) {
			return "Shark";
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == rollDiceButton) {
			Dice dice = new Dice();
			if (!isPalyerWin()) {
				numberOnDice = dice.rollDice();
				switch (numberOnDice) {
				case 1:
					diceImageIcon = new ImageIcon(getClass().getResource("/Images/dice1.png"));
					break;

				case 2:
					diceImageIcon = new ImageIcon(getClass().getResource("/Images/dice2.png"));
					break;
				default:
					break;
				}
				diceImage = diceImageIcon.getImage();
				if (chance % 2 == 0) {
					if (sharkPosition[0] != 100) {
						shark1.setEnabled(true);
					}
					if (sharkPosition[1] != 100) {
						shark2.setEnabled(true);
					}
					if (sharkPosition[2] != 100) {
						shark3.setEnabled(true);
					}

				} else {
					if (eaglePosition[0] != 100) {
						eagle1.setEnabled(true);
					}
					if (eaglePosition[0] != 100) {
						eagle2.setEnabled(true);
					}
					if (eaglePosition[0] != 100) {
						eagle3.setEnabled(true);
					}

				}
				rollDiceButton.setEnabled(false);

			}

		}
		if (e.getSource() == resetButton) {
			for(int i=0;i<3;i++) {
				eaglePosition[i] = 0;
				sharkPosition[i] = 0;
			}
			chance = 0;
			eagle1.setEnabled(false);
			eagle2.setEnabled(false);
			eagle3.setEnabled(false);

			shark1.setEnabled(false);
			shark2.setEnabled(false);
			shark3.setEnabled(false);

			rollDiceButton.setEnabled(false);

			startButton.setEnabled(true);
			tx1.setText("Game to Be started");

		}
		if (e.getSource() == startButton) {
			rollDiceButton.setEnabled(true);
			tx1.setText("Shark's Turn");
			startButton.setEnabled(false);
		}
		
		if(e.getSource() == shark1) {
			System.out.println("shark1");
			shark1.setEnabled(false);
			shark2.setEnabled(false);
			shark3.setEnabled(false);
			Player player = new Shark();
			int noOfMovements = player.getMovement("S1", numberOnDice);
			sharkPosition[0] = sharkPosition[0]+noOfMovements;
			if (sharkPosition[0] < 0) {
				sharkPosition[0] = 0;
			}
			if (sharkPosition[0] > 100) {
				sharkPosition[0] = 100;
			}
			if (sharkPosition[0] > 1) {
				int indexNo = player.isCapturePlayer(eaglePosition, sharkPosition[0]);
				if (indexNo != 0 && eaglePosition[indexNo] != 1) {
					eaglePosition[indexNo] = 0;
				}
			}
			
			rollDiceButton.setEnabled(true);
			chance++;
		}
		if (e.getSource() == shark2) {
			shark1.setEnabled(false);
			shark2.setEnabled(false);
			shark3.setEnabled(false);
			Player player = new Shark();
			int noOfMovements = player.getMovement("S2", numberOnDice);
			sharkPosition[1] = sharkPosition[1]+noOfMovements;
			if(sharkPosition[1]<0) {
				sharkPosition[1] = 0;
			}
			if (sharkPosition[1] > 100) {
				sharkPosition[1] = 100;
			}
			if(sharkPosition[1]>1) {
				int indexNo = player.isCapturePlayer(eaglePosition, sharkPosition[1]);
				if(indexNo!=0 && eaglePosition[indexNo]!=1) {
					eaglePosition[indexNo]=0;
				}
			}
			rollDiceButton.setEnabled(true);
			chance++;
			

		}
		if (e.getSource() == shark3) {
			shark1.setEnabled(false);
			shark2.setEnabled(false);
			shark3.setEnabled(false);
			Player player = new Shark();
			int noOfMovements = player.getMovement("S3", numberOnDice);
			sharkPosition[2] = sharkPosition[2]+noOfMovements;
			if(sharkPosition[2]<0) {
				sharkPosition[2] = 0;
			}
			if (sharkPosition[2] > 100) {
				sharkPosition[2] = 100;
			}
			if(sharkPosition[2]>1) {
				int indexNo = player.isCapturePlayer(eaglePosition, sharkPosition[2]);
				if(indexNo!=0 && eaglePosition[indexNo]!=1) {
					eaglePosition[indexNo]=0;
				}
			}
			
			rollDiceButton.setEnabled(true);
			chance++;

		}
		
		if(e.getSource() == eagle1) {
			eagle1.setEnabled(false);
			eagle2.setEnabled(false);
			eagle3.setEnabled(false);
			Player player = new Eagle();
			int noOfMovements = player.getMovement("E1", numberOnDice);
			eaglePosition[0] = eaglePosition[0]+noOfMovements;
			if(eaglePosition[0]<0) {
				eaglePosition[0] = 0;
			}
			if (eaglePosition[0] > 100) {
				eaglePosition[0] = 100;
			}
			if(eaglePosition[0]>1) {
				int indexNo = player.isCapturePlayer(sharkPosition, eaglePosition[0]);
				if(indexNo!=0 && sharkPosition[indexNo]!=1) {
					sharkPosition[indexNo]=0;
				}
			}
			rollDiceButton.setEnabled(true);
			chance++;
		}
		if (e.getSource() == eagle2) {
			eagle1.setEnabled(false);
			eagle2.setEnabled(false);
			eagle3.setEnabled(false);
			Player player = new Eagle();
			int noOfMovements = player.getMovement("E2", numberOnDice);
			eaglePosition[1] = eaglePosition[1]+noOfMovements;
			if(eaglePosition[1]<0) {
				eaglePosition[1] = 0;
			}
			if (eaglePosition[1] > 100) {
				eaglePosition[1] = 100;
			}
			if(eaglePosition[1]>1) {
				int indexNo = player.isCapturePlayer(sharkPosition, eaglePosition[1]);
				if(indexNo!=0 && sharkPosition[indexNo]!=1) {
					sharkPosition[indexNo]=0;
				}
			}
			rollDiceButton.setEnabled(true);
			chance++;
			

		}
		if (e.getSource() == eagle3) {
			eagle1.setEnabled(false);
			eagle2.setEnabled(false);
			eagle3.setEnabled(false);
			Player player = new Eagle();
			int noOfMovements = player.getMovement("E3", numberOnDice);
			eaglePosition[2] = eaglePosition[2]+noOfMovements;
			if(eaglePosition[2]<0) {
				eaglePosition[2] = 0;
			}
			if (eaglePosition[2] > 100) {
				eaglePosition[2] = 100;
			}
			if(eaglePosition[2]>1) {
				int indexNo = player.isCapturePlayer(sharkPosition, eaglePosition[2]);
				if(indexNo!=0 && sharkPosition[indexNo]!=1) {
					sharkPosition[indexNo]=0;
				}
			}
			
			rollDiceButton.setEnabled(true);
			chance++;

		}
	}

	private boolean isPalyerWin() {
		if (eaglePosition[0] == 100 && eaglePosition[1] == 100 && eaglePosition[2] == 100) {
			return true;
		} else if (sharkPosition[0] == 100 && sharkPosition[1] == 100 && sharkPosition[2] == 100) {
			return true;
		}
		return false;
	}

}
