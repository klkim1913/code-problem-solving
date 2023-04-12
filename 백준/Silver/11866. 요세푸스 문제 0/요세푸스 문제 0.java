import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = K - 1;
		sb.append('<');
		for (int i = 0; i < N - 1; i++) {
			sb.append(list.remove(idx)).append(", ");
			idx = (idx + K - 1) % list.size();
		}
		sb.append(list.remove(0)).append('>');
		System.out.print(sb);
		br.close();
	}

}