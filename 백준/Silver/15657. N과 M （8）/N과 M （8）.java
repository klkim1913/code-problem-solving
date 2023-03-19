import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, b;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        b = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        comb(0, 0);
        System.out.print(sb);
        br.close();
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            for (int n : b) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            b[cnt] = arr[i];
            comb(cnt + 1, i);
        }
    }

}