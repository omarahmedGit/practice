package faceBookHackerCup;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BasketBallCame {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("b.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("bout.txt"));
		int t = sc.nextInt();
		for (int ii = 0; ii < t; ii++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int p = sc.nextInt();
			ArrayList<Player> allplayers = new ArrayList<Player>();
			for (int i = 0; i < n; i++) {
				String a = sc.next();
				int b = sc.nextInt();
				int c = sc.nextInt();
				allplayers.add(new Player(a, b, c, 0));
			}
			Collections.sort(allplayers, new Comparator<Player>() {

				@Override
				public int compare(Player o1, Player o2) {
					if (o1.shot == o2.shot)
						return o2.hight - o1.hight;
					return o2.shot - o1.shot;
				}
			});
			;
			ArrayList<Player> team1 = new ArrayList<Player>();
			ArrayList<Player> team2 = new ArrayList<Player>();
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					team1.add(allplayers.get(i));
				else
					team2.add(allplayers.get(i));
			}
			ArrayList<Player> team1a = new ArrayList<Player>();
			ArrayList<Player> team2a = new ArrayList<Player>();
			ArrayList<Player> team1b = new ArrayList<Player>();
			ArrayList<Player> team2b = new ArrayList<Player>();

			for (int i = 0; i < team1.size(); i++) {
				if (i < p)
					team1a.add(team1.get(i));
				else
					team1b.add(team1.get(i));
			}
			for (int i = 0; i < team2.size(); i++) {
				if (i < p)
					team2a.add(team2.get(i));
				else
					team2b.add(team2.get(i));
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < team1a.size(); j++) {
					team1a.get(j).time++;
				}
				for (int j = 0; j < team2a.size(); j++) {
					team2a.get(j).time++;
				}
//				for (int ix = 0; ix < team1a.size(); ix++) {
//					System.out.println(team1a.get(ix).name+" "+team1a.get(ix).shot+" "+team1a.get(ix).time);
//				}
//				System.out.println();
//				for (int ix = 0; ix < team2a.size(); ix++) {
//					System.out.println(team2a.get(ix).name+" "+team2a.get(ix).shot+" "+team2a.get(ix).time);
//				}
//				System.out.println();
				if (team1.size() > p) {
					Collections.sort(team1a, new Comparator<Player>() {

						@Override
						public int compare(Player o1, Player o2) {
							if (o1.time == o2.time)
								return o1.shot - o2.shot;
							return o2.time - o1.time;
						}
					});
					Collections.sort(team1b, new Comparator<Player>() {

						@Override
						public int compare(Player o1, Player o2) {
							if (o1.time == o2.time)
								return o2.shot - o1.shot;
							return o1.time - o2.time;
						}
					});

					Player temp1 = new Player(team1a.get(0).name,
							team1a.get(0).shot, team1a.get(0).hight,
							team1a.get(0).time);
					Player temp2 = new Player(team1b.get(0).name,
							team1b.get(0).shot, team1b.get(0).hight,
							team1b.get(0).time);
					team1a.remove(0);
					team1b.remove(0);
					team1a.add(temp2);
					team1b.add(temp1);
				}
				if (team2.size() > p) {
					Collections.sort(team2a, new Comparator<Player>() {

						@Override
						public int compare(Player o1, Player o2) {
							if (o1.time == o2.time)
								return o1.shot - o2.shot;
							return o2.time - o1.time;
						}
					});
					Collections.sort(team2b, new Comparator<Player>() {

						@Override
						public int compare(Player o1, Player o2) {
							if (o1.time == o2.time)
								return o2.shot - o1.shot;
							return o1.time - o2.time;
						}
					});

					Player temp11 = new Player(team2a.get(0).name,
							team2a.get(0).shot, team2a.get(0).hight,
							team2a.get(0).time);
					Player temp22 = new Player(team2b.get(0).name,
							team2b.get(0).shot, team2b.get(0).hight,
							team2b.get(0).time);
					team2a.remove(0);
					team2b.remove(0);
					team2a.add(temp22);
					team2b.add(temp11);
				}
			}
			ArrayList<String> ans = new ArrayList<String>();
			for (int i = 0; i < team1a.size(); i++) {
				ans.add(team1a.get(i).name);
			}
			for (int i = 0; i < team2a.size(); i++) {
				ans.add(team2a.get(i).name);
			}
			Collections.sort(ans);
			pw.printf("Case #%d: ",ii+1);
			for (int i = 0; i < ans.size(); i++) {
				pw.print(ans.get(i));
				if(i+1<ans.size())
					pw.print(" ");
			}
			pw.println();
		}
		sc.close();
		pw.close();
	}

	public static class Player {
		String name;
		int shot, hight, time;

		public Player(String n, int s, int h, int t) {
			name = n;
			shot = s;
			hight = h;
			time = t;
		}
	}

}
