package BallVariables;

import java.awt.Color;
import java.awt.Graphics;

public class SuperBall extends Ball {
	public SuperBall(int x, int y) {
		super(50, 50);
		
	}
	
	public void DrawOval(Graphics g) {
		g.fillOval(player.getLocX(),player.getLocY(),x,y);
		g.setColor(Color.yellow);
		
	}

}
