import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        boolean[] v = new boolean[100_003];
        v[N] = true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {N, 0});
        while (!q.isEmpty()) {
            int[] ns = q.poll();
            if (ns[0] == K) {
                if (min > ns[1])
                    min = ns[1];
            }
            if (ns[0] * 2 <= 100_002 && !v[ns[0] * 2]) {
                v[ns[0] * 2] = true;
                q.offer(new int[] {ns[0] * 2, ns[1]});
            }
            if (ns[0] - 1 >= 0 && !v[ns[0] - 1]) {
                v[ns[0] - 1] = true;
                q.offer(new int[] {ns[0] - 1, ns[1] + 1});
            }
            if (ns[0] + 1 <= 100_000 && !v[ns[0] + 1]) {
                v[ns[0] + 1] = true;
                q.offer(new int[] {ns[0] + 1, ns[1] + 1});
            }
        }
        System.out.println(min);
        br.close();
    }

}