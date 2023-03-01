import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        v = new boolean[N + 1];
        bfs(N);
        br.close();
    }

    private static void bfs(int n) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[n] = true;
        q.offer(new int[] {n, 0});
        while (!q.isEmpty()) {
            int[] nd = q.poll();
            if (nd[0] == 1) {
                System.out.println(nd[1]);
                break;
            }
            if (nd[0] % 3 == 0 && !v[nd[0] / 3]) {
                v[nd[0] / 3] = true;
                q.offer(new int[] {nd[0] / 3, nd[1] + 1});
            }
            if (nd[0] % 2 == 0 && !v[nd[0] / 2]) {
                v[nd[0] / 2] = true;
                q.offer(new int[] {nd[0] / 2, nd[1] + 1});
            }
            if (!v[nd[0] - 1]) {
                v[nd[0] - 1] = true;
                q.offer(new int[] {nd[0] - 1, nd[1] + 1});
            }
        }
    }

}