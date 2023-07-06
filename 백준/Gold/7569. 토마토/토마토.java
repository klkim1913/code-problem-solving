import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[H][N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int left = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int t = Integer.parseInt(st.nextToken());
                    map[k][i][j] = t;
                    if (t == 0) {
                        left++;
                    } else if (t == 1) {
                        q.offer(new int[] { k, i, j, 0 });
                    }
                }
            }
        }
        int[] di = { -1, 0, 1, 0, 0, 0 };
        int[] dj = { 0, 1, 0, -1, 0, 0 };
        int[] dh = { 0, 0, 0, 0, 1, -1 };
        int answer = 0;
        end: while (!q.isEmpty()) {
            int[] hnm = q.poll();
            int h = hnm[0];
            int n = hnm[1];
            int m = hnm[2];
            int day = hnm[3];
            for (int d = 0; d < 6; d++) {
                int ni = n + di[d];
                int nj = m + dj[d];
                int nh = h + dh[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nh && nh < H && map[nh][ni][nj] == 0) {
                    map[nh][ni][nj] = 1;
                    left--;
                    q.offer(new int[] { nh, ni, nj, day + 1 });
                    if (left == 0) {
                        answer = day + 1;
                        break end;
                    }
                }
            }
        }
        if (left == 0)
            System.out.println(answer);
        else
            System.out.println(-1);
        br.close();
    }
}
