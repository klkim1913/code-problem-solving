package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Size {
    /*
     * 1. 2차원 배열에 저장
     ** 2. 자신보다 키와 몸무게가 모두 큰 사람의 수 +1이 자신의 등수
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int up = 1;
            for (int j = 0; j < N; j++) {
                if ((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])) {
                    up++;
                }
            }
            sb.append(up).append(" ");
        }
        System.out.println(sb);
    }
}
