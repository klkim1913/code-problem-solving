import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                sb.delete(sb.length() - 3, sb.length());
                break;
            }
            a = new int[k];
            b = new int[6];
            for (int i = 0; i < k; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(b[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < k; i++) {
            b[cnt] = a[i];
            dfs(cnt + 1, i + 1);
        }
    }

}