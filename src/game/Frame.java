package game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import gamestates.GameState;
import gamestates.Highscores;
import gamestates.MapSelect;
import gamestates.Menu;

public class Frame extends JFrame {
	
	public GameState gameState;

	

	public Frame() {
		super("New Super Original not Arkanoid game");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		gameState = new Menu();
		add(gameState);
		setSize(800, 1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void run() {
		final double fps = 60.0;
		double frequency = 1000 / fps;
		while (true) {
			long timePreUpdate = System.currentTimeMillis();
			update();
			long UpdateTime = System.currentTimeMillis() - timePreUpdate;

			try {
				Thread.sleep((long) Math.max(frequency - UpdateTime, 0));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		gameState.requestFocus(true);
		gameState.update();
		
		

		GameState newState = gameState.changeState();

		if (newState != null) {
			remove(gameState);

			gameState = newState;
			add(gameState);
			revalidate();

		}
		repaint();
	}

}
