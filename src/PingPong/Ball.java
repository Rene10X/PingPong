package PingPong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

import javax.swing.Timer;

public class Ball implements ActionListener{
	
	int diameter;
	int speedX;
	int speedY;
	int locationX;
	int locationY;
	
	int delay = 35; 
	
	Timer timer = new Timer(delay, this);
	
	Ball(int diameter, int speedX, int speedY, int locationX, int locationY){
		this.diameter = diameter;
		this.speedX = speedX;
		this.speedY = speedY;
		this.locationX = locationX;
		this.locationY = locationY;
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		locationX -= speedX;
		locationY -= speedY;
		
	}

	public void checkCollisionWall(int x, int y, int width, int height) {
		Rectangle ballRect = new Rectangle(locationX, locationY, diameter, diameter);
		Rectangle objectRect = new Rectangle(x, y, width, height);
		
		if(ballRect.intersects(objectRect)) {
			speedY = speedY * -1;
		}
	}
	public void checkCollisionPaddle(int x, int y, int width, int height) {
		Rectangle ballRect = new Rectangle(locationX, locationY, diameter, diameter);
		Rectangle objectRect = new Rectangle(x, y, width, height);
		
		if(ballRect.intersects(objectRect)) {
			speedX = speedX * -1;
		}
	
	}
}
