package Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	
	private final int initialPaddleX = 10;
	private final int initialPaddleY = 650;
	
	private int paddleX = initialPaddleX;
	private int paddleY = initialPaddleY;
	
	//move the paddle to right 30 pixels everytime user presses d or right arrow key
	public void moveRight() {
		if (paddleX >= 910) {
			paddleX = 910;
		} 
		else {
			paddleX += 30;
		}
	}
	
	//move the paddle to left 30 pixels everytime user presses a or left arrow key
	public void moveLeft() {
		if (paddleX <= 0) {
			paddleX = 0;
		} 
		else {
			paddleX -= 30;
		}
	}
	
	//draw the paddle with the given numbers
	public void drawPaddle(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(paddleX, paddleY, 120, 10);
	}
	
	//set the position of the paddle to the initial position
	public void initializePaddle() {
		this.paddleX = initialPaddleX;
		this.paddleY = initialPaddleY;
	}
	
	//setters getters
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}

	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}

	public int getPaddleX() {
		return paddleX;
	}

	public int getPaddleY() {
		return paddleY;
	}
}
