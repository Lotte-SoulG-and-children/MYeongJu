package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import manage.BaseballDao;
import manage.DataProc;
import player.Human;

/* list를 DAO 안에서 만들어 객체를 들고다니지 말자! */

public class MainClass {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		BaseballDao baseballDao = new BaseballDao();
		List<Human> playerList = new ArrayList<Human>();
		DataProc dp = new DataProc();

		playerList = dp.load();

		while (true) {
			System.out.println("<<MENU>>");
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("3. 검색");
			System.out.println("4. 수정");
			System.out.println("5. 출력");
			System.out.println("6. 저장");
			System.out.println("7. 종료");
			System.out.print("메뉴 번호를 입력해 주세요 >> ");
			int input = scanner.nextInt();

			switch (input) {
			case 1:
				baseballDao.add(playerList);
				break;
			case 2:
				baseballDao.delete(playerList);
				break;
			case 3:
				baseballDao.select(playerList);
				break;
			case 4:
				break;
			case 5:
				baseballDao.printAll(playerList);
				break;
			case 6:
				dp.save(playerList);
				break;
			case 7:
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}
}
