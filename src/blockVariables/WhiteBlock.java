package blockVariables;
import ballVariables.*;
import java.awt.Color;

public class WhiteBlock extends Block{
	GameBall ball;
	Boolean ballCollision = true;
	public WhiteBlock(int x, int y, int W, int H) {
		super(x, y, W, H,10);
		setColor(Color.WHITE);
	}
	public boolean powerInitializer() {
		if (ballCollision = true) { 
			System.out.println("SuperBall");
			ball.makesuper();
		}
		
		return ballCollision;
			
	}
	
	
}
