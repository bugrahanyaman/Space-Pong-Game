package Objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panels.TopPanel;

public class Ufoship extends Hittable{
	
	BufferedImage ufoshipImg;
	
	private int ufoshipX = 10;
	private int ufoshipY = 10;

	//Constructor
	public Ufoship() {
		this.generatePosition();
	}
	
	@Override
	public void loadImage() {
		try {
			ufoshipImg = ImageIO.read(new File("ufoship_small.png"));
		} catch(IOException e) {		
		}
	}
	
	public Dimension getPreferredSize() {
        if (ufoshipImg == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(ufoshipImg.getWidth(null), ufoshipImg.getHeight(null));
       }
    }
	
	public void drawUfoship(Graphics g) { //draw the object with the given numbers
		this.loadImage();
		g.drawImage(ufoshipImg,ufoshipX,ufoshipY,null);
	}
	
	@Override
	public void hitted(Ball ball, TopPanel panel1) {
		if (this.checkBall(ball, this)) {
			panel1.setLives(panel1.getLives() - 1);
			panel1.getLivesLabel().setText("Lives: " + panel1.getLives() + "         ");
		}
		
	}

	

	@Override
	public BufferedImage getImage() { 
		return ufoshipImg;
	}

	@Override
	public int getXPos() {
		return this.ufoshipX;
	}

	@Override
	public int getYPos() {
		return this.ufoshipY;
	}

	@Override
	public void setXPos(int xPos) {
		this.ufoshipX = xPos;
	}

	@Override
	public void setYPos(int yPos) {
		this.ufoshipY = yPos;
	}


}
