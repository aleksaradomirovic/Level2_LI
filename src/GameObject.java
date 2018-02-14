import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	public GameObject(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		isAlive = true;
		hitBox = new Rectangle(x,y,w,h);
	}
	
	int x, y, w, h;
	boolean isAlive;
	Rectangle hitBox;
	
	void update() {
		hitBox.setBounds(x,y,w,h);
	}
	
	void draw(Graphics g) {
	}
}
