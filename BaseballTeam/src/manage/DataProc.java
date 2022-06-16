package manage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import player.Batter;
import player.Human;
import player.Pitcher;

public class DataProc {

	File file;

	public void createFile() {
		file = new File("c:\\Temp\\baseballteamlist.txt");
	}

	public List<Human> load() {
		createFile();
		List<Human> loadList = new ArrayList<Human>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";

			while ((str = br.readLine()) != null) {
				String data[] = str.split("-");
				if (data[0].equals("pitcher")) {
					loadList.add(new Pitcher(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]),
							Double.parseDouble(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
							Double.parseDouble(data[7])));

				}else if(data[0].equals("batter")) {
					loadList.add(new Batter(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]),
							Double.parseDouble(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
							Double.parseDouble(data[7])));
				}

			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loadList;
	}

	public void save(List<Human> list) {
		createFile();
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < list.size(); i++) {
				Human h = list.get(i);
				String info = h.getPosition() + "-" + h.getNum() + "-" + h.getName() + "-" + h.getAge() + "-"
						+ h.getHeight();
				if (h.getPosition().equals("pitcher")) {
					pw.println(info + "-" + ((Pitcher) h).getWin() + "-" + ((Pitcher) h).getLose() + "-"
							+ ((Pitcher) h).getSafePercent());
				} else if (h.getPosition().equals("batter")) {
					pw.println(info + "-" + ((Batter) h).getHitter() + "-" + ((Batter) h).getHit() + "-"
							+ ((Batter) h).getHitPercent());
				}
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
