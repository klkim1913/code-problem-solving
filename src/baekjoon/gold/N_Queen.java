package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    public static int N;
    public static int sum;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(sum);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            sum++;
            return;
        }
        for (int j = 0; j < N; j++) {
            arr[depth] = j;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i]) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }


}
