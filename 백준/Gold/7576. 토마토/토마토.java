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
        int[][] map = new int[M][N];
        int total = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    total++;
                } else if (map[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int day = 0;
        while (!q.isEmpty() && total > 0) {
            int[] ij = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = ij[0] + di[d];
                int nj = ij[1] + dj[d];
                if (0 <= ni && ni < M && 0 <= nj && nj < N && map[ni][nj] == 0) {
                    total--;
                    map[ni][nj] = 1;
                    q.offer(new int[]{ni, nj, ij[2] + 1});
                }
            }
            day = ij[2] + 1;
        }
        if (total == 0) {
            System.out.print(day);
        } else {
            System.out.print(-1);
        }
        br.close();
    }
}