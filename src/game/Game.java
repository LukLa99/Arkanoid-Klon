package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import ballVariables.GameBall;
import blockVariables.*;
import gamestates.GameOverScreen;
import gamestates.GameState;

@SuppressWarnings("serial")
public class Game extends GameState {

	private Player player;
	private GameBall ball;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private boolean playing = true;
	private boolean started = false;

	
	
	

	public Game(int bana) {

		setFocusable(true);
		setBorder(getBorder());

		setBackground(Color.GRAY);
		setSize(800, 1000);
		ball = new GameBall(500, 500);
		player = new Player(getWidth() / 2, getHeight() - 200);

		

		makeblocks(bana);
		setFocusable(true);
		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("Left");
					player.setLeft(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("Right");
					player.setRight(true);
				}
				
					
				if (started == false) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.out.println("here");
						System.out.println("Starting game!");
						started = true;
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("Released");
					player.setLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("Released");
					player.setRight(false);
				}
			}
		});

	}

	private void makeblocks(int MapSelector) {

		switch (MapSelector) {
		case 1:
			System.out.println("Classic");

			for (int i = 0; i < 12; i++) {
				blocks.add(new GreenBlock((i * (55)) + 50, 100, 50, 50));
				blocks.add(new RedBlock((i * (55)) + 50, 160, 50, 50));
				blocks.add(new BlueBlock((i * (55)) + 50, 220, 50, 50));
			}
			break;

		case 2:
			System.out.println("SVP");

			for (int i = 0; i < 12; i++) {
				blocks.add(new BlueBlock((i * (55)) + 50, 0, 50, 50));
				blocks.add(new WhiteBlock((i * (55)) + 50, 50, 50, 50));
				blocks.add(new BlueBlock((i * (55)) + 50, 100, 50, 50));
				blocks.add(new WhiteBlock((i * (55)) + 50, 150, 50, 50));
				blocks.add(new WhiteBlock((i * (55)) + 50, 250, 50, 50));
				blocks.add(new BlueBlock((i * (55)) + 50, 300, 50, 50));
			}

			break;

		case 3:
			System.out.println("Staircase");
			for (int i = 0; i < 7; i++) {
				blocks.add(new RedBlock((i * (45)) + 50, 10, 40, 40));
			}
			for (int i = 0; i < 10; i++) {
				blocks.add(new GreenBlock((i * (45)) + 50, 60, 40, 40));
			}
			for (int i = 0; i < 13; i++) {

				blocks.add(new BlueBlock((i * (45)) + 50, 110, 40, 40));
			}

			for (int i = 0; i < 16; i++) {

				blocks.add(new WhiteBlock((i * (45)) + 50, 160, 40, 40));
				blocks.add(new GreenBlock((i * (45)) + 50, 210, 40, 40));
				blocks.add(new RedBlock((i * (45)) + 50, 260, 40, 40));
				blocks.add(new BlueBlock((i * (45)) + 50, 310, 40, 40));
			}
			break;

		default:
			makeblocks(1);
		}

	}

	public void update() {

		
		
		if (started) {
			ball.update(blocks, player);
			if (ball.getLoss()) {
				playing = false;

			}
			player.update();
		}
	

		
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		ball.draw(g);
		player.drawPlayer(g);

		for (Block b : blocks) {
			b.draw(g);

		}

	}

	@Override
	public GameState changeState() {
		
		if (!playing) {
			return new GameOverScreen(ball.getpoints());
		} else {
			return null;
		}
	}
}
