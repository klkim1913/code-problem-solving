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
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        boolean[][] v = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        v[0][0] = true;
        q.offer(new int[] {0, 0, 1});
        while (!q.isEmpty()) {
            int[] ijd = q.poll();
            int i = ijd[0];
            int j = ijd[1];
            int dis = ijd[2];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1 && !v[ni][nj]) {
                    if (ni == N - 1 && nj == M - 1) {
                        System.out.println(dis + 1);
                        return;
                    }
                    v[ni][nj] = true;
                    q.offer(new int[] {ni, nj, dis + 1});
                }
            }
        }
        br.close();
    }

}