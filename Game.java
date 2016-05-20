import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;
public class Game extends JPanel {
	public static final int SIZE = 800;
	Basketball ball = new Basketball();
	Wall wall1 = new Wall(WIDTH);
	Wall wall2 = new Wall(WIDTH * 3 / 2);
	private int score = 0;
	private int scroll = 0;
	private boolean dead = false;
	private String msg = "";
	private File file = new File("Final/image/court.png");
	private Image img;
	public Game() {
		
	}
	
	public void paint(Graphics g) {
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paint(g);
		
		g.drawImage(img, scroll, 0, null);
		g.drawImage(img, scroll + SIZE, 0, null);
		
		try {
			wall1.paint(g);
			wall2.paint(g);
			ball.paint(g);
		} catch(IOException e) {
			
		}
		
		
	}
	
	public void move() {
		wall1.move();
		wall2.move();
		ball.move();
		scroll += wall1.getSpeed();
		if(scroll == -SIZE) {
			scroll = 0;
		}
		
		if(dead) {
			wall1.setX(WIDTH / 2);
			wall2.setX(WIDTH + (WIDTH / 2));
			dead = false;
		}
		
		if((wall1.getX() == ball.getX()) || (wall2.getX() == ball.getX())) {
			score();
		}
	}
	
	public void score() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
