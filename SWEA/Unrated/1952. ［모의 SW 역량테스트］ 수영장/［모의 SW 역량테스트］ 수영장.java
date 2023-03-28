import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int min;
	static final int day = 0;
	static final int month = 1;
	static final int month3 = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] price = new int[3];
			for (int i = 0; i < 3; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int[] plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, price, plan);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void dfs(int mon, int total, int[] price, int[] plan) {
		if (total >= min)
			return;
		if (mon > 11) {
			if (min > total)
				min = total;
			return;
		}
		// 하루
		dfs(mon + 1, total + plan[mon] * price[day], price, plan);
		// 한달
		dfs(mon + 1, total + price[month], price, plan);
		// 세달
		dfs(mon + 3, total + price[month3], price, plan);
	}

}