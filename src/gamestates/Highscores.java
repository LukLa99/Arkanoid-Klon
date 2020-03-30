package gamestates;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Formatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ballVariables.Ball;
import ballVariables.MenuBall;
import ballVariables.NormalBall;



public class Highscores extends GameState implements Serializable {
	
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


		public void serialize (int o, String fileName) throws IOException {
		Ball score= new NormalBall(o, o);
		ObjectOutputStream out =new ObjectOutputStream( new FileOutputStream(new File(fileName)));
			out.write(score.points());
		}
		
		public int deserialize(String name) throws IOException {
			int o;
			
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(name)))) {
				o =in.read();
			}
				return o;
			}

	


//		public int points() {
//		return super.points();
	//}
	//Highscores score= new Highscores();
	//score.serialize(0, "src/GameState/HighScores.ser");

//private Formatter x;
//Ball score= new NormalBall(i, i);
//
//public void openFile() {
//	try {
//		x= new Formatter ("poang.txt");
//	} catch (Exception e) {
//		System.out.println("Error");
//	}
//}
//public void addRecords () {
//	x.format(int i, score.points())
//}
//	
		
	
}