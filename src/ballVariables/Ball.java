package ballVariables;

import java.awt.Graphics;

public abstract class Ball {
	protected static final int upperBound = 0;
	protected static final int lowerBound = 1000;
	protected static final int leftBound = 0;
	protected static final int rightBound = 800;
	
	protected int x;
	protected int y;
	protected int size;
	protected int vectorX;
	protected int vectorY;
	protected int speed;
	
	public void draw(Graphics g) {
		g.fillOval(x - (size / 2), y - (size / 2), size, size);

	}

	public void moveXY() {
		x += speed * vectorX;
		y += speed * vectorY;
	}

	public int getSpeed() {
		return speed;
	}

	public void reverseY() {
		vectorY *= -1;
	}

	public void reverseX() {
		vectorX *= -1;
	}

	public int getVectorX() {
		return vectorX;
	}

	public int getVectorY() {
		return vectorY;
	}
	
	public void update() {
		moveXY();
		if (x < upperBound) {
			
			reverseX();
			while (x < upperBound) {
				moveXY();

			}
		}
		if (y < leftBound) {
			
			reverseY();
			while (y < leftBound) {
				moveXY();

			}
		}

		if (y > lowerBound) {
			reverseY();
			while (y < lowerBound) {
				moveXY();

			}
			
		}

		if (x > rightBound) {
			
			reverseX();
			while (x < rightBound) {
				moveXY();

			}
		}
	}
	
	
	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public int getSize() {

		return size;
	}
}
