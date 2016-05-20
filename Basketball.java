import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;
public class Basketball extends Game implements ActionListener {
	private Game game = new Game();
	private static final int DIAMETER = 50;
	private int x = (game.SIZE / 2) - (DIAMETER / 2);
	private int y = game.SIZE / 2;
	private int acceleration = 1;
	private int speed = 2;
	private File file = new File("Final/image/basketball.png");
	private Image img;

	public Basketball() {
		
	}
	public void jump() {
		speed = -17;
	}
	public void move() {
		if((y>0) && (y<Game.SIZE)) {
			speed += acceleration;
			y += speed;
		} else {
			reset();
			game.setDead(true);
		}
	}
	public void reset() {
		y = game.SIZE / 2;
		speed = 2;
		game.setScore(0);
		
		game.setMsg("Try again.");

		Timer timer = new Timer(5000, new ActionListener() {
			  public void actionPerformed(ActionEvent event){
				game.setMsg("");
			 };
		});
		
		timer.start();
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	
	public void paint(Graphics g) throws IOException {
		img = ImageIO.read(file);
		g.drawImage(img, x, y, null);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
