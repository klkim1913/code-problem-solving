import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static final char blank = '.';
	static final char wall = '#';
	static final char now = '0';
	static final char exit = '1';
	static int si, sj;
	static int min = Integer.MAX_VALUE;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == now) {
					si = i;
					sj = j;
					map[i][j] = blank;
				}
			}
		}
		// 열쇠를 얻는 순간 방문처리 풀기?가 아니라 3차원 배열
		// 열쇠 먹으면 그곳은 빈칸으로 바꿔야 함

		boolean[][][] v = new boolean[N][M][1 << 6];
		v[si][sj][0] = true;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		// 현재위치 i,j,거리,키
		q.offer(new int[] { si, sj, 0, 0});
		end: while (!q.isEmpty()) {
			int[] ij = q.poll();
			si = ij[0];
			sj = ij[1];
			int dis = ij[2];
			int key = ij[3];

			for (int d = 0; d < 4; d++) {
				int ni = si + di[d];
				int nj = sj + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj][key]) {
					if (map[ni][nj] == exit) {
						min = dis + 1;
						break end;
					}
					if (map[ni][nj] == wall)
						continue;
					// 키면 앞으로 문 열수 있음
					if ('a' <= map[ni][nj] && map[ni][nj] <= 'f') {
						v[ni][nj][key] = true;
						q.offer(new int[] { ni, nj, dis + 1, key | (1 << (map[ni][nj] - 'a')) });
						// 문일때 열려있을때만 들어갈 수 있음
					} else if ('A' <= map[ni][nj] && map[ni][nj] <= 'F' && (key & (1 << (map[ni][nj] - 'A'))) != 0) {
						v[ni][nj][key] = true;
						q.offer(new int[] { ni, nj, dis + 1, key });
					} else if (map[ni][nj] == blank) {
						v[ni][nj][key] = true;
						q.offer(new int[] { ni, nj, dis + 1, key });
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.print(min);
		br.close();
	}

}