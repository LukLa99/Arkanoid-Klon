package game;

import java.awt.*;

public class Player {
	

	private boolean left, right;
	private boolean playing = false;
	
	private int x, y;

	private static int b = 300;
	private static int h = 20;
	

	public Player(int x, int y) {

		this.x = x;
		this.y = y;
	}
	
	public void update() {

		if (left) {
			if (x > 100) {
				System.out.println("Left");
				x -= 15;
			} else {
				System.out.println("Edge");
			}

		} else if (right)
			if (x < 700) {
				x += 15;
				System.out.println("Right");
			}
	}



	public void drawPlayer(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(x - (b / 2), y - (h / 2), b, h);

	}

	



	public boolean isPlaying() {

		return playing;
	}



	public void setLeft(boolean a) {
		left = a;
	}

	public void setRight(boolean b) {
		right = b;
	}
	
	public Rectangle getRightHitbox() {
		

		
		return new Rectangle(x - (b / 2), y - (h / 2), b, h);
		//Nollpunkten är X, X ska utgå från mitten och framåt.
	}

	public Rectangle getLeftHitbox() {
		

		//Utgå  ifrån nollpunkten
		return new Rectangle(x - (b / 2), y - (h / 2), b, h);
		
	}
	
}
