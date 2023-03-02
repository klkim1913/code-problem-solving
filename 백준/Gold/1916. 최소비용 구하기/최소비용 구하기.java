import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = -1;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (arr[from][to] == -1)
				arr[from][to] = weight;
			else if (arr[from][to] > weight)
				arr[from][to] = weight;
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		final long INF = Long.MAX_VALUE;
		long[] distance = new long[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(distance, INF);
		distance[start] = 0;

		long min;
		int current;
		for (int i = 1; i <= N; i++) {
			current = -1;
			min = INF;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			if (current == -1) {
				break;
			}
			visited[current] = true;
			if (current == end)
				break;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && arr[current][j] != -1 && distance[j] > min + arr[current][j]) {
					distance[j] = min + arr[current][j];
				}
			}
		}
		System.out.println(distance[end]);
		br.close();
	}

}