import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, si, sj, size = 2, time;
    static int eatNum; // 먹은 개수
    static int[] di = {-1, 0, 0, 1}; // 위 왼쪽 오른쪽 아래
    static int[] dj = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    si = i;
                    sj = j;
                    arr[i][j] = 0;
                }
            }
        }
        int canNum = eat();
        time += canNum;
        while (canNum > 0) {
            canNum = eat();
            time += canNum;
        }
        System.out.println(time);
        br.close();

    }

    private static int eat() {
        boolean[][] v = new boolean[N][N];
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            int r = Integer.compare(o1[2], o2[2]);
            if (r == 0)
                r = Integer.compare(o1[0], o2[0]);
            if (r == 0)
                r = Integer.compare(o1[1], o2[1]);

            return r;
        });
        v[si][sj] = true;
        q.offer(new int[] {si, sj, 0}); // 3번째는 시간(거리)
        while (!q.isEmpty()) {
            int[] ijt = q.poll();
            int i = ijt[0];
            int j = ijt[1];
            int m = ijt[2];
            if (0 < arr[i][j] && arr[i][j] < size) {
                arr[i][j] = 0;
                eatNum++;
                si = i;
                sj = j;
                if (eatNum == size) {
                    eatNum = 0;
                    size++;
                }
                return m;
            }
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && arr[ni][nj] <= size) {
                    v[ni][nj] = true;
                    q.offer(new int[] {ni, nj, m + 1});
                }
            }
        }
        return 0;
    }
}