import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1, o2)));
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = -1;
        for (int i = 0; i < T; i++) {
            if (pq.isEmpty()) {
                System.out.println("NO");
                System.out.println(1);
                return;
            }
            int n = pq.poll();
            if (n < H) {
                answer = i;
                break;
            }
            if (n >= H && n != 1) {
                pq.offer(n / 2);
            }
        }
        if (answer != -1) {
            System.out.println("YES");
            System.out.println(answer);
        } else {
            int n=pq.poll();
            if (n < H) {
                System.out.println("YES");
                System.out.println(T);
            } else {
                System.out.println("NO");
                System.out.println(n);
            }
        }
        br.close();
    }
}