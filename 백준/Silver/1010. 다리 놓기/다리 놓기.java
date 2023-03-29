import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int sum = 1;
			int mul = M;
			boolean[] div = new boolean[M - N + 1];
			for (int i = 0; i < M - N; i++) {
				sum *= mul;
				mul--;
				for (int j = 2; j < M - N + 1; j++) {
					if (!div[j] && (sum % j == 0)) {
						sum /= j;
						div[j] = true;
					}
				}
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

}