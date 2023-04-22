import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (max < dp[i])
                max = dp[i];
            if (i + t <= N) {
                dp[i + t] = Math.max(dp[i + t], max + p);
            }
        }
        if (max < dp[N])
            max = dp[N];
        System.out.println(max);
        br.close();
    }

}