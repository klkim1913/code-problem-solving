import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        int answer = 0;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    answer++;
                    map[i][j] = 1;
                    int sum = 1;
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] ij = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int ni = ij[0] + di[d];
                            int nj = ij[1] + dj[d];
                            if (0 <= ni && ni < M && 0 <= nj && nj < N && map[ni][nj] == 0) {
                                map[ni][nj] = 1;
                                sum++;
                                q.offer(new int[]{ni, nj});
                            }
                        }
                    }
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        System.out.println(answer);
        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            sb.append(n).append(' ');
        }
        System.out.print(sb);
        br.close();
    }
}