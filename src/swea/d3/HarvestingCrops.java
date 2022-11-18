package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HarvestingCrops {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int j = 0;
                for (char c : st.nextToken().toCharArray()) {
                    arr[i][j++] = Character.getNumericValue(c);
                }
            }
            int sum = 0;
            int start = N / 2;
            int end = N / 2;

            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    sum += arr[i][j];
                }
                if (i < N / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
