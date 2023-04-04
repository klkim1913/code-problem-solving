import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	static final int up = 0;
	static final int right = 1;
	static final int down = 2;
	static final int left = 3;
	static boolean[][] tunel = new boolean[8][4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 7; i++) {
			if (i == 1 || i == 2 || i == 4 || i == 7) {
				tunel[i][up] = true;
			}
			if (i == 1 || i == 3 || i == 4 || i == 5) {
				tunel[i][right] = true;
			}
			if (i == 1 || i == 2 || i == 5 || i == 6) {
				tunel[i][down] = true;
			}
			if (i == 1 || i == 3 || i == 6 || i == 7) {
				tunel[i][left] = true;
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 들어갈때는 반대방향이 오픈되있어하고 나갈때는 원래 오픈이 true일 경우 나갈 수 있다.
			// 방문처리 한곳도 들어갈 수 있게 하고 나중에 방문처리 한 곳을 모두 세면 된다.
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, 1, 0, -1 };
			int cnt = 0;
			boolean[][] v = new boolean[N][M];
			ArrayDeque<int[]> q = new ArrayDeque<>();
			v[R][C] = true;
			// 탈주범 좌표(r,c),거리
			q.offer(new int[] { R, C, 1 });
			while (!q.isEmpty()) {
				int[] rcd = q.poll();
				int r = rcd[0];
				int c = rcd[1];
				int distance = rcd[2];
				if (distance == L)
					break;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					// 갈 수 있는 최소 조건
					if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && !v[nr][nc]) {
						if (d == up && tunel[map[r][c]][d] && tunel[map[nr][nc]][down]) {
							v[nr][nc] = true;
							q.offer(new int[] { nr, nc, distance + 1 });
						} else if (d == right && tunel[map[r][c]][d] && tunel[map[nr][nc]][left]) {
							v[nr][nc] = true;
							q.offer(new int[] { nr, nc, distance + 1 });
						} else if (d == down && tunel[map[r][c]][d] && tunel[map[nr][nc]][up]) {
							v[nr][nc] = true;
							q.offer(new int[] { nr, nc, distance + 1 });
						} else if (d == left && tunel[map[r][c]][d] && tunel[map[nr][nc]][right]) {
							v[nr][nc] = true;
							q.offer(new int[] { nr, nc, distance + 1 });
						}

					}
				}
			}
			for (boolean[] bs : v) {
				for (boolean b : bs) {
					if (b)
						cnt++;
				}
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}