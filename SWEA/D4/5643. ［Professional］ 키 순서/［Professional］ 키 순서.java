import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> g = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				g.add(new ArrayList<>());
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				g.get(from).add(to);
			}
			boolean connected[][];
			connected = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i != j) {
						for (int n : g.get(i)) {
							if (n == j)
								connected[i][j] = true;
						}
					}
				}
			}
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (connected[i][k] && connected[k][j]) {
							connected[i][j] = true;
						}
					}
				}
			}
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) {
						if (i == N && j == N) {
							sum++;
						}
						continue;
					}
					if (!connected[i][j] && !connected[j][i])
						break;
					if (j == N)
						sum++;
				}
			}
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}