import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = 0;
        int max = 0;
        final int[] di = {-1, 0, 1, 0};
        final int[] dj = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    num++;
                    int cnt = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    map[i][j] = 0;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] ij = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int ni = ij[0] + di[d];
                            int nj = ij[1] + dj[d];
                            if (0 <= ni && ni < n && 0 <= nj && nj < m && map[ni][nj] == 1) {
                                map[ni][nj] = 0;
                                cnt++;
                                q.offer(new int[]{ni, nj});
                            }
                        }
                    }
                    if (max < cnt) {
                        max = cnt;
                    }
                }
            }
        }
        System.out.println(num);
        System.out.println(max);
        br.close();
    }
}