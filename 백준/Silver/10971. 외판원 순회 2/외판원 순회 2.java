import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// - 도시들 사이에 길이 있을수도 없을수도 있다.
// - 한번 갔던 도시로는 다시 갈 수 없다.
// - 같은 도시간에도 비용은 대칭적이지 않다.
// - 자기 자신으로오는 길은 없다.
// - 갈 수 없는 경우는 0이다.
// !! 어느 한 도시에서 그 도시로 돌아오는 경우가 문제다.

// 큐를 이용해서 탐색한다.(BFS)
// N=10이기 때문에 2차원 배열로 표현할 수 있다.
// 지금까지 방문한 도시 수를 파라미터로 넘겨줘서 다 찼을경우 원래 도시로 방문할 수 있도록 한다.
// 비용 역시 파라미터로 넘겨줘서 기존에 저장된 최소 비용을 넘을 경우 백트래킹 할 수 있도록 한다.

public class Main {
	static int N, min;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			// 파라미터 의미: 현재 정점, 비용, 방문 도시 수
			dfs(i, i, 0, 1, new boolean[N]);
		}
		System.out.print(min);
		br.close();
	}

	private static void dfs(int vertex, int start, int cost, int cnt, boolean[] v) {
		v[vertex] = true;
		// 비용이 min을 넘으면 더 탐색하는게 의미 없으므로 다른 경로를 탐색하도록 리턴
		if (cost >= min)
			return;
		// 모든 정점을 다 순회했고
		if (cnt == N) {
			// 마지막 정점으로부터 원 정점으로 돌아올 수 있을때
			if (arr[vertex][start] != 0) {
				// min과 비용 비교
				if (min > cost + arr[vertex][start])
					min = cost + arr[vertex][start];
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!v[i] && arr[vertex][i] != 0) {
				dfs(i, start, cost + arr[vertex][i], cnt + 1, v);
				v[i] = false;
			}
		}
	}

}