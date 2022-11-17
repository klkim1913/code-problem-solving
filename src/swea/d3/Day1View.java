package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1View {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][255];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int high = Integer.parseInt(st.nextToken());
                for (int y = 0; y < high; y++) {
                    arr[x][y] = 1;
                }
            }
            int sum = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < 255; y++) {
                    if (arr[x][y] == 1) {
                        if (arr[x - 2][y] == 0 && arr[x - 1][y] == 0 && arr[x + 1][y] == 0
                                && arr[x + 2][y] == 0) {
                            sum++;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t + 1, sum);
        }
    }
}
