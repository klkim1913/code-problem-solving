import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/swea/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            int crxSum1 = 0;
            int crxSum2 = 0;
            for (int i = 0; i < 100; i++) {
                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0; j < 100; j++) {
                    sum1 += arr[i][j];
                    sum2 += arr[j][i];
                    if (i == j) crxSum1 += arr[i][j];
                    if (i + j == 99) crxSum2 += arr[i][j];
                }
                if (sum1 > max) max = sum1;
                if (sum2 > max) max = sum2;
            }
            if (crxSum1 > max) max = crxSum1;
            if (crxSum2 > max) max = crxSum2;
            System.out.printf("#%d %d\n", tc, max);
        }
    }
}