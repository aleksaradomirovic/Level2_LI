import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Rocketship rocket;
	final long spawnGap = 2000, uncertainty = 1000;
	long Timer;
	int score = 0;
	public ObjectManager(Rocketship r) {
		rocket = r;
		
	}
	void update() {
		rocket.update();
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}
	void draw(Graphics g) {
		rocket.draw(g);
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		g.setColor(Color.RED);
		g.drawString(""+score+"", 0, 15);
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void addAlien(Alien a) {
		aliens.add(a);
	}
	void manageEnemies() {
		if(System.currentTimeMillis() - Timer >= spawnGap) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.w),0,50,50));
			Timer = System.currentTimeMillis();
		}
	}
	void purgeObjects() {
		for(int i = 0; i < aliens.size(); i++) {
			if(!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for(int i = 0; i < projectiles.size(); i++) {
			if(!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
		
	}
	void checkCollision() {
		for(Alien a : aliens) {
			if(rocket.hitBox.intersects(a.hitBox)) {
				rocket.isAlive = false;
			}
		}
		for(Alien a : aliens) {
			for(Projectile p : projectiles) {
				if(a.hitBox.intersects(p.hitBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score++;
				}
			}
		}
	}
}
