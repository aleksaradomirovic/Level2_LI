import java.awt.Graphics;

public class GameObject {
	public GameObject(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		isAlive = true;
	}
	
	int x, y, w, h;
	boolean isAlive;
	
	void update() {
	}
	
	void draw(Graphics g) {
	}
}
