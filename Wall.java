import java.awt.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;

import java.util.*;
public class Wall {
	Random rand = new Random();
	Basketball ball = new Basketball();
	private int x;
	private int y = rand.nextInt(Game.SIZE - 400) + 200;
	private int speed = -6;
	private Image img;
	private Game game = new Game();
	private File file = new File("Final/image/hand.png");
	private static final int WIDTH = 45;
	private int height = Game.SIZE - y;
	private static final int GAP = 200;
	public Wall(int n) {
		x = n;
	}
	public void move() {
		x += speed;
		Rectangle bottom = new Rectangle(x, y, WIDTH, height);
		Rectangle top = new Rectangle(x, 0, WIDTH, Game.SIZE - (height + GAP));
		
		if(bottom.intersects(ball.getRect()) || (top.intersects(ball.getRect()))) {
			ball.reset();
			death();
		}
		if(x <= 0 - WIDTH) {
			x = Game.SIZE;
			y = rand.nextInt(Game.SIZE - 400) + 200;
			height = Game.SIZE - y;
		}
	}
	public void death() {
		y = rand.nextInt(Game.SIZE - 400) + 200;
		height = Game.SIZE - y;
		game.setDead(true);
	}
	
	public void paint(Graphics g) throws IOException {
		img = ImageIO.read(file);
		g.drawImage(img, x, y, null);
		g.drawImage(img, x, -1 * Game.SIZE + (y - GAP), null);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
