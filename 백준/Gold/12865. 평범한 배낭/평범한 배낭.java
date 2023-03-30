import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ws = new int[N + 1];
		int[] ps = new int[N + 1];
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ws[i] = Integer.parseInt(st.nextToken());
			ps[i] = Integer.parseInt(st.nextToken());
		}
		for (int n = 1; n <= N; n++) {
			for (int w = 1; w <= K; w++) {
				if (ws[n] > w) {
					dp[n][w] = dp[n - 1][w];
				} else {
					dp[n][w] = Math.max(dp[n - 1][w], ps[n] + dp[n - 1][w - ws[n]]);
				}
			}
		}
		System.out.print(dp[N][K]);
		br.close();
	}

}