import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        comb(0, 0, "");
        System.out.print(sb);
        br.close();
    }

    private static void comb(int cnt, int start, String str) {
        if (cnt == M) {
            sb.append(str).append('\n');
            return;
        }
        for (int i = start; i < N; i++) {
            comb(cnt + 1, i + 1, str + a[i] + " ");
        }
    }

}