package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.Controller;
import Controller.Controller;
import Model.ItemManager;

import java.lang.Thread;
import java.lang.String;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private ItemManager itemManager;
	Thread thread;
	private ImageIcon shopcake, backGroundIcon;

	public GamePanel() {
		// bang = new ImageIcon("image/bang.png");
		itemManager = new ItemManager();
		shopcake = new ImageIcon("image/Shopcake.png");
		backGroundIcon = new ImageIcon("image/backgroundingame.jpg");
		addMouseMotionListener(new Controller(itemManager));
		setFocusable(true);

		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(backGroundIcon.getImage(), 0, 0, 900, 700, null);
		g.setColor(Color.YELLOW);
		g.drawImage(shopcake.getImage(), 100, 50, 150, 150, null);
		g.drawImage(shopcake.getImage(), 300, 50, 150, 150, null);
		g.drawImage(shopcake.getImage(), 500, 50, 150, 150, null);
		g.drawString("Score: " + String.valueOf(itemManager.getScore()), 20, 20);
		g.drawString("Heart: " + String.valueOf(itemManager.getHeart()), 20, 40);
		itemManager.paint(g);

	}

	

	public void gameOver() {
		
		if (itemManager.getHeart() == 0) {
			int n = JOptionPane.showConfirmDialog(null,
					"YOU LOSE" + "\n" + "Score: " + itemManager.getScore() + "\n" + "Try a gain ?", "GAME OVER!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (n == JOptionPane.YES_OPTION) {
				itemManager.Start();
			} else {
				System.exit(0);
			}
		}
	}

	public void starGame() {
		itemManager.down();
		itemManager.addCake();
		itemManager.addCat();
		gameOver();
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	@Override
	public void run() {
		int a = 1;
		while (a < 2) {
			starGame();
			repaint();

			try {
				Thread.sleep(8);

			} catch (Exception e) {
			}
		}
	}

}
