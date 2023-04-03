import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.DISCARDING;

// 한박스 맥주 20개
// 50미터에 한병씩 마셔야함
// 편의점에 들릴 시 빈 병은 버리고 새 맥주 살 수 있음(최대 20병 보유 가능)
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		final int INF = Integer.MAX_VALUE / 2;
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] home = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			int[][] arr = new int[n + 2][2];
			arr[0] = home;
			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			}
			st = new StringTokenizer(br.readLine(), " ");
			int[] dest = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			arr[n + 1] = dest;
			int[][] distance = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (canMove(arr[i], arr[j]))
						distance[i][j] = 1;
					else
						distance[i][j] = INF;
				}
			}
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
					}
				}
			}
			sb.append(distance[0][n + 1] == INF ? "sad" : "happy").append('\n');
		}
		System.out.print(sb);
		br.close();
	}

	private static boolean canMove(int[] dot1, int[] dot2) {
		return Math.abs(dot1[0] - dot2[0]) + Math.abs(dot1[1] - dot2[1]) <= 1000;
	}

}