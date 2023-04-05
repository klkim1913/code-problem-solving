import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, cnt;
	static int[][] g;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			g = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계를 표현

			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a][b] = 1; // 유향
			}
			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				gtDFS(k, new boolean[N + 1]);
				ltDFS(k, new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	static void gtDFS(int cur, boolean[] visited) {
		// cur정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (g[cur][i] == 1 && !visited[i]) {
				cnt++;
				gtDFS(i, visited);
			}
		}
	}

	static void ltDFS(int cur, boolean[] visited) {
		// cur정점 기준으로 자신보다 큰 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (g[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}
	}

}