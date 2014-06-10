package base;

import java.applet.AudioClip;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameBase {

	
	
	public static void main(String args[])
	{
		JFrame win  = new JFrame("Snake Game");
		JOptionPane.showMessageDialog(null, "Use Arrow Keys to move the snake");
		GamePanel panel = new GamePanel();
		win.add(panel);
		win.setMinimumSize(new Dimension(550,550));
		win.setMinimumSize(new Dimension(550,550));
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		panel.update();
		win.dispose();

	}
	
}
