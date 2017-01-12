package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


public class RenderPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Color color=new Color(0);
	//public static int color=0;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.BLACK);
        g.fillRect(0, 0, 700, 600);
		
		Snake snake=Snake.snake;
		g.setColor(Color.red);
		g.fillRect(snake.head.x*Snake.SCALE, snake.head.y*Snake.SCALE,Snake.SCALE, Snake.SCALE);
		for(Point point:snake.snakeParts){
			g.setColor(Color.cyan);
			g.fillRect(point.x*Snake.SCALE, point.y*Snake.SCALE,Snake.SCALE, Snake.SCALE);
		}
		
		g.setColor(Color.red);
		g.fillRect(snake.cherry.x*Snake.SCALE, snake.cherry.y*Snake.SCALE,Snake.SCALE, Snake.SCALE);
	}
		
	

}
