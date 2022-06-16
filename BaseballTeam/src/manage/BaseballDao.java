package manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import player.Batter;
import player.Human;
import player.Pitcher;

public class BaseballDao {
	Scanner scanner = new Scanner(System.in);
	private int counter;
	DataProc dp = new DataProc();

	public void add(List<Human> list) {
		counter = list.get(list.size() - 1).getNum() + 1;
		System.out.print("이름 = ");
		String name = scanner.next();
		System.out.print("나이 = ");
		int age = scanner.nextInt();
		System.out.print("키 = ");
		double height = scanner.nextDouble();
		System.out.print("포지션 = ");
		String position = scanner.next();

		if (position.equals("pitcher")) {
			System.out.print("승 = ");
			int win = scanner.nextInt();
			System.out.print("패 = ");
			int lose = scanner.nextInt();
			System.out.print("방어율 = ");
			double safePercent = scanner.nextDouble();
			list.add(new Pitcher("pitcher", counter, name, age, height, win, lose, safePercent));
		} else if (position.equals("batter")) {
			System.out.print("타수 = ");
			int hitter = scanner.nextInt();
			System.out.print("안타수 = ");
			int hit = scanner.nextInt();
			System.out.print("타율 = ");
			double hitPercent = scanner.nextDouble();
			list.add(new Batter("batter", counter, name, age, height, hitter, hit, hitPercent));
		}
		counter++;

	}

	public void delete(List<Human> list) {
		System.out.print("삭제하고자 하는 선수 이름 >> ");
		String name = scanner.next();
		int index = search(list, name);
		if (index < 0) {
			System.out.println("이름을 찾을 수 없습니다.");
			return;
		}
		list.remove(index);
	}

	public void select(List<Human> list) {
		System.out.print("검색하고자 하는 선수 이름 >> ");
		String name = scanner.next();
		List<Human> result = searchAll(list, name);
		printAll(result);
	}

	public List<Human> searchAll(List<Human> list, String name) {
		List<Human> findList = new ArrayList<Human>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				findList.add(list.get(i));
			}
		}
		return findList;
	}

	public int search(List<Human> list, String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	public void update(List<Human> list) {
		System.out.print("수정하고자 하는 선수 이름 >> ");
		String name = scanner.next();
		int index = search(list, name);
		if (index < 0) {
			System.out.println("이름을 찾을 수 없습니다.");
			return;
		}

	}

	public void printAll(List<Human> list) {
		for (int i = 0; i < list.size(); i++) {
			Human human = list.get(i);
			System.out.print("번호: " + human.getNum() + "\t이름: " + human.getName() + "\t나이: " + human.getAge() + "\t키: "
					+ human.getHeight());
			if (human.getPosition().equals("pitcher")) {
				System.out.print("\t승: " + ((Pitcher) human).getWin() + "\t패: " + ((Pitcher) human).getLose()
						+ "\t방어율: " + ((Pitcher) human).getSafePercent());
			} else if (human.getPosition().equals("batter")) {
				System.out.print("\t타수: " + ((Batter) human).getHitter() + "\t안타수: " + ((Batter) human).getHitter()
						+ "\t타율: " + ((Batter) human).getHitPercent());
			}
			System.out.println();
		}
	}

}
