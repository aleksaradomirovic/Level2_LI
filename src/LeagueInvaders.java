import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gameScreen;
	public LeagueInvaders() {
		frame = new JFrame();
		gameScreen = new GamePanel();
	}
	
	void setup() {
		frame.add(gameScreen);
		frame.addKeyListener(gameScreen);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(w,h));
		frame.pack();
		
		gameScreen.startGame();
	}
	
	static final int w = 500, h = 800;
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
}