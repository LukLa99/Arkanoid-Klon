
package Executables;

import Variables.Frame;
import Variables.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		final double fps =120.0;
		double frequency = 1000 / fps;
		Variables.Frame f = new Frame();
		f.setBackground(Color.BLACK);
		while (f.game.isPlaying()) {
			long timePreUpdate = System.currentTimeMillis();
			f.game.update();
			long UpdateTime = System.currentTimeMillis() - timePreUpdate;
			try {
				Thread.sleep((long) Math.max(frequency - UpdateTime, 0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		f.dispose();
	}

}
