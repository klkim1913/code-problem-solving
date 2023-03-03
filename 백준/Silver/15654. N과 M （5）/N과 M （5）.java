import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] b;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        b = new int[M];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0, arr, N, M, sb);
        System.out.println(sb);
        br.close();
    }

    private static void perm(int cnt, int[] arr, int N, int M, StringBuilder sb) {
        if (cnt == M) {
            for (int n : b) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                b[cnt] = arr[i];
                perm(cnt + 1, arr, N, M, sb);
                v[i] = false;
            }
        }
    }

}