package base;

import gameobjects.Food;
import gameobjects.Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	Food food = new Food();
	Snake snake = new Snake();
	
	public GamePanel()
	{
		addKeyListener(this);
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 542, 542);
		Graphics2D g2D = (Graphics2D)g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		food.draw(g2D);
		snake.paint(g2D);
	}
	
	
	public void update()
	{
		while(true)//game loop
		{
			repaint();
			snake.setTarget(new Point(food.getX(),food.getY()));
			if(snake.ate())
			{
				food = new Food();
				snake.setAteTarget(false);
			}
			snake.update();
			food.update();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(snake.isGameOver())
			{
				JOptionPane.showMessageDialog(this, "Game Over\n Score"+snake.getTails()/2);
				break;
			}
			
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		snake.keyPressed(e);

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		snake.KeyReleased(e);

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
