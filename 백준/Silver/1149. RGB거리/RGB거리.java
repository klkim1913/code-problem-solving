import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][1] + n, dp[i - 1][2] + n);
				} else if (j == 1) {
					dp[i][j] = Math.min(dp[i - 1][0] + n, dp[i - 1][2] + n);
				} else {
					dp[i][j] = Math.min(dp[i - 1][0] + n, dp[i - 1][1] + n);
				}
			}
		}
		int min = dp[N - 1][0];
		if (dp[N - 1][1] < min)
			min = dp[N - 1][1];
		if (dp[N - 1][2] < min)
			min = dp[N - 1][2];
		System.out.print(min);
		br.close();
	}

}