import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map;
	static final int blank = 0;
	static final int cheeze = 1;
	// 현재 시간에 먹은 치즈 체크
	static final int ate = 2;
	static int left;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == cheeze)
					left++;
			}
		}
		int hour = 0;
		int prevCheeze = left;
		// 가장자리 치즈 탐색
		while (left != 0) {
			bfs();
			if (left != 0)
				prevCheeze = left;
			hour++;
		}
		System.out.println(hour);
		System.out.print(prevCheeze);
		br.close();
	}

	private static void bfs() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		boolean[][] v = new boolean[R][C];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[0][0] = true;
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < R && 0 <= nc && nc < C && !v[nr][nc] && map[nr][nc] != ate) {
					if (map[nr][nc] == cheeze) {
						left--;
						map[nr][nc] = ate;
						if (left == 0)
							break;
					} else {
						v[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
		// 먹은 치즈 제거
		if (left != 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == ate)
						map[i][j] = blank;
				}
			}
		}
	}

}