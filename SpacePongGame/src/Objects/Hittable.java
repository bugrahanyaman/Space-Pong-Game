package Objects;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.Random;

import Panels.TopPanel;

public abstract class Hittable extends Component{ //abstract superclass of the stellar objects
	
	boolean myBool = true;
	
	Random random = new Random();
	
	//abstract methods
	public abstract void hitted(Ball ball, TopPanel panel1); //check the collision with the ball if true trigger the action
	
	public abstract void loadImage(); //load the image of the stellar object
	
	//return true if the ball collides with the stellar objects false otherwise
	public boolean checkBall(Ball ball, Hittable stellar) {
		
		if(myBool) {
			boolean isHitted = false;
			
			if (ball.getBallX() >= stellar.getXPos() 
				&& ball.getBallY() >= stellar.getYPos() 
				&& ball.getBallX() <= stellar.getXPos() + stellar.getImage().getWidth() 
				&& ball.getBallY() <= stellar.getYPos() + stellar.getImage().getHeight()) {
				isHitted = true;
				myBool = false;
			}
			
			return isHitted;
		}
		
		if (!(ball.getBallX() >= stellar.getXPos()
				&& ball.getBallY() >= stellar.getYPos() 
				&& ball.getBallX() <= stellar.getXPos() + stellar.getImage().getWidth() 
				&& ball.getBallY() <= stellar.getYPos() + stellar.getImage().getHeight())) {
			myBool = true;
		}
		return false;
	}
	
	//generate a random position
	public void generatePosition() {
		this.setXPos(random.nextInt(950));
		this.setYPos(random.nextInt(400));
	}
	
	//setters getters
	public abstract int getXPos();
	public abstract int getYPos();
	
	public abstract void setXPos(int xPos);
	public abstract void setYPos(int yPos);
	
	public abstract BufferedImage getImage();
}
