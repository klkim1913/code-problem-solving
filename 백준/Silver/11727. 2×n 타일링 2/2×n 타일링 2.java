import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 1;
		if (n > 1) {
			dp[2] = 3;
			int p = 10007;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] % p + (dp[i - 2] * 2) % p;
				dp[i] %= p;
			}
		}
		System.out.println(dp[n]);
	}

}