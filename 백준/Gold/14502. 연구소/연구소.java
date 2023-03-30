import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 1. 빈칸좌표와 바이러스 좌표를 리스트에 담는다.
 * 2. 빈칸좌표 3개의 조합을 구한다.
 * 3. 3개에 놓은 후 바이러스를 dfs돌려서 다 채운다
 * 4. 빈칸의 수를 구한다.
 * - 빈칸의 수 - 3(벽) 의 값이 나오면 더 조합을 돌릴 필요가 없다.(종료)
 */
public class Main {
	static int N, M;
	static final int blank = 0;
	static final int wall = 1;
	static final int virus = 2;
	static int map[][];
	static List<int[]> bList;
	static List<int[]> vList;
	static int max = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		bList = new ArrayList<>();
		vList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == blank) {
					bList.add(new int[] { i, j });
				}
				if (map[i][j] == virus) {
					vList.add(new int[] { i, j });
				}
			}
		}
		comb(0, 0);
		System.out.print(max);
		br.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			spread();
			return;
		}
		for (int i = start; i < bList.size(); i++) {
			int r = bList.get(i)[0];
			int c = bList.get(i)[1];
			map[r][c] = wall;
			comb(cnt + 1, i + 1);
			map[r][c] = blank;
		}
	}

	private static void spread() {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[][] copy = copy(map);
		for (int i = 0; i < vList.size(); i++) {
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { vList.get(i)[0], vList.get(i)[1] });
			while (!q.isEmpty()) {
				int[] rc = q.poll();
				int r = rc[0];
				int c = rc[1];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (0 <= nr && nr < N && 0 <= nc && nc < M && copy[nr][nc] == blank) {
						copy[nr][nc] = virus;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
		checkSafe(copy);
	}

	private static void checkSafe(int[][] copy) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == blank) {
					cnt++;
				}
			}
		}
		if (max < cnt)
			max = cnt;
	}

	private static int[][] copy(int[][] arr) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

}