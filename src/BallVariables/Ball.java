package BallVariables;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Ball extends Rectangle {
	private int LocY;
	private int LocX;
	private int x = 20;
	private int y = 20;
	private int vectorX, vectorY;

	public Ball() {
		this.vectorX = 1;
		this.vectorY = 1;

		this.LocY = 400;
		this.LocX = 400;
	}

	public void DrawOval(Graphics g) {
		g.fillOval(LocY,LocX,x,y);
		
	}
	
	
	

}
