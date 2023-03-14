import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 편도인지 왕복인지 여러개있는지 어떻게 알지;;
public class Main {
    static class Vertex implements Comparable<Vertex> {
        int no, weight;

        Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static int N;
    static List<Vertex>[] g;
    static int[] pre;
    static boolean[] visited;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        g = new ArrayList[N];
        pre = new int[N];
        Arrays.fill(pre, -1);
        visited = new boolean[N];
        boolean[] v = new boolean[N];
        dist = new int[N];

        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            g[from].add(new Vertex(to, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.offer(new Vertex(start, 0));
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            int minVertex = cur.no;
            int min = cur.weight;
            if (v[minVertex])
                continue;
            v[minVertex] = true;
            if (minVertex == end)
                break;
            for (Vertex vertex : g[minVertex]) {
                int no = vertex.no;
                int weight = vertex.weight;
                if (!v[no] && dist[no] > min + weight) {
                    dist[no] = min + weight;
                    pre[no] = minVertex;
                    pq.offer(new Vertex(no, dist[no]));
                }
            }
        }
        sb.append(dist[end] + "\n");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(end);
        int cnt = 1;
        while (pre[end] != -1) {
            cnt++;
            stack.push(pre[end]);
            end = pre[end];
        }
        sb.append(cnt + "\n");
        while (!stack.isEmpty()) {
            sb.append((stack.pop() + 1) + " ");
        }
        System.out.print(sb);
        br.close();
    }


}