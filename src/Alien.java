import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
Random rnd;
	public Alien(int x, int y, int w, int h) {
		super(x, y, w, h);
		rnd = new Random();
		// TODO Auto-generated constructor stub
	}
	void update() {
		y++;
		x += rnd.nextInt(3) - 1;
		super.update();
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, w, h, null);
	}
}
