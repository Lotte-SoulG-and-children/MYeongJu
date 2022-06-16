package player;

public class Batter extends Human {
	int hitter; // 타수
	int hit; // 안타수
	double hitPercent; // 타율

	public Batter(String position, int num, String name, int age, double height, int hitter, int hit, double hitPercent) {
		super(position, num, name, age, height);
		this.hitter = hitter;
		this.hit = hit;
		this.hitPercent = hitPercent;
	}

	public int getHitter() {
		return hitter;
	}

	public void setHitter(int hitter) {
		this.hitter = hitter;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitPercent() {
		return hitPercent;
	}

	public void setHitPercent(double hitPercent) {
		this.hitPercent = hitPercent;
	}

}
