package gamestates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Knapp extends JPanel{
	
	private final int function;
	private boolean clickedFlag;
	
	public Knapp(String name, int function, Color c) {
		setPreferredSize(new Dimension(120, 80));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		setBackground(Color.ORANGE);
		add(new JLabel(name));
		clickedFlag = false;
		this.function = function;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clickedFlag = true;
			}
			
		});
		
		
	}
	public boolean getClicked() {
		return clickedFlag;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	public int getFunction() {
		return function;
	}
	
}
