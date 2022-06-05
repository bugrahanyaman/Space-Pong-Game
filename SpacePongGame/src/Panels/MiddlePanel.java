package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Objects.*; 

public class MiddlePanel extends JPanel implements KeyListener, ActionListener{
	
	private TopPanel panel1;
	private boolean play = false;
	boolean timeOver = false;
	
	Timer timer = new Timer(20,this); //timer for actionListener (calls every 20 milliseconds)

	
	//create ball and paddle
	Paddle paddle = new Paddle();
	Ball ball = new Ball();
	
	//create stellar objects
	Meterorite meteorite = new Meterorite();
	Ufoship ufoship = new Ufoship();
	Star star = new Star();
	
	//Constructor
	public MiddlePanel(TopPanel panel1) {
		
		this.panel1= panel1; 
		
		timer.start(); //start the timer
		
		setBounds(0,0,1024,50);
		setBackground(Color.DARK_GRAY);
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//draw the paddle and ball
		paddle.drawPaddle(g);
		ball.drawBall(g);
		
		//draw stellar objects
		meteorite.drawMeteorite(g);
		ufoship.drawUfoship(g);
		star.drawStar(g);
		
		this.gameOver(g); 
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (play) {
			
			ball.moveBall();
			
			ball.checkPaddle(paddle, this, meteorite, ufoship, star, panel1);
			
			meteorite.hitted(ball, panel1);
			ufoship.hitted(ball, panel1);
			star.hitted(ball, panel1);
			
			this.timeOver();
			repaint();	
		}
	}
	
	//check the number of lives if true game over 
	private void gameOver(Graphics g) {
			
		if(panel1.getLives() <= 0) {
				
			this.setPlay(false);
			panel1.setPlay(false);
				
			g.setColor(Color.orange);
			g.setFont(new Font("Chiller", Font.BOLD , 150));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("GAME OVER!", (this.getWidth() - metrics.stringWidth("GAME OVER!")) / 2, this.getHeight() / 2);
		}
	}
		
	//check the remaining time if true level up 
	private void timeOver() {
		
		if (!timeOver) {
			if (panel1.getTime() == 0) {
				this.setPlay(false);
				
				ball.levelUp(panel1);
				
				paddle.initializePaddle();
				
				
				
				timeOver = true;
				
			}
		} else if(panel1.getTime() != 0) {
			timeOver = false;
		}
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(play) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT | e.getKeyCode() == KeyEvent.VK_D) {
				paddle.moveRight();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT | e.getKeyCode() == KeyEvent.VK_A) {
				paddle.moveLeft();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	//setters getters
	public void setPlay(boolean play) {
		this.play = play;
	}
	
	public boolean getPlay() {
		return play;
	}

}