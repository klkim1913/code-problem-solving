import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] a, b;
	static StringBuilder sb;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		sb = new StringBuilder();
		Arrays.sort(a);
		comb(0, 0);
		System.out.println(sb);
		br.close();
	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int n : b) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		int prev = -1;
		for (int i = start; i < N; i++) {
			if (v[i] || a[i] == prev)
				continue;
			prev = a[i];
			v[i] = true;
			b[cnt] = a[i];
			comb(cnt + 1, i);
			v[i] = false;
		}
	}

}