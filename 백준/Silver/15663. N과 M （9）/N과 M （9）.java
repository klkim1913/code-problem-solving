import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, b;
	static StringBuilder sb = new StringBuilder();
	static boolean[] v;
	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		b = new int[M];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0);
		System.out.print(sb);
		br.close();
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			String s = "";
			for (int n : b) {
				s += n + " ";
			}
			if (!set.contains(s)) {
				sb.append(s + "\n");
				set.add(s);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			b[cnt] = arr[i];
			perm(cnt + 1);
			v[i] = false;
		}
	}

}