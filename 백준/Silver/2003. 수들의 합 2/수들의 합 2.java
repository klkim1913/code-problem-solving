import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		int answer = 0;
		while (idx < N) {
			int sum = 0;
			for (int i = idx; i < N; i++) {
				sum += arr[i];
				if (sum == M) {
					answer++;
				}
				if (sum > M)
					break;
			}
			idx++;
		}
		System.out.println(answer);
		br.close();
	}

}