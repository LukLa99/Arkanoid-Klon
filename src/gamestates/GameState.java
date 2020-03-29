package gamestates;

import javax.swing.JPanel;

public abstract class GameState extends JPanel{
	
	public GameState() {
		this.setFocusable(true);
	}
	public boolean isPlaying() {
		return true;
		
	}

	public abstract void update();
	
	public abstract GameState changeState();
}
