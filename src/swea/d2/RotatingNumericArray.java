package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotatingNumericArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 1;
            for (int i = 0; i < 9 && result == 1; i++) {
                int[] check1 = new int[9];
                int[] check2 = new int[9];
                for (int j = 0; j < 9; j++) {
                    if (++check1[arr[i][j] - 1] > 1) {
                        result = 0;
                        break;
                    }
                    if (++check2[arr[j][i] - 1] > 1) {
                        result = 0;
                        break;
                    }
                }
            }
            if (result == 1) {
                int[] d = {-1, 0, 1};
                for (int i = 1; i < 9 && result == 1; i += 3) {
                    for (int j = 1; j < 9 && result == 1; j += 3) {
                        int[] check3 = new int[9];
                        for (int k = 0; k < 3 && result == 1; k++) {
                            for (int l = 0; l < 3; l++) {
                                if (++check3[arr[i + d[k]][j + d[l]] - 1] > 1) {
                                    result = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
