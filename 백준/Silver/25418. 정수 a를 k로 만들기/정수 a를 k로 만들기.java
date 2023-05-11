import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { A, 0 });
		boolean[] v = new boolean[K + 1];
		while (!q.isEmpty()) {
			int[] nd = q.poll();
			if (nd[0] == K) {
				System.out.print(nd[1]);
				break;
			}
			if (nd[0] + 1 <= K && !v[nd[0] + 1]) {
				v[nd[0] + 1] = true;
				q.offer(new int[] { nd[0] + 1, nd[1] + 1 });
			}
			if (nd[0] * 2 <= K && !v[nd[0] * 2]) {
				v[nd[0] * 2] = true;
				q.offer(new int[] { nd[0] * 2, nd[1] + 1 });
			}
		}
		br.close();
	}

}