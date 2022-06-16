package player;

public class Pitcher extends Human {
	int win;
	int lose;
	double safePercent; // 방어율

	public Pitcher(String position, int num, String name, int age, double height, int win, int lose, double safePercent) {
		super(position, num, name, age, height);
		this.win = win;
		this.lose = lose;
		this.safePercent = safePercent;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getSafePercent() {
		return safePercent;
	}

	public void setSafePercent(double safePercent) {
		this.safePercent = safePercent;
	}

}
