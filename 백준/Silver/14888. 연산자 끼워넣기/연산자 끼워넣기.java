import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] oper = new int[N - 1];
		boolean[] v = new boolean[N]; // 연산자 방문 배열
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			while (n-- > 0) {
				oper[idx++] = i;
			}
		}
		perm(1, arr, oper, N, v, arr[0]);
		System.out.println(max + "\n" + min);
	}

	private static void perm(int cnt, int[] arr, int[] oper, int N, boolean[] v, int result) {
		if (cnt == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		for (int i = 1; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			if (oper[i - 1] == 0) { // 덧셈일 경우
				perm(cnt + 1, arr, oper, N, v, result + arr[cnt]);
			} else if (oper[i - 1] == 1) { // 뺄셈일 경우
				perm(cnt + 1, arr, oper, N, v, result - arr[cnt]);
			} else if (oper[i - 1] == 2) { // 곱셈일 경우
				perm(cnt + 1, arr, oper, N, v, result * arr[cnt]);
			} else if (oper[i - 1] == 3) { // 나눗셈일 경우
				perm(cnt + 1, arr, oper, N, v, result / arr[cnt]);
			}
			v[i] = false;
		}
	}

}