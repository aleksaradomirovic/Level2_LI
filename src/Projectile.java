import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	
	int speed = 10;
	public Projectile(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	void update() {
		y -= speed;
		if(y < 0) {
			isAlive = false;
		}
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, w, h, null);
	}
}
