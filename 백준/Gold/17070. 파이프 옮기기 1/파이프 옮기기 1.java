import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 각 칸은 빈칸 or 벽
 파이프는 2개의 연속된 칸을 차지
 */

/*
 * 파이프의 첫 방향은 가로이고 이동 기준으로 우면 가로, 우하면 대각, 하면 세로로 상태 바뀜
 * 파이프의 끝좌표를 기준으로 가로일때 우, 우하(우하의 상 좌 비어있어야됨)
 * 세로일때 우하(우하의 상좌까지), 하
 * 대각일때 우, 우하(우하의 상 좌), 하가 비면 갈 수 있음
 * 
 * dfs로 이동하다 범위를 벗어나거나 n,n에 도착하면 cnt++
 * 같은점에 다시 올수는 없기 때문에 방문처리는 필요 X
 */
public class Main {
	// 한글 변수 사용해보고싶어서 사용
	static final int 우 = 0;
	static final int 우하 = 1;
	static final int 하 = 2;
	static final int[] dr = { 0, 1, 1 };
	static final int[] dc = { 1, 1, 0 };
	static final int 빈칸 = 0;
	static final int 벽 = 1;
	// 초기값은 오른쪽
	static int N;
	static int[][] arr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dir = 우;
		dfs(0, 1, dir);
		System.out.print(result);
		br.close();
	}

	private static void dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			result++;
			return;
		}
		if (dir == 우) {
			int[] ds = new int[] { 우, 우하 };
			search(r, c, ds);
		} else if (dir == 우하) {
			int[] ds = new int[] { 우, 우하, 하 };
			search(r, c, ds);
		} else if (dir == 하) {
			int[] ds = new int[] { 우하, 하 };
			search(r, c, ds);
		}
	}

	private static void search(int r, int c, int[] ds) {
		for (int d : ds) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isInRange(nr, nc) && arr[nr][nc] == 빈칸) {
				if (d == 우하) {
					if (arr[nr - 1][nc] == 빈칸 && arr[nr][nc - 1] == 빈칸) {
						dfs(nr, nc, d);
					}
				} else {
					dfs(nr, nc, d);
				}
			}
		}
	}

	private static boolean isInRange(int nr, int nc) {
		return (0 <= nr && nr < N && 0 <= nc && nc < N);
	}

}