package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ballVariables.MenuBall;
import game.Game;

public class MapSelect extends GameState {
	private int buttonPressed;
	private MenuBall petBall;
	private ArrayList<Knapp> knappar;

	public MapSelect() {
		buttonPressed = 0;
		knappar = new ArrayList<Knapp>();
		setBackground(Color.WHITE);
		petBall = new MenuBall(700, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		knappar.add(new Knapp("Bana 1", 1, Color.CYAN));
		knappar.add(new Knapp("Bana 2", 2, Color.CYAN));
		knappar.add(new Knapp("Bana 3", 3, Color.CYAN));
		
		
		
		Box b = new Box(BoxLayout.X_AXIS);
		
		b.add(Box.createHorizontalGlue());
		
		
		
		for (Knapp k : knappar) {
			b.add(k);
			b.add(Box.createHorizontalStrut(10));
		}
		b.add(Box.createHorizontalGlue());
		add(Box.createVerticalGlue());
		
		
		add(new JLabel("Välj Bana", JLabel.CENTER));
		add(b);
		add(Box.createVerticalGlue());
	}

	@Override
	public void update() {
		petBall.update();
		for (Knapp k : knappar) {
			if (k.getClicked()) {
				buttonPressed = k.getFunction();
			}
		}
		
	}

	@Override
	public GameState changeState() {
		switch (buttonPressed) {
		case 1: return new Game(1);
		case 2: return new Game(2);
		case 3: return new Game(3);
		default: return null;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
	}

	

}
