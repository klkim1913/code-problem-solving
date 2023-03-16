import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int maxItem = 0;
        for (int i = 0; i < n; i++) {
            maxItem += items[i] = Integer.parseInt(st.nextToken());
        }
        int[][] g = new int[n][n];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            g[from][to] = weight;
            g[to][from] = weight;
        }
        int[] dist = new int[n];
        int maxSum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        // n-1번까지 최대값 구하는 다익스트라 반복
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[j] = Integer.MAX_VALUE;
            }
            boolean[] v = new boolean[n];
            pq.clear();
            dist[i] = 0;
            pq.offer(new int[] {i, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int minVertex = cur[0];
                int min = cur[1];
                if (v[minVertex])
                    continue;
                v[minVertex] = true;
                for (int j = 0; j < n; j++) {
                    if (!v[j] && g[minVertex][j] != 0 && dist[j] > min + g[minVertex][j]) {
                        dist[j] = min + g[minVertex][j];
                        pq.offer(new int[] {j, dist[j]});
                    }
                }
            }
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= m) {
                    sum += items[j];
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (maxSum == maxItem)
                break;
        }
        System.out.print(maxSum);
        br.close();
    }

}