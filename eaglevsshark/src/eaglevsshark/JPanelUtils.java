package eaglevsshark;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelUtils extends JPanel {

	private ImageIcon image1, image2, startImageIcon,aboutusImageIcon , resetImageIcon,eagleImageIcon,sharkImageIcon;
	private ImageIcon rollingDiceImageIcon,diceIamgeIcon;
	private Image board, evs, startImage,eagleImage,sharkImage,rollingDiceImage,diceImage;
	private Player player;

	private JButton aboutUsButton, rollDiceButton, resetButton;
	
	private JTextField tx1,tx2,tx3;

	public JPanelUtils() {
		setBackground(Color.BLACK);
		image1 = new ImageIcon(getClass().getResource("/Images/Board.gif"));
		board = image1.getImage();

		image2 = new ImageIcon(getClass().getResource("/Images/eagle-vs-shark.png"));
		evs = image2.getImage();

		startImageIcon = new ImageIcon(getClass().getResource("/Images/start.jpeg"));
		startImage = startImageIcon.getImage();
		
		aboutusImageIcon = new ImageIcon(getClass().getResource("/Images/about.jpeg"));
		
		resetImageIcon = new ImageIcon(getClass().getResource("/Images/reset.jpeg"));
		
//		eagleImageIcon = new ImageIcon(getClass().getResource("/eagle.jpeg"));
//		eagleImage = eagleImageIcon.getImage();
//		
//		sharkImageIcon = new ImageIcon(getClass().getResource("/shark.jpeg"));
//		sharkImage = sharkImageIcon.getImage();
		
		rollingDiceImageIcon = new ImageIcon(getClass().getResource("/Images/Dice.gif"));
		rollingDiceImage = rollingDiceImageIcon.getImage();
		
//		diceIamgeIcon = new ImageIcon(getClass().getResource("/dice01.jpeg"));
//		diceImage = diceIamgeIcon.getImage();ss
		
		
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
		
		Font font = new Font("Bauhaus 93",Font.ITALIC,20);
		
		tx1 = new JTextField("start game");
		tx1.setBounds(50,230,168,35);
		add(tx1);
		tx1.setBackground(Color.BLACK);
		tx1.setForeground(Color.GREEN);
		tx1.setFont(font);
		
		tx2 = new JTextField("Eagle");
		tx2.setBounds(50,290,168,35);
		add(tx2);
		tx2.setBackground(Color.BLACK);
		tx2.setForeground(Color.GREEN);
		tx2.setFont(font);
		
		tx3 = new JTextField("Shark");
		tx3.setBounds(50,350,168,35);
		add(tx3);
		tx3.setBackground(Color.BLACK);
		tx3.setForeground(Color.GREEN);
		tx3.setFont(font);
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(new Color(4, 129, 255));
		graphics.fillRect(0, 0, 215, 735);
		graphics.drawImage(board, 200, 100, 700, 600, this);

		graphics.drawImage(evs, 910, 30, 100, 700, this);

		graphics.drawImage(startImage, 10, 620, 200, 80, this);
		
//		graphics.drawImage(eagleImage, 10, 280,10,35, this);
//		graphics.drawImage(sharkImage, 10, 360,10,35, this);
		
		graphics.drawImage(rollingDiceImage, 10, 420, this);
//		graphics.drawImage(diceImage, 110, 420, this);

	}

}
