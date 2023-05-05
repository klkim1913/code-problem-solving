import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a, b;
    static StringBuilder sb = new StringBuilder();
    static boolean[] v = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> tmp = new ArrayList<>();
        b = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!v[n]) {
                v[n] = true;
                tmp.add(n);
            }
        }
        a=new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            a[i] = tmp.get(i);
        }
        Arrays.sort(a);
        perm(0);
        System.out.println(sb);
        br.close();
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int n : b) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < a.length; i++) {
            b[cnt] = a[i];
            perm(cnt + 1);
        }
    }

}