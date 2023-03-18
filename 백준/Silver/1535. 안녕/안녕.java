import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] L, J;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }
        subs(0, 0, 0);
        System.out.println(max);
        br.close();
    }

    private static void subs(int i, int loseSum, int addSum) {
        if (i == N) {
            if (max < addSum) {
                max = addSum;
            }
            return;
        }
        int ls = loseSum + L[i];
        int as = addSum + J[i];
        if (ls < 100)
            subs(i + 1, ls, as);
        subs(i + 1, loseSum, addSum);
    }

}