package Variables;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import BlockVariables.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	

	private int MapSelector;
	private int screenSizeX = 1200;
	private int screenSizeY = 800;
    Player player;
    ArrayList<Block> blocks = new ArrayList<Block>();
    private boolean playing = true;
    public boolean started = false;
    
    
    
    public boolean isPlaying() {
		return playing;
		
	}
	
	public Game() {
    	
    	setBorder(getBorder());
        setFocusable(true);
        setBackground(Color.GRAY);
        setSize(1200, 800);

        player = new Player(getWidth()/2, getHeight()-200);

        makeblocks();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
            
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Left");
                    player.setLeft(true);
                }
                
                 if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("Right");
                    player.setRight(true);
                }
            	if (started == false ){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	System.out.println("Starting game!");
                	player.setPlaying(true);                	
                }
            }
            }
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Released");
                    player.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("Released");
                    player.setRight(false);
                    started  = false;
                }
            }
        });

      	
        }
	
	

    private void makeblocks() {
    	 for (int i = 0; i < 12; i++) {
	            blocks.add(new RedBlock((i * (55)) + 50, 160, 50,50));
	        }
	        for (int i = 0; i < 12; i++) {
	            blocks.add(new GreenBlock((i * (55)) + 50, 100, 50,50));
	        }
	        for (int i = 0; i < 12; i++) {

	            blocks.add(new BlueBlock((i * (55)) + 50, 220, 50, 50));
	        }
//    	switch (MapSelector) {
//		case 1:
//			  for (int i = 0; i < 12; i++) {
//		            blocks.add(new RedBlock((i * (55)) + 50, 160, 50,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//		            blocks.add(new GreenBlock((i * (55)) + 50, 100, 50,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//
//		            blocks.add(new BlueBlock((i * (55)) + 50, 220, 50, 50));
//		        }
//			break;
//
//		case 2:
//			  for (int i = 0; i < 7; i++) {
//		            blocks.add(new RedBlock((i * (55)) + 50, 160, 70,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//		            blocks.add(new GreenBlock((i * (55)) + 50, 100, 50,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//
//		            blocks.add(new BlueBlock((i * (55)) + 50, 220, 50, 50));
//		        }
//		
//		
//			break;
//
//		case 3:
//			  for (int i = 0; i < 7; i++) {
//		            blocks.add(new RedBlock((i * (55)) + 50, 160, 70,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//		            blocks.add(new GreenBlock((i * (55)) + 50, 100, 50,50));
//		        }
//		        for (int i = 0; i < 12; i++) {
//
//		            blocks.add(new BlueBlock((i * (55)) + 50, 220, 50, 50));
//		        }
//		default:
//		}
//    
//            
//		
	}

	private void Collisions() {
		Rectangle ballHitbox = new Rectangle(player.getLocX(), player.getLocY(), 20, 20);
		Rectangle upper;
		Rectangle lower;
		Rectangle left;
		Rectangle right;
		Block tempBlock = null;
		for (Block b : blocks) {
			if (b.intersects(ballHitbox)) {
				upper = new Rectangle(b.x, b.y, b.width, 1);
				lower = new Rectangle(b.x, (b.y + b.height - 1), b.width, 1);
				left = new Rectangle(b.x, b.y, b.height, 1);
				right = new Rectangle((b.x + b.width - 1), b.y, 1, b.height);
				if (ballHitbox.intersects(lower) || ballHitbox.intersects(upper)) {
					player.ReverseY();
					tempBlock = b;
				}
				if (ballHitbox.intersects(left) && player.getVectorX() > 0) {
					player.ReverseX();
					tempBlock = b;
				}
				if (ballHitbox.intersects(right) && player.getVectorX() < 0) {
					player.ReverseX();
				}
				if (ballHitbox.intersects(lower) && player.getVectorY() < 0) {
					player.ReverseY();
					tempBlock = b;
				}
				if (ballHitbox.intersects(upper) && player.getVectorY() > 0) {
					player.ReverseY();
					tempBlock = b;
				}

			}
		}
		blocks.remove(tempBlock);
	}

	public void update() {
	
		playing = player.update();
		player.setLeft(false);
		player.setRight(false);
		Collisions();
		repaint();
	}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        player.DrawOval(g);
        player.drawPlayer(g);
        for (Block b : blocks) {
            b.draw(g);
        }
    }
}

