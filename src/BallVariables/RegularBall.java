package BallVariables;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class RegularBall extends Ball {

	public RegularBall(int x, int y) {
		super(20, 20);
		
	}
	
	public void DrawOval(Graphics g) {
		g.fillRect(player.getLocX(), player.getLocY(), width, height);
		g.setColor(Color.BLUE);
		
	}
	
}

