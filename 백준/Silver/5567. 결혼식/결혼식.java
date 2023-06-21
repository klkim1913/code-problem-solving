import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int sum = 0;
        boolean[] v = new boolean[n + 1];
        v[1] = true;
        for (int p : list[1]) {
            if (!v[p]) {
                v[p] = true;
                q.offer(p);
                sum++;
            }
        }
        while (!q.isEmpty()) {
            int p = q.pop();
            for (int f : list[p]) {
                if (!v[f]) {
                    v[f] = true;
                    sum++;
                }
            }
        }
        System.out.println(sum);
        br.close();
    }
}