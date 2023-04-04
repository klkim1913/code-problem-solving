import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ii = Integer.parseInt(st.nextToken())-1;
			int jj = Integer.parseInt(st.nextToken())-1;
			int xx = Integer.parseInt(st.nextToken())-1;
			int yy = Integer.parseInt(st.nextToken())-1;
			int sum = 0;
			for (int i = ii; i <= xx; i++) {
				for (int j = jj; j <= yy; j++) {
					sum += arr[i][j];
				}
			}
			sb.append(sum + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}