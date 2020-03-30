package ballVariables;

import java.awt.Rectangle;

import blockVariables.Block;

public class NormalBall extends GameBall{

	public NormalBall(int x, int y) {
		super(x, y);
		
	}

	@Override
	protected Block intersect(Block b) {
		b.addScore();
		Rectangle ballHitbox = getHitbox();
		Rectangle upper = new Rectangle(b.x, b.y, b.width, 1);
		Rectangle lower = new Rectangle(b.x, (b.y + b.height - 1), b.width, 1);
		Rectangle left = new Rectangle(b.x, b.y, 1, b.height);
		Rectangle right = new Rectangle((b.x + b.width - 1), b.y, 1, b.height);

		Block toRemove = null;
		if (ballHitbox.intersects(left) && getVectorX() > 0) {
			reverseX();
			normalspeed++;
			toRemove = b;
			
		}
		if (ballHitbox.intersects(right) && getVectorX() < 0) {
			reverseX();
			normalspeed++;
			toRemove = b;
			System.out.println(normalspeed);
		}
		if (ballHitbox.intersects(lower) && getVectorY() < 0) {
			reverseY();
			normalspeed+=5;
			toRemove = b;
		}
		if (ballHitbox.intersects(upper) && getVectorY() > 0) {
			reverseY();
			normalspeed++;
			toRemove = b;
		}
		System.out.println(b.getScoretotal());
		
		return toRemove;
		
	}
}
