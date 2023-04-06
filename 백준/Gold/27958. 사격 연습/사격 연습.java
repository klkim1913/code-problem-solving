import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] map;
	static int[] bullets;
	static int max = 0;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		bullets = new int[K];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			bullets[i] = Integer.parseInt(st.nextToken());
		}
		perm(0, 0, map, map);
		System.out.print(max);
		br.close();
	}

	private static void perm(int cnt, int score, int[][] copy, int[][] initHP) {
		if (cnt == K) {
			if (max < score)
				max = score;
			return;
		}
		for (int j = 0; j < N; j++) {
			int[][] newMap = copyMap(copy);
			int[][] newHP = copyMap(initHP);
			perm(cnt + 1, score + shoot(j, cnt, newMap, newHP), newMap, newHP);
		}
	}

	private static int shoot(int r, int bullet, int[][] newMap, int[][] newHP) {
		int getScore = 0;
		for (int j = 0; j < N; j++) {
			if (newMap[r][j] == 0)
				continue;
			if (newMap[r][j] < 10) {
				newMap[r][j] -= bullets[bullet];
				if (newMap[r][j] <= 0) {
					getScore = newHP[r][j];
					newMap[r][j] = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + di[d];
						int nj = j + dj[d];
						if (0 <= nr && nr < N && 0 <= nj && nj < N && newMap[nr][nj] == 0) {
							newMap[nr][nj] = newHP[r][j] / 4;
							newHP[nr][nj] = newMap[nr][nj];
						}
					}
				}
				return getScore;
			}
			if (newMap[r][j] >= 10) {
				getScore = newMap[r][j];
				newMap[r][j] = 0;
				newHP[r][j] = 0;
				return getScore;
			}
		}
		return getScore;
	}

	private static int[][] copyMap(int[][] arr) {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

}