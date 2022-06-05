package Objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panels.TopPanel;

public class Star extends Hittable{
	
	BufferedImage starImg;
	
	private int starX = 10;
	private int starY = 10;
	
	//Constructor
	public Star() {
		this.generatePosition();
	}
	
	@Override
	public void loadImage() { 
		try {
			starImg = ImageIO.read(new File("star_small.png"));
		} catch(IOException e) {		
		}
	}
	
	
	public Dimension getPreferredSize() {
        if (starImg == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(starImg.getWidth(null), starImg.getHeight(null));
       }
    }
	
	public void drawStar(Graphics g) { //draw the object with the given numbers
		this.loadImage();
		g.drawImage(starImg,starX,starY,null);
	}
	
	@Override
	public void hitted(Ball ball, TopPanel panel1) {
		if (this.checkBall(ball, this)) {
			panel1.setScore(panel1.getScore() + 5);
		}
	}

	@Override
	public BufferedImage getImage() {
		return starImg;
	}

	@Override
	public int getXPos() {
		return starX;
	}

	@Override
	public int getYPos() {
		return starY;
	}

	@Override
	public void setXPos(int xPos) {
		this.starX = xPos;
	}

	@Override
	public void setYPos(int yPos) {
		this.starY = yPos;
	}

}
