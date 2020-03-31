package blockVariables;

import java.awt.Color;

import ballVariables.GameBall;

public class PersistantBlock extends Block{


	boolean ballCollision = false;
	 
	public PersistantBlock(int x, int y, int w, int h, GameBall ball) {
		super(x, y, w, h,25, ball);
		setColor(Color.pink);

	
	}
	
	@Override
	public void getPowerup() {

		
	}

}
