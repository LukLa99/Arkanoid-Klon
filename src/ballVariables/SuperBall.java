package ballVariables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import blockVariables.Block;

public class SuperBall extends GameBall {
	public SuperBall(int x, int y) {
		super(50, 50);
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.yellow);
		super.draw(g);
	}

	@Override
	protected Block intersect(Block b) {
		Rectangle ballHitbox = getHitbox();
		Rectangle upper = new Rectangle(b.x, b.y, b.width, 1);
		Rectangle lower = new Rectangle(b.x, (b.y + b.height - 1), b.width, 1);
		Rectangle left = new Rectangle(b.x, b.y, 1, b.height);
		Rectangle right = new Rectangle((b.x + b.width - 1), b.y, 1, b.height);

		Block toRemove = null;
		if (ballHitbox.intersects(left) && getVectorX() > 0) {
			
			toRemove = b;
		}
		if (ballHitbox.intersects(right) && getVectorX() < 0) {
			
			toRemove = b;
		}
		if (ballHitbox.intersects(lower) && getVectorY() < 0) {
			
			toRemove = b;
		}
		if (ballHitbox.intersects(upper) && getVectorY() > 0) {
			
			toRemove = b;
		}

		return toRemove;
	}

}
