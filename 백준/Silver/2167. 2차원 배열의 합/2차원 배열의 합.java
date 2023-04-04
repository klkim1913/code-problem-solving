import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ii = Integer.parseInt(st.nextToken());
			int jj = Integer.parseInt(st.nextToken());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			int sum = arr[xx][yy] - arr[ii - 1][yy] - arr[xx][jj - 1] + arr[ii - 1][jj - 1];
			sb.append(sum + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}