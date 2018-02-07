import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rocketship extends GameObject implements KeyListener{
	
	int speed;
	boolean up, down, left, right;
	public Rocketship(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 5;
	}
	void update() {
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, w, h);
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			y -= speed;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += speed;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= speed;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += speed;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
