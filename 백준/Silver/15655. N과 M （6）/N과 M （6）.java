import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] b = new int[M];
        Arrays.sort(a);
        comb(0, 0, N, M, a, b, sb);
        System.out.println(sb);
        br.close();
    }

    private static void comb(int cnt, int start, int N, int M, int[] a, int[] b, StringBuilder sb) {
        if (cnt == M) {
            for (int n : b) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < N; i++) {
            b[cnt] = a[i];
            comb(cnt + 1, i + 1, N, M, a, b, sb);
        }
    }

}