import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
			} else {
				pq.offer(x);
			}
		}
		System.out.print(sb);
		br.close();
	}

}