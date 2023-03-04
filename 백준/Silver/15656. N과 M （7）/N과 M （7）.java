import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a;
    static StringTokenizer st;
    static StringBuilder sb;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        perm(0, "");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void perm(int cnt, String str) throws Exception {
        if (cnt == M) {
            bw.write(str + "\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            perm(cnt + 1, str + a[i] + " ");
        }
    }

}