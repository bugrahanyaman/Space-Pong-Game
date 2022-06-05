import java.awt.BorderLayout;

import javax.swing.JFrame;


import Panels.BottomPanel;
import Panels.MiddlePanel;
import Panels.TopPanel;

public class Main {
	static JFrame frame = new JFrame(); //create frame for the game
	public static void main(String[] args) {
		
		frame.setTitle("Space Pong"); //frame title
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1024,768); //set size of the frame
		
		//create panels (3)
		TopPanel panel1 = new TopPanel();	 
		MiddlePanel panel2 = new MiddlePanel(panel1);
		BottomPanel panel3 = new BottomPanel(panel2 , panel1);
		
		//add panels to frame
		frame.getContentPane().add(panel1, BorderLayout.PAGE_START);
		frame.getContentPane().add(panel2, BorderLayout.CENTER);
		frame.getContentPane().add(panel3, BorderLayout.PAGE_END);
		
		frame.setVisible(true); //set frame visible
	}

}
