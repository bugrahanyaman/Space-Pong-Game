package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel extends JPanel implements ActionListener{

	//create the play/pause button
	JButton playButton = new JButton("Play/Pause");
	
	private MiddlePanel panel2;
	private TopPanel panel1;
	
	//Constructor
	public BottomPanel(MiddlePanel panel2, TopPanel panel1) {
		setBackground(Color.black);
		
		this.panel2 = panel2;
		this.panel1 = panel1;
		
		playButton.addActionListener(this);
		playButton.setBounds(462, 10, 100, 50);
		playButton.setBackground(Color.white);
		playButton.setVisible(true);
		playButton.setFocusable(false);
		
		add(playButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { //change the play flag if the button is clicked
		if(!panel2.getPlay()) {
			panel2.setPlay(true);
			panel1.setPlay(true);
		} else if(panel2.getPlay()){
			panel2.setPlay(false);
			panel1.setPlay(false);
		}
		
		
	}

}
