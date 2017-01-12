package snakegame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class Snake implements ActionListener,KeyListener{
	
	public JFrame frame;
	public javax.swing.Timer timer =new javax.swing.Timer(20, this);
	ArrayList<Point> snakeParts=new ArrayList<Point>();
	public RenderPanel randerPanel;
	public Point head,cherry;
	Random random;
	Dimension dimension;
	
	public int ticks=0;
	public int direction=DOWN;
	public int score=0;
	public int tailLength=0;
	public boolean over=false;
	public boolean paused=false;
	
	public static final int UP=0,DOWN=1,LEFT=2,RIGHT=3,SCALE=8;
	
	public static Snake snake;
	
	//public Toolkit toolkit;
	public Snake() {
		// TODO Auto-generated constructor stub
		dimension=Toolkit.getDefaultToolkit().getScreenSize();
		frame=new JFrame("Snake");
		frame.setVisible(true);
		frame.setSize(700, 600);
		frame.setResizable(false);
		frame.setLocation(dimension.width/2-frame.getWidth()/2, dimension.height/2-frame.getHeight()/2);
		randerPanel=new RenderPanel();
		frame.add(randerPanel);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startGame();
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		randerPanel.repaint();
		ticks++;
		if( ticks%5==0 && head!=null && !over && !paused){
			
			snakeParts.add(new Point(head.x,head.y));
			System.out.println(head.x+","+head.y);
			if(direction==UP ){
				if(head.y-1>=0 ) head=new Point(head.x,head.y-1);
				else over=true;
			}
			if(direction==DOWN ){
				if(head.y+1<frame.getHeight()/SCALE) head=new Point(head.x, head.y+1);
				else over=true;
			}
			if(direction==LEFT ) {
				if(head.x-1>=0)head=new Point(head.x-1, head.y);
				else over=true;
			}
				
			if(direction==RIGHT ) {
				if(head.x+1<frame.getWidth()/SCALE)head=new Point(head.x+1, head.y);
				else over=true;
			}
			if(snakeParts.size()>tailLength) snakeParts.remove(0);
			}
		
			if(cherry!=null){
				if(head.equals(cherry)){
					score+=10;
					tailLength++;
					//snakeParts.add(head);
					cherry.setLocation(random.nextInt(69),random.nextInt(59));
				
			}
		}
	}



	/*public boolean isHittingTail(int x, int y) {
		// TODO Auto-generated method stub
		for(Point tailPoint:snakeParts){
			if(tailPoint != snakeParts.get(0) && tailPoint.equals(new Point(x,y))) 
				break;
			
		}
		return false;
	}*/



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int i=e.getKeyCode();
		if(i==KeyEvent.VK_A || i==KeyEvent.VK_LEFT && direction !=RIGHT){
			direction=LEFT;
		}
		if(i==KeyEvent.VK_D || i==KeyEvent.VK_RIGHT && direction !=LEFT){
			direction=RIGHT;
		}
		if(i==KeyEvent.VK_W || i==KeyEvent.VK_UP && direction !=DOWN){
			direction=UP;
		}
		if(i==KeyEvent.VK_S || i==KeyEvent.VK_DOWN && direction !=UP){
			direction=DOWN;
		}
		if(i==KeyEvent.VK_SPACE){
			if(over) startGame();
			else paused=true;
		}
	}



	public void startGame() {
		// TODO Auto-generated method stub
		over=false;
		paused=false;
		score=0;
		tailLength=0;
		direction=DOWN;
		ticks=0;
		snakeParts.clear();
		head=new Point(0,-1);
		random=new Random();
		cherry=new Point(random.nextInt(69),random.nextInt(59));
		timer.start();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		snake=new Snake();
	}
	
	

}
