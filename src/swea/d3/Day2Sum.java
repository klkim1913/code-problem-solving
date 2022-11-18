package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day2Sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max;
            int[] iSum = new int[100];
            int[] jSum = new int[100];
            int dia = 0, dia2 = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    iSum[i] += arr[i][j];
                    jSum[j] += arr[i][j];
                    if (i == j) {
                        dia += arr[i][j];
                    }
                    if (i + j == 99) {
                        dia2 += arr[i][j];
                    }
                }
            }
            max = Math.max(Arrays.stream(iSum).max().getAsInt(),
                    Arrays.stream(jSum).max().getAsInt());
            max = Math.max(max, dia2);
            max = Math.max(max, dia);
            System.out.printf("#%d %d\n", T, max);
        }
    }
}
