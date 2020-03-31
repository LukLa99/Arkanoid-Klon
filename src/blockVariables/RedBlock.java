package blockVariables;
import java.awt.*;
import ballVariables.*;
import ballVariables.GameBall;

public class RedBlock extends Block {

	boolean ballCollision = false;
	 
	public RedBlock(int x, int y, int w, int h, GameBall ball) {
		super(x, y, w, h,25, ball);
		setColor(Color.RED);

	}


	@Override
	public void getPowerup() {

		
	}
	
	
}
