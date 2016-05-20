import java.awt.*;
import java.io.*;
import java.net.*;

import javax.imageio.*;
import javax.swing.*;
public class Main {
	private static JFrame frame = new JFrame();
	private static Menu menu = new Menu();
	private static Game game = new Game();
	public static void main(String args[]) throws InterruptedException {
		
		
		frame.setSize(Game.SIZE, Game.SIZE);
		frame.setVisible(true);
		
		game();
	}
	
	public static void game() throws InterruptedException {
		frame.add(menu);
		menu.setVisible(true);
		start();
		
	}
	
	public static void start() {
		if(menu.getStartGame() == true) {
			frame.remove(menu);
			frame.add(game);
			game.setVisible(true);
		} else {
			start();
		}
	}
}
