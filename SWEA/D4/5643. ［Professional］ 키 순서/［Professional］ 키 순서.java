import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			int[][] g = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계를 표현
			int[][] rg = new int[N + 1][N + 1]; // 자신보다 키가 작은 관계를 표현

			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a][b] = rg[b][a] = 1;
			}
			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				dfs(k, g, new boolean[N + 1]);
				dfs(k, rg, new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void dfs(int cur, int[][] g, boolean[] visited) {
		// g: 자신보다 큰관계 인접행렬이면 자신보다 큰 정접 탐색
		// g: 자신보다 작은관계 인접행렬이면 자신보다 큰 정접 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (g[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, g, visited);
			}
		}
	}

}