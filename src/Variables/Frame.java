package Variables;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import ScoreFrame.*;

public class Frame extends JFrame {
	public Startmenu menu;
	public Game game;

	public Frame() {
		super("Arkanoid Clone");
//		setLayout(new BorderLayout());
//		menu = new Startmenu();
//		add(menu,BorderLayout.LINE_END);
		game = new Game();
		add(game);
		setSize(game.getSize());
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);

	}
}
