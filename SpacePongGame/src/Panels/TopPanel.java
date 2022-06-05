package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel implements ActionListener{
	
	private boolean play = false;
	
	public final int initialTime = 15;
	
	private int time = initialTime;

	private int score = 0;
	private int lives = 3;
	private int level = 1;

	private Timer timer;

	//create labels 
	JLabel scoreLabel = new JLabel("Score: " + this.getScore() + "         ");
	JLabel livesLabel = new JLabel("Lives: " + this.getLives() + "         ");
	JLabel levelLabel = new JLabel("Level: " + this.getLevel() + "         ");
	JLabel timerLabel = new JLabel("Time Remaining: " + this.getTime() + "         ");
	
	
	//Constructor
	public TopPanel() {
		setBackground(Color.pink);

		
		//add labels to panel
		add(scoreLabel);
		add(livesLabel);
		add(levelLabel);
		add(timerLabel);
		
		
		timer = new Timer(1000,this); //timer for actionListener (calls every one second)
		timer.start(); //start the timer
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//reducing remaining time every second by one
		if (play) {
			this.setTime(this.getTime() - 1);
			timerLabel.setText("Time Remaining: " + this.getTime() + "         ");
		}	
	}
	
	
	//setters getters
	public Timer getTimer() {
		return timer;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public JLabel getLivesLabel() {
		return livesLabel;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public JLabel getTimerLabel() {
		return timerLabel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public int getLives() {
		return lives;
	}


	public void setLives(int lives) {
		this.lives = lives;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	
	
}










