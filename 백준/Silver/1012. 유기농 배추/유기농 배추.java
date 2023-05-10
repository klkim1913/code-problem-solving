import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cnt = 0;
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			final int[] di = { -1, 0, 1, 0 };
			final int[] dj = { 0, 1, 0, -1 };
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						ArrayDeque<int[]> q = new ArrayDeque<>();
						map[i][j] = 0;
						q.offer(new int[] { i, j });
						while (!q.isEmpty()) {
							int[] ij = q.poll();
							for (int d = 0; d < 4; d++) {
								int ni = ij[0] + di[d];
								int nj = ij[1] + dj[d];
								if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1) {
									map[ni][nj] = 0;
									q.offer(new int[] { ni, nj });
								}
							}
						}
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
		br.close();
	}

}