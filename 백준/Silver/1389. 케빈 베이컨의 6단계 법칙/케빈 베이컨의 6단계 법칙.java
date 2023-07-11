import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] g = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a][b] = true;
            g[b][a] = true;
        }
        int min = Integer.MAX_VALUE;
        int answer=1;
        for (int i = 1; i <= N; i++) {
            boolean[] v = new boolean[N + 1];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int sum = 0;
            v[i] = true;
            q.offer(new int[]{i, 0});
            while (!q.isEmpty()) {
                int[] nd = q.poll();
                for (int j = 1; j <= N; j++) {
                    if (g[nd[0]][j] && !v[j]) {
                        v[j] = true;
                        q.offer(new int[]{j, nd[1] + 1});
                        sum += nd[1] + 1;
                    }
                }
            }
            if (min > sum) {
                min = sum;
                answer = i;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
