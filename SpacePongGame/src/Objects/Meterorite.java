package Objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Panels.TopPanel;

public class Meterorite extends Hittable{
	
	BufferedImage meteoriteImg;
	
	
	

	private int meteoriteX = 10;
	private int meteoriteY = 10;
		
	//Constructor
	public Meterorite() {
		this.generatePosition();
	}
	
	@Override
	public void loadImage() {
		try {
			meteoriteImg = ImageIO.read(new File("meteorite_small.png"));
		} catch(IOException e) {		
		}
	}
	
	public Dimension getPreferredSize() {
        if (meteoriteImg == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(meteoriteImg.getWidth(null), meteoriteImg.getHeight(null));
       }
    }
	
	public void drawMeteorite(Graphics g) { //draw the object with the given numbers
		this.loadImage();
		g.drawImage(meteoriteImg,meteoriteX,meteoriteY,null);
	}

	@Override
	public void hitted(Ball ball, TopPanel panel1) {
		if(this.checkBall(ball, this)) {
			ball.setVelocityX(ball.getVelocityX() * 1.5);
			ball.setVelocityY(ball.getVelocityY() * 1.5);
		}
	}

	@Override
	public BufferedImage getImage() {
		return meteoriteImg;
	}

	@Override
	public int getXPos() {
		return this.meteoriteX;
	}

	@Override
	public int getYPos() {
		return this.meteoriteY;
	}

	@Override
	public void setXPos(int xPos) {
		this.meteoriteX = xPos;
		
	}

	@Override
	public void setYPos(int yPos) {
		this.meteoriteY = yPos;
	}
	
	
	
	



















	
	

}
