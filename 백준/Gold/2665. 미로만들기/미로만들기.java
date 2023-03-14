import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static int[][] arr;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
				arr[i][j] = (arr[i][j] == 1) ? 0 : 1;
			}
		}
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = N * N;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		dist[0][0] = 0;
		pq.offer(new int[] { 0, 0, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int i = cur[0];
			int j = cur[1];
			int black = cur[2];
			if (v[i][j])
				continue;
			v[i][j] = true;
			if (i == N - 1 && j == N - 1)
				break;
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && dist[ni][nj] > black + arr[ni][nj]) {
					dist[ni][nj] = black + arr[ni][nj];
					pq.offer(new int[] { ni, nj, dist[ni][nj] });
				}
			}
		}
		System.out.println(dist[N - 1][N - 1]);
		br.close();
	}

}