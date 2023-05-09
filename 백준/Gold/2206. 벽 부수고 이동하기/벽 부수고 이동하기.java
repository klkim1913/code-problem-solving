import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Mal {
		int r;
		int c;
		int isBoom;
		int dis;

		public Mal(int r, int c, int isBoom, int dis) {
			this.r = r;
			this.c = c;
			this.isBoom = isBoom;
			this.dis = dis;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		final int[] di = { -1, 0, 1, 0 };
		final int[] dj = { 0, 1, 0, -1 };
		int ans=-1;
		boolean[][][] v = new boolean[N][M][2];
		ArrayDeque<Mal> q = new ArrayDeque<>();
		v[0][0][0] = true;
		q.offer(new Mal(0, 0, 0, 1));
		while (!q.isEmpty()) {
			Mal m = q.poll();
			if (m.r == N - 1 && m.c == M - 1) {
				ans=m.dis;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ni = m.r + di[d];
				int nj = m.c + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < M) {
					if (map[ni][nj] == 0 && !v[ni][nj][m.isBoom]) {
						v[ni][nj][m.isBoom] = true;
						q.offer(new Mal(ni, nj, m.isBoom, m.dis + 1));
					}
					if (m.isBoom == 0 && map[ni][nj] == 1) {
						v[ni][nj][1] = true;
						q.offer(new Mal(ni, nj, 1, m.dis + 1));
					}
				}
			}
		}
		System.out.println(ans);
		br.close();
	}

}