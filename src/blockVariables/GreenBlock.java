package blockVariables;
import java.awt.*;
import ballVariables.*;
import ballVariables.GameBall;

public class GreenBlock extends Block {

	boolean ballCollision = false;
	GameBall ball;
	public GreenBlock(int x, int y, int w, int h) {
		super(x, y, w, h,25);
		setColor(Color.GREEN);

	}
	
	public boolean powerInitializer() {
		if (ballCollision = true) { 
			System.out.println("SuperBall");
			ball.makesuper();
		}
		return ballCollision;
			
	}
	
	
}
