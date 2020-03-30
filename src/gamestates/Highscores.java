package gamestates;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Formatter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ballVariables.Ball;
import ballVariables.MenuBall;
import ballVariables.NormalBall;



public class Highscores extends GameState implements Serializable {
	
	/**
	 * 
	 */
	private static String highscorePath = "src/highscore.txt";
	private static final long serialVersionUID = 1L;
	private int buttonPressed;
	private MenuBall petBall;
	private ArrayList<Knapp> knappar;
	

	//int i;
	
	public Highscores () {
			
		buttonPressed = 0;
		knappar = new ArrayList<Knapp>();
		setBackground(Color.WHITE);
		petBall = new MenuBall(700, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		knappar.add(new Knapp("Välj bana", 1, Color.PINK));
		
Box b = new Box(BoxLayout.X_AXIS);
		
		b.add(Box.createHorizontalGlue());
		
		
		
		for (Knapp k : knappar) {
			b.add(k);
			b.add(Box.createHorizontalStrut(10));
		}
		b.add(Box.createHorizontalGlue());
		add(Box.createVerticalGlue());
		
		
		add(new JLabel("Highscore är: ", JLabel.CENTER));
		add(Box.createVerticalGlue());
		add(b);
		add(Box.createVerticalGlue());
		
	}
	public void update() {
		petBall.update();
		for (Knapp k : knappar) {
			if (k.getClicked()) {
				buttonPressed = k.getFunction();
			}
		}
	}
	
	public GameState changeState() {
		
		switch (buttonPressed) {
		case 1: return new MapSelect();
		default: return null;
		}
}

	public static void submitHighscore(int score) {
		int oldScore;
		File highScoreFile;
		try {
			oldScore = readHighscore();
		} catch (FileNotFoundException e) {
			highScoreFile = new File(highscorePath);
			oldScore = 0;
			try {
				highScoreFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (score > oldScore) {
			try {
				FileWriter writer = new FileWriter(new File(highscorePath), false);
				writer.write(String.valueOf(score));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static int readHighscore() throws FileNotFoundException {
		try {
			Scanner s = new Scanner(new File(highscorePath));
			if (s.hasNextInt()) {
				int result = s.nextInt();
				s.close();
				return result;
			} else {
				s.close();
				return 0;
			}
			
		} catch (FileNotFoundException e){
			throw e;
		}
		
	}
		
		

	
		
	
}


