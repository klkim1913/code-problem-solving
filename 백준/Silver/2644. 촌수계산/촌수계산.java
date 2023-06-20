import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] g = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a][b] = 1;
            g[b][a] = 1;
        }
        boolean[] v = new boolean[n+1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[p1] = true;
        q.offer(new int[]{p1, 0});
        int answer = -1;
        while (!q.isEmpty()) {
            int[] pd = q.poll();
            if (pd[0] == p2) {
                answer = pd[1];
            }
            for (int i = 1; i <= n; i++) {
                if (!v[i] && g[pd[0]][i] == 1) {
                    v[i] = true;
                    q.offer(new int[]{i, pd[1] + 1});
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}