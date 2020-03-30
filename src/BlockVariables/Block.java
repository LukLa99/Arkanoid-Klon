package BlockVariables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.*;

public abstract class Block extends Rectangle {

	private Color color;
	public int score;
	public int scoretotal;
	public int getScoretotal() {
		return scoretotal;
	}

	Player player;
	
	
	public Block(int x, int y, int w, int h, int score) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.score = 0;
	
	}

	
	
	
	public void addScore() {
		scoretotal = scoretotal + score;
	}



	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



/*
	private void Collisions() {
		Rectangle ballHitbox = new Rectangle(player.getLocX(), player.getLocY(), 15, 15);
		Rectangle upper;
		Rectangle lower;
		Rectangle left;
		Rectangle right;
		Block tempBlock = null;
		for (Block b : blocks) {
			if (b.intersects(ballHitbox)) {
				upper = new Rectangle(b.x, b.y, b.width, 1);
				lower = new Rectangle(b.x, (b.y + b.height - 1), b.width, 1);
				left = new Rectangle(b.x, b.y, b.height, 1);
				right = new Rectangle((b.x + b.width - 1), b.y, 1, b.height);
				if (ballHitbox.intersects(lower) || ballHitbox.intersects(upper)) {
					player.ReverseY();
					tempBlock = b;
				}
				if (ballHitbox.intersects(left) && player.getVectorX() > 0) {
					player.ReverseX();
					tempBlock = b;
				}
				if (ballHitbox.intersects(right) && player.getVectorX() < 0) {
					player.ReverseX();
					tempBlock = b;
				}
				if (ballHitbox.intersects(lower) && player.getVectorY() < 0) {
					player.ReverseY();
					tempBlock = b;
				}
				if (ballHitbox.intersects(upper) && player.getVectorY() > 0) {
					player.ReverseY();
					tempBlock = b;
				}

			}
		}
		blocks.remove(tempBlock);
	}

	*/
	

}

