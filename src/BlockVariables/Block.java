package BlockVariables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import Variables.*;

public abstract class Block extends Rectangle {

	private Color color;
	private boolean Collide = false;
	Player player;
	
	
	public Block(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void collided() {
		Collide = true;
	}



	
	

}


