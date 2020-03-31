package blockVariables;
import java.awt.*;
import ballVariables.*;
import ballVariables.GameBall;

public class GreenBlock extends Block {

	boolean ballCollision = false;
	
	public GreenBlock(int x, int y, int w, int h, GameBall ball) {
		super(x, y, w, h,25, ball);
		setColor(Color.GREEN);

	}
	
	public boolean powerInitializer() {
		if (ballCollision = true) { 
			System.out.println("SuperBall");
			ball.makesuper();
		}
		return ballCollision;
			
	}

	@Override
	public void getPowerup() {
		if (ball.isSuperball() == false ) {
		ball.makesuper();
		
	}
		else {
			ball.makeunsuper();
		}
	
	
}
}
