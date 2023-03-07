import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	static int N, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j] - '0';
				}
			}
			System.out.println("#" + tc + " " + dijkstra());
		}

		br.close();
	}

	private static int dijkstra() {
		final int INF = Integer.MAX_VALUE;
		int[][] minTime = new int[N][N]; // 출발 정점에서 자신까지 이르는 최소 복구 시간
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2])); // r, c, 출발지에서 자신까지의
																									// 최소 비용
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minTime[i][j] = INF;
			}
		}
		minTime[0][0] = 0;
		pq.offer(new int[] { 0, 0, minTime[0][0] });
		while (true) {
			// step1
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int minCost = cur[2];
			if (visited[r][c])
				continue;
			visited[r][c] = true;
			if (r == N - 1 && c == N - 1)
				return minCost;
			// step2
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]
						&& minTime[nr][nc] > minCost + map[nr][nc]) {
					minTime[nr][nc] = minCost + map[nr][nc];
					pq.offer(new int[] { nr, nc, minTime[nr][nc] });
				}
			}
		}
	}
}