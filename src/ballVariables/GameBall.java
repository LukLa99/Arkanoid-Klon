package ballVariables;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import blockVariables.Block;
import game.*;

@SuppressWarnings("serial")
public abstract class GameBall extends Ball {
	
	
	protected boolean lossFlag = false;
	public int normalspeed = 10;
	public int slowspeed = 5;

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
	
			System.out.println("PADDLE	RIGHT");
	
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
		
		

	
	protected abstract Block intersect(Block b);
	



	public Rectangle getHitbox() {

		return new Rectangle(x - (size / 2), y - (size / 2), size, size);
		
	}
	
	public boolean getLoss() {
		return lossFlag;
	
	}

}
