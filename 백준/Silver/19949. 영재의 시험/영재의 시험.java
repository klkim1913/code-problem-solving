import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans = new int[10];
    static int[] pre = new int[10];
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 10; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(num);
        br.close();
    }

    private static void dfs(int cnt, int score) {
        if (cnt == 10) {
            if (score >= 5) {
                num++;
            }
            return;
        }
        for (int n = 1; n <= 5; n++) {
            if (cnt >= 2 && n == pre[cnt - 1] && n == pre[cnt - 2]) {
                continue;
            }
            pre[cnt] = n;
            if (ans[cnt] == n)
                dfs(cnt + 1, score + 1);
            else
                dfs(cnt + 1, score);
        }
    }
}