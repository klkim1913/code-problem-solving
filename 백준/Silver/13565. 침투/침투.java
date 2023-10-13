import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        boolean[][] v = new boolean[M][N];
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        for (int j = 0; j < N; j++) {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            if (map[0][j] == 0 && !v[0][j]) {
                v[0][j] = true;
                q.offer(new int[]{0, j});
                while (!q.isEmpty()) {
                    int[] ij = q.poll();
                    if (ij[0] == M - 1) {
                        System.out.println("YES");
                        return;
                    }
                    for (int d = 0; d < 4; d++) {
                        int ni = ij[0] + di[d];
                        int nj = ij[1] + dj[d];
                        if (0 <= ni && ni < M && 0 <= nj && nj < N && !v[ni][nj] && map[ni][nj] == 0) {
                            v[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
        }
        System.out.println("NO");
        br.close();
    }
}