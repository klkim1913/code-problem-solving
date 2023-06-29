import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        p = new int[N + 1];
        cost = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            p[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i < N + 1; i++) {
            answer += cost[i];
        }
        System.out.println(answer > k ? "Oh no" : answer);
        br.close();
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        p[bRoot] = aRoot;
        cost[aRoot] = Math.min(cost[aRoot], cost[bRoot]);
        cost[bRoot] = 0;
    }

    private static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return find(p[a]);
    }
}