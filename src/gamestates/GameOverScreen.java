package gamestates;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOverScreen extends GameState {

	private BufferedImage bg;
	public GameOverScreen() {
		try {
			bg = ImageIO.read(new File("src/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameState changeState() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null, null);
	}
}
