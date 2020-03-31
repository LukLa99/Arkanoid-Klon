package blockVariables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ballVariables.GameBall;
import game.*;

public abstract class Block extends Rectangle {
	GameBall ball;
	private Color color;
	public int score;
	public int scoretotal;
	public int getScoretotal() {
		return scoretotal;
	
	
	
	
	}

	Player player;
	
	public Block(int x, int y, int w, int h, int score, GameBall ball) {
		this.ball = ball;;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.score = 0;
	
	}

	
	public abstract void getPowerup();
		
		
	
	
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

