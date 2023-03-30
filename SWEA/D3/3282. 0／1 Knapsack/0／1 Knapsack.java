import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] weights = new int[N + 1];
			int[] profits = new int[N + 1];
			int[][] dp = new int[N + 1][K + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				weights[i] = Integer.parseInt(st.nextToken());
				profits[i] = Integer.parseInt(st.nextToken());
			}
			for (int n = 1; n <= N; n++) {
				for (int w = 1; w <= K; w++) {
					if (weights[n] > w) {
						dp[n][w] = dp[n - 1][w];
					} else {
						dp[n][w] = Math.max(dp[n - 1][w], profits[n] + dp[n - 1][w - weights[n]]);
					}
				}
			}
			sb.append("#" + tc + " " + dp[N][K] + "\n");
		}
		System.out.print(sb);
		br.close();
	}
}