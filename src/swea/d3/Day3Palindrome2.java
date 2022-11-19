package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3Palindrome2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 0; tc < 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            boolean isSame = true;
            for (int n = 100; n > 0; n--) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100 - n + 1; j++) {
                        isSame = true;
                        for (int k = 0; k < n / 2; k++) {
                            if (arr[i][j + k] != arr[i][j + n - k - 1]) {
                                isSame = false;
                                break;
                            }
                        }
                        if (isSame) {
                            System.out.printf("#%d %d\n", t, n);
                            n = Integer.MIN_VALUE + 1;
                            i = Integer.MAX_VALUE - 1;
                            break;
                        }
                    }
                }
                if (!isSame) {
                    for (int i = 0; i < 100 - n + 1; i++) {
                        for (int j = 0; j < 100; j++) {
                            isSame = true;
                            for (int k = 0; k < n / 2; k++) {
                                if (arr[i + k][j] != arr[i + n - k - 1][j]) {
                                    isSame = false;
                                    break;
                                }
                            }
                            if (isSame) {
                                System.out.printf("#%d %d\n", t, n);
                                n = Integer.MIN_VALUE + 1;
                                i = Integer.MAX_VALUE - 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
