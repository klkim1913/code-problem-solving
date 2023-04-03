import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] distance = new int[N][N];
		final int INF = 987654321;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'Y') {
					distance[i][j] = 1;
				} else
					distance[i][j] = INF;
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (distance[i][j] == 1 || distance[i][j] == 2) {
					sum++;
				}
			}
			if (max < sum)
				max = sum;
		}
		System.out.print(max);
		br.close();
	}

}
