package PingPong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
	int screenWidth = 800;
	int screenHeight = 600;
	int delay = 50;
	int paddleWidth = 15;
	int paddleHeight = 100;
	int paddle1X = 15;
	int paddle1Y = screenHeight / 2;
	int paddle2X = 770;
	int paddle2Y = screenHeight / 2;
	
	Ball ball;	
	Timer timer = new Timer(delay, this);
	
	GamePanel(){
		//        diameter speedx speedy locationx locationy
		ball = new Ball(40, 10, 10, 400, 300);
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		//this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g){
		
		if(paddle1Y <= 0) {
			paddle1Y = 0;
		} else if(paddle1Y >= 500) {
			paddle1Y = 500;
		} else if(paddle2Y <= 0) {
			paddle2Y = 0;
		} else if(paddle2Y >= 500) {
			paddle2Y = 500;
		}
		
		g.fillRect(paddle1X, paddle1Y, paddleWidth, paddleHeight);
		
		g.fillRect(paddle2X, paddle2Y, paddleWidth, paddleHeight);
		
		g.fillOval(ball.locationX, ball.locationY, ball.diameter, ball.diameter);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ball.checkCollisionPaddle(paddle1X, paddle1Y, paddleWidth, paddleHeight);
		ball.checkCollisionPaddle(paddle2X, paddle2Y, paddleWidth, paddleHeight);
		ball.checkCollisionWall(0, 0, screenWidth, 5);
		ball.checkCollisionWall(0, screenHeight, screenWidth, 5);
		repaint();
		//System.out.println("loop");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: 
				System.out.println('w');
				paddle1Y -= 20;	
				break;
			case KeyEvent.VK_S:
				System.out.println('s');
				paddle1Y += 20;
				break;
			case KeyEvent.VK_UP:
				System.out.println("arrowkey up");
				paddle2Y -= 20;	
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("arrowkey down");
				paddle2Y += 20;	
				break;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
