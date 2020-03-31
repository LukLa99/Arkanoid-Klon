package blockVariables;

import java.awt.*;

import ballVariables.GameBall;

public class BlueBlock extends Block {

	

	public BlueBlock(int x, int y, int w, int h,GameBall ball) {
		super(x, y, w, h,50, ball);
		
		setColor(new Color(50, 189, 239));
	}

	@Override
	public void getPowerup() {
		
		
	}

}


