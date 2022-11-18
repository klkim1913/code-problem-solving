package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3Palindrome1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            int cnt = 0;
            boolean isSame;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - len; j++) {
                    isSame = true;
                    for (int k = 0; k < len / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + len - k - 1]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        cnt++;
                    }
                }
            }
            for (int i = 0; i <= 8 - len; i++) {
                for (int j = 0; j < 8; j++) {
                    isSame = true;
                    for (int k = 0; k < len / 2; k++) {
                        if (arr[i + k][j] != arr[i + len - k - 1][j]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        cnt++;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}
