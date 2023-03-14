import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int i = cur[0];
			int j = cur[1];
			int black = cur[2];
			if (v[i][j])
				continue;
			v[i][j] = true;
			if (i == N - 1 && j == N - 1) {
				System.out.println(black);
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
					if (arr[ni][nj] == 0)
						q.offer(new int[] { ni, nj, black + 1 });
					else
						q.push(new int[] { ni, nj, black });
				}
			}
		}
		br.close();
	}

}