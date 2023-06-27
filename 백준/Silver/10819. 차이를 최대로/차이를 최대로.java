import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] b;
    static int N;
    static int max = 0;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        b = new int[N];
        v = new boolean[N];
        dfs(0);
        System.out.println(max);
        br.close();
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            cal();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            b[cnt] = arr[i];
            dfs(cnt + 1);
            v[i] = false;
        }
    }

    private static void cal() {
        int sum=0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(b[i] - b[i + 1]);
        }
        if (max < sum) {
            max = sum;
        }
    }
}