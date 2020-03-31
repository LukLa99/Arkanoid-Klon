package blockVariables;
import ballVariables.*;
import java.awt.Color;

public class WhiteBlock extends Block{

	Boolean ballCollision = true;
	public WhiteBlock(int x, int y, int W, int H, GameBall ball) {
		super(x, y, W, H,10, ball);
		setColor(Color.WHITE);
	}
	public boolean powerInitializer() {
		if (ballCollision = true) { 
			System.out.println("SuperBall");
			ball.goslow();
		}
		
		return ballCollision;
			
	}

	public void getPowerup() {
		if (ball.getSpeed() == 10) {
		System.out.println("slow");
				ball.goslow();
	}
		if (ball.getSpeed() == 1) {
			System.out.println("Fast");
			ball.gofast();
}

	}
	
}
