import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, b;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		b = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		ducomb(0, 0);
		System.out.print(sb);
		br.close();
	}

	private static void ducomb(int cnt, int start) {
		if (cnt == M) {
			String s = "";
			for (int n : b) {
				s += n + " ";
			}
			if (!set.contains(s)) {
				set.add(s);
				sb.append(s).append('\n');
			}
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = arr[i];
			ducomb(cnt + 1, i);
		}
	}

}