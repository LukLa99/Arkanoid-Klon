package ballVariables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import blockVariables.Block;
import game.*;

@SuppressWarnings("serial")
public class GameBall extends Ball {
	
	
	protected boolean lossFlag = false;
	private static int normalspeed = 10;
	private static int slowspeed = 5;
	private boolean superball = false;
	private int points = 0;
	

	public GameBall(int x, int y) {
		this.x = x;
		this.y = y;
		size = 30;
		speed = normalspeed;
		vectorX = 1;
		vectorY = 1;
		
	}


	public void update(ArrayList<Block> blocks, Player p) {
		if (y > lowerBound) {
			lossFlag = true;
			
		}
		
		super.update();
		
		
		Rectangle ballHitbox = new Rectangle(x - (size / 2), y - (size / 2), size, size);
		
	
		ArrayList<Block> toRemove = new ArrayList<Block>();
		for (Block b : blocks) {
		            if (b.intersects(ballHitbox)) {
		                toRemove.add(intersect(b));

		            }
		        }
		for (Block b : toRemove) {
		  blocks.remove(b);
		}
		
		
		if (getHitbox().intersects(p.getRightHitbox())) {
	
			System.out.println("PADDLE RIGHT");
	
			reverseY();
		
			while (getHitbox().intersects(p.getRightHitbox())) {
				
				moveXY();

			}
			

		}
		else if (getHitbox().intersects(p.getLeftHitbox())) {
			System.out.println("PADDLE	LEFT");
			reverseX();
			reverseY();
			while (getHitbox().intersects(p.getLeftHitbox())) {
				
				

			}
		}

		}
		
		

	
	protected Block intersect(Block b) {
		b.addScore();
		Rectangle ballHitbox = getHitbox();
		Rectangle upper = new Rectangle(b.x, b.y, b.width, 1);
		Rectangle lower = new Rectangle(b.x, (b.y + b.height - 1), b.width, 1);
		Rectangle left = new Rectangle(b.x, b.y, 1, b.height);
		Rectangle right = new Rectangle((b.x + b.width - 1), b.y, 1, b.height);

		Block toRemove = null;
		if (ballHitbox.intersects(left) && getVectorX() > 0) {
			if (!superball) {
				reverseX();
			}
			toRemove = b;
			
		}
		if (ballHitbox.intersects(right) && getVectorX() < 0) {
			if (!superball) {
				reverseX();
			}
			toRemove = b;
		}
		if (ballHitbox.intersects(lower) && getVectorY() < 0) {
			if (!superball) {
				reverseY();
			}
			toRemove = b;
		}
		if (ballHitbox.intersects(upper) && getVectorY() > 0) {
			if (!superball) {
				reverseY();
			}
			toRemove = b;
		}
		System.out.println(b.getScoretotal());
		points++;
		return toRemove;
		
	}
	@Override
	public void draw(Graphics g) {
		if (superball) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.BLACK);
		}
		g.fillOval(x - (size / 2), y - (size / 2), size, size);
		

	}



	public Rectangle getHitbox() {

		return new Rectangle(x - (size / 2), y - (size / 2), size, size);
		
	}
	
	public boolean getLoss() {
		return lossFlag;
	
	}
	
	public int getpoints() {
		return points;
	}
	
	public void gofast() {
		speed = normalspeed;
	}
	public void goslow() {
		speed = slowspeed;
	}
	public void makesuper() {
		superball = true;
	}
	//kolla lukas wowowow
	//ANVÄND

}
