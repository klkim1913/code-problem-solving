package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SnailNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[] di = {0, 1, 0, -1};
            int[] dj = {1, 0, -1, 0};
            int count = 1;
            int d = 0;
            int i, j;

            i = j = 0;
            while (count <= N * N) {
                arr[i][j] = count++;
                int ni = i + di[d];
                int nj = j + dj[d];
                if (ni >= N || ni < 0 || nj >= N || nj < 0 || arr[ni][nj] != 0) {
                    d = (d + 1) % 4;
                    ni = i + di[d];
                    nj = j + dj[d];
                }
                i = ni;
                j = nj;
            }
            System.out.printf("#%d\n", N);
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++) {
                    System.out.print(arr[k][l] + " ");
                }
                System.out.println();
            }
        }
    }
}
