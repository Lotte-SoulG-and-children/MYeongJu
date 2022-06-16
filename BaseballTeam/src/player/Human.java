package player;

public class Human {

	String position;
	int num;
	String name;
	int age;
	double height;

	public Human(String position, int num, String name, int age, double height) {
		super();
		this.position = position;
		this.num = num;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
