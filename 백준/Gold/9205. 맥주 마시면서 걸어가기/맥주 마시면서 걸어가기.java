import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 한박스 맥주 20개
// 50미터에 한병씩 마셔야함
// 편의점에 들릴 시 빈 병은 버리고 새 맥주 살 수 있음(최대 20병 보유 가능)
public class Main {
	static int n;
	static boolean[][] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			distance = new boolean[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (canMove(arr[i], arr[j]))
						distance[i][j] = true;
				}
			}

			sb.append(bfs()).append('\n');
		}
		System.out.print(sb);
		br.close();
	}

	private static String bfs() {
		boolean[][] v = new boolean[n + 2][n + 2];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v[0][0] = true;
		q.offer(0);
		while (!q.isEmpty()) {
			int i = q.poll();
			if (i == n + 1)
				return "happy";
			for (int j = 1; j < n + 2; j++) {
				if (distance[i][j] && !v[i][j]) {
					v[i][j] = true;
					q.offer(j);
				}
			}
		}
		return "sad";
	}

	private static boolean canMove(int[] dot1, int[] dot2) {
		return Math.abs(dot1[0] - dot2[0]) + Math.abs(dot1[1] - dot2[1]) <= 1000;
	}

}