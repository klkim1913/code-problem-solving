import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		v = new boolean[100_001];

		bfs(N, K);

	}

	private static void bfs(int n, int K) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		if (n == K) {
			System.out.println(0);
			return;
		}
		v[n] = true;
		q.offer(new int[] { n, 0 });
		while (!q.isEmpty()) {
			int[] nd = q.poll();
			if (nd[0] == K) {
				System.out.println(nd[1]);
				break;
			}
			int a = nd[0] * 2;
			if (0 <= a && a <= 100_000 && !v[a]) {
				v[a] = true;
				q.offer(new int[] { a, nd[1] + 1 });
			}

			a = nd[0] - 1;
			if (0 <= a && a <= 100_000 && !v[a]) {
				v[a] = true;
				q.offer(new int[] { a, nd[1] + 1 });
			}

			a = nd[0] + 1;
			if (0 <= a && a <= 100_000 && !v[a]) {
				v[a] = true;
				q.offer(new int[] { a, nd[1] + 1 });
			}
		}
	}


}