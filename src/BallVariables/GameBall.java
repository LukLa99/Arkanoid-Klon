package ballVariables;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import BlockVariables.Block;
import game.*;

@SuppressWarnings("serial")
public abstract class GameBall extends Ball {
	
	
	protected boolean lossFlag = false;
	
	

	public GameBall(int x, int y) {
		this.x = x;
		this.y = y;
		size = 30;
		speed = 3;
		vectorX = 1;
		vectorY = 1;
		
	}

	

	public void update(ArrayList<Block> blocks, Player p) {
		if (y > lowerBound) {
			lossFlag = true;
			
		}
		
		super.update();
		
		
		Rectangle ballHitbox = new Rectangle(x - (size / 2), y - (size / 2), size, size);
		
		for (Block b : blocks) {
			if (b.intersects(ballHitbox)) {
				blocks.remove(intersect(b));

			}
		}
		
		
		if (getHitbox().intersects(p.getHitbox())) {
			System.out.println("PADDLE	");
			reverseY();
			while (getHitbox().intersects(p.getHitbox())) {
				
				moveXY();

			}

		}
		
		
	}
	
	protected abstract Block intersect(Block b);
	



	public Rectangle getHitbox() {

		return new Rectangle(x - (size / 2), y - (size / 2), size, size);
	}
	
	public boolean getLoss() {
		return lossFlag;
		
		/*
		 * i | ii
		 * ii|i_ 
		 * 
		 */
	}

}
