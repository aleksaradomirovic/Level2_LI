import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rocketship extends GameObject implements KeyListener{
	
	final int speed;
	boolean up, down, left, right;
	public Rocketship(int x, int y, int w, int h) {
		super(x, y, w, h);
		speed = 10;
	}
	void update() {
		if(up) {
			y-=speed;
		} if(down) {
			y+=speed;
		} if(left) {
			x-=speed;
		} if(right) {
			x+=speed;
		}
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, w, h, null);
		up = false; down = false; left = false; right = false;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
