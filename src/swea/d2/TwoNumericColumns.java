package swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoNumericColumns {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/swea/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] NArr = new int[N];
            int[] MArr = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                NArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                MArr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            if (N > M) {
                max = MulSum(N, M, NArr, MArr, max);
            } else {
                max = MulSum(M, N, MArr, NArr, max);
            }
            System.out.printf("#%d %d\n", tc, max);
        }

    }

    private static int MulSum(int big, int small, int[] bigArr, int[] smallArr, int max) {
        for (int i = 0; i <= big - small; i++) {
            int sum = 0;
            for (int j = 0; j < small; j++) {
                sum += bigArr[i + j] * smallArr[j];
            }
            if (sum > max) max = sum;
        }
        return max;
    }
}
