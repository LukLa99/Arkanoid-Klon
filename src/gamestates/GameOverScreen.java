package gamestates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOverScreen extends GameState {

	private BufferedImage bg;
	int points;
	public GameOverScreen(int points) {
		this.points = points;
		try {
			bg = ImageIO.read(new File("src/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Highscores.submitHighscore(points);
	}
	@Override
	public void update() {
		
		
	}

	@Override
	public GameState changeState() {
		
		return null;
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null, null);
	}
}
