import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(br.readLine());
        int[] dist = new int[cnt + 1];
        for (int i = 0; i < cnt + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                dist[i] = d;
            } else if (dir == 2) {
                dist[i] = 2 * N + M - d;
            } else if (dir == 3) {
                dist[i] = 2 * N + 2 * M - d;
            } else if (dir == 4) {
                dist[i] = N + d;
            }
        }
        int dong = dist[cnt];
        int total = 2 * N + 2 * M;
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            int clockwise = Math.abs(dong - dist[i]);
            sum += Math.min(clockwise, total - clockwise);
        }
        System.out.println(sum);
        br.close();
    }
}