import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> g;
    static StringBuilder sb = new StringBuilder();
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        g = new ArrayList<>();
        p = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g.get(from).add(to);
            g.get(to).add(from);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) {
            sb.append(p[i] + "\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int node) {
        for (int n : g.get(node)) {
            if (p[n] == 0) {
                p[n] = node;
                dfs(n);
            }
        }
    }

}