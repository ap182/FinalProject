import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
public class Menu extends JPanel {
	private int highscore;
	private File file = new File("Final/image/court.png");
	private Image img;
	private boolean startGame = false;
	public Menu() {
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame = true;
			}

			});
	}
	
	public void paint(Graphics g) {
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paint(g);
		
		g.drawImage(img, 0, 0, null);
		
	}
	
	public void mouseClicked(MouseEvent e) { 
		startGame = true;
	}
	
	public boolean getStartGame() {
		return startGame;
	}

}
