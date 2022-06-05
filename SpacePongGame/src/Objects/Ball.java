package Objects;

import java.awt.Color;
import java.awt.Graphics;

import Panels.MiddlePanel;
import Panels.TopPanel;

public class Ball {

	
	private final double gravity = 9.8;
	private final double constant = 1;
	
	private final double initialBallX = 10;
	private final double initialBallY = 10;
	
	private double ballX = initialBallX;
	private double ballY = initialBallY;
	
	private final double initialVelocityX = 3;
	private final double initialVelocityY = 0;
	
	private double velocityX = initialVelocityX;
	private double velocityY = initialVelocityY;//saliha yaman
	
	
	//draw the ball with the given numbers 
	public void drawBall(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) ballX, (int) ballY, 20, 20);
		
	}
	
	//move the ball according to gravity
	public void moveBall() {
		this.changeVelocity();
		this.checkBorders();
		
		ballX = ballX + velocityX;
		ballY = ballY + velocityY;
	}

	 //check if ball collides with the paddle if true continue moving if false lose one live 
	public void checkPaddle(Paddle paddle,MiddlePanel panel2, Meterorite meteorite, Ufoship ufoship , Star star, TopPanel panel1) {
		if(ballX >= paddle.getPaddleX() && ballX <= paddle.getPaddleX() + 120 && ballY >= paddle.getPaddleY()) {
			velocityY = -velocityY - gravity * constant;
			panel1.setScore(panel1.getScore() + 1);
			panel1.getScoreLabel().setText("Score: " + panel1.getScore() + "         ");
		} else if(ballY >= paddle.getPaddleY()) {
			this.loseLive(panel2, paddle, meteorite, ufoship, star, panel1);
		}
	}

	//check if the ball collides with the borders of the panel if true continue moving with the necessary velocity
	private void checkBorders() {
		if (ballX >= 1000) {
			velocityX = -velocityX;
		} if(ballX <= 0) {
			velocityX = -velocityX;
		} if (ballY <= 0) {
			velocityY = -velocityY + gravity * constant;
		} 
	}
	
	//change the velocity in Y direction according to gravity
	public void changeVelocity() {
		velocityY = velocityY + gravity * constant;
	}
	
	public void loseLive(MiddlePanel panel2, Paddle paddle, Meterorite meteorite,Ufoship ufoship , Star star, TopPanel panel1) {
		panel2.setPlay(false);
		panel1.setPlay(false);
		
		panel1.setLives(panel1.getLives() - 1);
		panel1.getLivesLabel().setText("Lives: " + panel1.getLives() + "         ");
	
		this.initializeBall();
		
		this.initializeVelocity(panel1);
		
		paddle.initializePaddle();
		
		meteorite.generatePosition();
		ufoship.generatePosition();
		star.generatePosition();
	}
	
	//increase the level and increase speed of the ball 1.5 times
	public void levelUp(TopPanel panel1) {
		this.initializeBall();
		this.initializeVelocity(panel1);
		this.setVelocityX(this.getVelocityX() * 1.5);
		this.setVelocityY(this.getVelocityY() * 1.5);
		
		panel1.setPlay(false);
		panel1.setTime(panel1.initialTime);
		panel1.setLevel(panel1.getLevel() + 1);
		panel1.getLevelLabel().setText("Level: " + panel1.getLevel() + "         ");
	}
	
	private void initializeBall() {
		this.ballX = initialBallX;
		this.ballY = initialBallY;
	}
	
	private void initializeVelocity(TopPanel panel1) {
		int level = panel1.getLevel();
		this.velocityX = initialVelocityX * Math.pow(1.5, level - 1);
		this.velocityY = initialVelocityY * Math.pow(1.5, level - 1);
	}
	
	//setters getters
	public double getBallX() {
		return ballX;
	}

	public double getBallY() {
		return ballY;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public double getVelocityY() {
		return velocityY;
	}

	
}