package Variables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import BallVariables.*;
import BlockVariables.Block;

public class Player {
	public ArrayList<Ball> balls = new ArrayList<Ball>();

	private boolean left, right;
	private boolean playing = false;
	private int vectorX, vectorY;
	private int x, y;
	private int LocY;
	private int LocX;
	private static int b = 300;
	private static int h = 20;
	RegularBall regball = new RegularBall(LocX, LocX);
	public Player(int x, int y) {
		this.vectorX = 1;
		this.vectorY = 1;
		this.x = x;
		this.y = y;
		this.LocY = 400;
		this.LocX = 400;
	}

	public boolean update() {
		if (playing == true) {

			MoveXY();

			if (new Rectangle(LocX, LocY, 30, 30).intersects(new Rectangle(x - (b/2), y - (h / 2), b, h))) {
				System.out.println("PADDLE	");
				ReverseY();
				while (new Rectangle(LocX, LocY, 50, 50).intersects(new Rectangle(x - (b / 2), y - (h / 2), b, h))) {
					System.out.println(vectorY);
					MoveXY();

				}

			}
			if (LocX < 0) {
				System.out.println("CollisionE");
				ReverseX();
				while (LocX < 0) {
					MoveXY();

				}
			}
			if (LocY < 0) {
				System.out.println("CollisionF");
				ReverseY();
				while (LocY < 0) {
					MoveXY();

				}
			}

			if (LocY > 1200) {
				System.out.println("Ending Game");
				return false;
			}

			if (LocX > 800) {
				System.out.println("");
				ReverseX();
				while (LocX < 800) {
					MoveXY();

				}
			}
			if (left)  {
				if (x > 0) {
					System.out.println("Left");
					x -= 15;
				}
				else {
					System.out.println("Edge");
				}

			} else if (right)
				if (x < 800) {
				x += 15;
				System.out.println("Right");
			}

		}
		return true;
	}

	public void drawBall(Graphics g) {

		g.drawOval(LocX, LocY,20,20);
			

		}
		
		

	

	public void drawPlayer(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(x - (b/2), y - (h / 2), b, h);

	}

	public void MoveXY() {

		LocX += 5 * vectorX;
		LocY += 5 * vectorY;
	}

	public void ReverseY() {
		vectorY *= -1;
	}

	public void ReverseX() {
		vectorX *= -1;
	}

	public int getVectorX() {
		return vectorX;
	}

	public int getVectorY() {
		return vectorY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLocY() {
		return LocY;
	}

	public int getLocX() {
		return LocX;
	}

	public boolean isPlaying() {

		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void setLeft(boolean a) {
		left = a;
	}

	public void setRight(boolean b) {
		right = b;
	}
}
