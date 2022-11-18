package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day1Flatten {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int[] arr = new int[100];
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
                if (arr[99] - arr[0] <= 1) {
                    break;
                }
            }
            Arrays.sort(arr);   // 이런 최종 작업해야하는것들 놓치지 말자
            System.out.printf("#%d %d\n", tc, arr[99] - arr[0]);
        }
    }
}
