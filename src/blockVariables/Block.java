package blockVariables;

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




	

}

