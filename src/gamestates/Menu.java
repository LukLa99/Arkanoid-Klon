package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ballVariables.MenuBall;

public class Menu extends GameState{
	
	private MenuBall petBall;
	private ArrayList<Knapp> knappar;
	private int buttonPressed;
	
	public Menu() {
		buttonPressed = 0;
		knappar = new ArrayList<Knapp>();
		setBackground(Color.WHITE);
		petBall = new MenuBall(700, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		knappar.add(new Knapp("Nytt Spel", 1, Color.PINK));
		knappar.add(new Knapp("Highscores", 2, Color.PINK));
		
		
		
		
		Box b = new Box(BoxLayout.X_AXIS);
		
		b.add(Box.createHorizontalGlue());
		
		
		
		for (Knapp k : knappar) {
			b.add(k);
			b.add(Box.createHorizontalStrut(10));
		}
		b.add(Box.createHorizontalGlue());
		add(Box.createVerticalGlue());
		
		
		add(new JLabel("New Super Original not Arkanoid game", JLabel.CENTER));
		add(Box.createVerticalGlue());
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
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		petBall.draw(g);
	}
	@Override
	public GameState changeState() {
		
		switch (buttonPressed) {
		case 1: return new MapSelect();
		case 2: return new Highscores();
		default: return null;
		}
	}
	
	
	
}
