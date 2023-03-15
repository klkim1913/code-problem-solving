import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		int[] dist = new int[N];
		boolean[] v = new boolean[N];
		for (int i = 0; i < N; i++) {
			g.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			g.get(from).add(to);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		dist[X] = 0;
		pq.offer(new int[] { X, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int vertex = cur[0];
			int min = cur[1];
			if (v[vertex])
				continue;
			v[vertex] = true;
			for (int n : g.get(vertex)) {
				if (!v[n] && dist[n] > min + 1) {
					dist[n] = min + 1;
					pq.offer(new int[] { n, dist[n] });
				}
			}
		}
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (dist[i] == K)
				answer.add(i + 1);
		}
		Collections.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (int n : answer) {
			sb.append(n + "\n");
		}
		if (answer.size() == 0)
			System.out.println(-1);
		else
			System.out.print(sb);
		br.close();
	}

}