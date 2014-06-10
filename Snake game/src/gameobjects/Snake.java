package gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import javax.swing.JOptionPane;

public class Snake {

	private int headX=5;
	private int headY=5;
	private boolean pressed = false;
	private int directionX=1;
	private int directionY=0;
	private ArrayList<Integer> tailX= new ArrayList<Integer>();
	private ArrayList<Integer> tailY= new ArrayList<Integer>();
	private int tails = 0;
	private int targetX=0;
	private int targetY=0;
	private boolean ateTarget = false;
	private boolean gameover = false;
	
	public void setAteTarget(boolean ate)
	{
		ateTarget = ate;
	}
	public void keyPressed(KeyEvent e)
	{
		if(!pressed)
		{
			pressed = true;
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			{
				if(directionY != 1)
				{
					directionY = -1;
				}
					directionX =0;
			}
				break;
				
			case KeyEvent.VK_DOWN:
			{
				if(directionY != -1)
				{
					directionY = 1;
				}
					directionX =0;
			}
				break;
			case KeyEvent.VK_LEFT:
			{
				if(directionX != 1)
				{
					directionX = -1;
				}
					directionY =0;
			}
				break;
			case KeyEvent.VK_RIGHT:
			{
				if(directionX != -1)
				{
					directionX = 1;
				}
					directionY =0;
			}
				break;
			default:
				break;
			}
		}
	}
	public void KeyReleased(KeyEvent e)
	{
		pressed = false;
	}
	
	public void update()
	{
		//if(Math.sqrt(Math.pow(headX-targetX, 2)+Math.pow(headY-targetY, 2))==60);
		
		eat();
		updateTails();
		collision();
		headX+= directionX;
		headY+= directionY;
		
		
	}
	
	public void setTarget(Point p)
	{
		targetX=p.x;
		targetY = p.y;
	}
	
	public void eat()
	{
		
		
		if(isSatisfied(targetX,targetY))
		{
			ateTarget = true;
			if(tailX.isEmpty()&&tailY.isEmpty())
			{
			tailX.add(headX+100);
			tailY.add(headY+100);
			}
			else
			{
				tailX.add(tailX.get(tailX.size()-1)+100);
				tailY.add(tailY.get(tailY.size()-1)+100);
			}
			tails++;
		}
	}
	
	private boolean isSatisfied(int x,int y) // distance formula
	{
		return headX>x-15&&headX<x+15&&headY>y-15&&headY<y+15;
	}
	
	
	private void collision()
	{
		for(int i=100;i<tailX.size();i++)
		{
			if(isSatisfied(tailX.get(i),tailY.get(i)))
			gameover= true;
			
				break;
		}
		
		if(headX<=0||headX>512||headY<=0||headY>512)
			gameover = true;
	}
	
	public boolean isGameOver()
	{
		return gameover;
	}
	
	public boolean ate()
	{
		return ateTarget;
	}
	
	public int getTails()
	{
		return tails;
	}
	
	public void paint(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(headX, headY, 30, 30);
		
			for(int i=0;i<tailX.size();i++)
			{
				g.setColor(new Color(2*i,2*i,2*i));
				g.fillOval(tailX.get(i), tailY.get(i), 30, 30);
				
			}
		
	}
	
	private void updateTails()
	{
		if(!tailX.isEmpty())
		{
				for(int i=tailX.size()-1;i>0;i--)
				{
					tailX.set(i, tailX.get(i-1));
					tailY.set(i, tailY.get(i-1));
				}
				tailX.set(0,headX);
				tailY.set(0,headY);
		
		}
	}
}
