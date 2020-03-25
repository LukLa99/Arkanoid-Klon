package ScoreFrame;



import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Variables.*;
import javax.swing.JButton;
import javax.swing.JPanel;
public class Startmenu extends JPanel {
	Game game;
	JButton Map1 = new JButton();
	JButton Map2 = new JButton();
	JButton Map3 = new JButton();
	public Startmenu() {
		
		setSize(1200,800);
		setLayout(new BorderLayout());
		this.add(Map1, BorderLayout.CENTER);
		this.add(Map2,BorderLayout.LINE_END);
		this.add(Map3,BorderLayout.PAGE_START);
	

	/*

	Map1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
		game.setMapSelector(1);
		}
	});

	Map2.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			game.setMapSelector(2);
		}
	});

	Map3.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			game.setMapSelector(3);	
		}
	});
*/
}

}
