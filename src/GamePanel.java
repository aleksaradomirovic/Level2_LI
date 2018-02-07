import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer cap;
	boolean keyDown = false;
	final int MENU_STATE = 0, GAME_STATE = 1, END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Font generalFont;
	// TODO make sure this appears
	Rocketship rocket = new Rocketship(250,700,50,50);
	ObjectManager obj = new ObjectManager(rocket);
	
	void updateMenu() {
		
	}
	void updateGame() {
		obj.update();
	}
	void updateEnd() {
		
	}
	
	void drawMenu(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0,LeagueInvaders.w,LeagueInvaders.h);
		
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 25, 100);
		
		g.setFont(generalFont);
		g.drawString("Press ENTER", 150, 400);
		g.drawString("SPACE for Instructions", 100, 600);
	}
	void drawGame(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,LeagueInvaders.w,LeagueInvaders.h);
		obj.draw(g);
	}
	void drawEnd(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0,0,LeagueInvaders.w,LeagueInvaders.h);
		
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 400);
	}
	
	public GamePanel() {
		cap = new Timer(1000/60, this);
		titleFont = new Font("Arial",Font.PLAIN,48);
		generalFont = new Font("Arial",Font.PLAIN,24);
	}
	
	void startGame() {
		cap.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE) {
			updateMenu();
		} else if(currentState == GAME_STATE) {
			updateGame();
		} else if(currentState == END_STATE) {
			updateEnd();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE) {
			drawMenu(g);
		} else if(currentState == GAME_STATE) {
			drawGame(g);
		} else if(currentState == END_STATE) {
			drawEnd(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KeyPressed");
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState < END_STATE) {
				currentState++;
			} else {
				currentState = MENU_STATE;
			}
		}
		rocket.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_SPACE && keyDown == false) {
			obj.addProjectile(new Projectile(rocket.x + 25, rocket.y, 10, 20));
			keyDown = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyReleased");
		keyDown = false;
	}
}
