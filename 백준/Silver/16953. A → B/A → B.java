import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long B;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		subs(A, 1);
		System.out.print(min == Long.MAX_VALUE ? -1 : min);
		br.close();
	}

	private static void subs(long res, int cnt) {
		if (res > B) {
			return;
		}
		if (res == B) {
			if (min > cnt)
				min = cnt;
			return;
		}
		subs(res * 2, cnt + 1);
		subs(Long.parseLong(String.valueOf(res) + "1"), cnt + 1);
	}

}