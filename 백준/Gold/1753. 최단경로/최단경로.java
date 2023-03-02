import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static List<int[]>[] g;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		g = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			g[i] = new ArrayList<>();
		}
		v = new boolean[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] { to, weight });
		}

		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V + 1];
		v = new boolean[V + 1];

		Arrays.fill(distance, INF);
		distance[start] = 0;

		int min, current;
		for (int c = 0; c < V; c++) {
			current = -1;
			min = INF;

			for (int i = 1; i <= V; i++) {
				if (!v[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			if (current == -1) {
				break;
			}
			v[current] = true;

			for (int[] vw : g[current]) {
				int n = vw[0];
				int w = vw[1];
				if (!v[n] && distance[n] > min + w) {
					distance[n] = min + w;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] != INF) {
				sb.append(distance[i]);
			} else {
				sb.append("INF");
			}
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}