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
			int[] plan = new int[13];
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			int dp[] = new int[13];
			for (int i = 1; i <= 12; i++) {
				dp[i] = Integer.MAX_VALUE;
			}
			dp[0] = 0;
			for (int i = 1; i <= 12; i++) {
				dp[i] = Math.min(dp[i - 1] + price[day] * plan[i], dp[i - 1] + price[month]);
				if (i - 3 >= 0) {
					dp[i] = Math.min(dp[i], dp[i - 3] + price[month3]);
				}
			}
			if (min > dp[12])
				min = dp[12];
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}