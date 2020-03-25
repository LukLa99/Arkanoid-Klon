package BallVariables;


import Variables.*;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public abstract class Ball extends Rectangle {
	int x;
	int y;
	Player player;
	public Ball(int x, int y) {
	
			}

	public void DrawOval(Graphics g) {
		g.fillOval(player.getLocX(), player.getLocY(),10,10);
		
	}
	
	
	

}
