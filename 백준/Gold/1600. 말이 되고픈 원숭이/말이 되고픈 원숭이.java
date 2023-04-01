import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static final int[] hdr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static final int[] hdc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static boolean[][][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		v = new boolean[H][W][31];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		// 행,열,동작수, 말처럼 이동 수
		v[0][0][0] = true;
		q.offer(new int[] { 0, 0, 0, 0 });
		while (!q.isEmpty()) {
			int[] el = q.poll();
			int r = el[0];
			int c = el[1];
			int cnt = el[2];
			int kcnt = el[3];
			if (r == H - 1 && c == W - 1) {
				min = cnt;
				break;
			}
			for (int d = 0; d < 8 && kcnt < K; d++) {
				int nr = r + hdr[d];
				int nc = c + hdc[d];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && !v[nr][nc][kcnt + 1] && arr[nr][nc] == 0) {
					v[nr][nc][kcnt+1] = true;
					q.offer(new int[] { nr, nc, cnt + 1, kcnt + 1 });
				}
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < H && 0 <= nc && nc < W && !v[nr][nc][kcnt] && arr[nr][nc] == 0) {
					v[nr][nc][kcnt] = true;
					q.offer(new int[] { nr, nc, cnt + 1, kcnt });
				}
			}
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.print(min);
		br.close();
	}

}