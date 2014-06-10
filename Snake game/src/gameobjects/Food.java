package gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Food {
	Random randy= new Random();
	private int x;
	private int y;
	private int internalTimer = 0;
	public Food()
	{
		x=Math.abs(randy.nextInt()%512);
		y=Math.abs(randy.nextInt()%512);
		
	}

	private void glow(Graphics2D g)
	{
		if(internalTimer< 100)
		{
			
			g.setColor(Color.black);
			g.fillOval(x, y, 31, 31);
		}
		else if(internalTimer>= 100 && internalTimer <200)
		{
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(x, y, 30, 30);
		}
		else{
			internalTimer = 0;
		}
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

	public void draw(Graphics2D g)
	{
		glow(g);
	}
	
	public void update()
	{
		internalTimer++;
	
	}

}
