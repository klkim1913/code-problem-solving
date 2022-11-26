package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    public static int N;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] blocked = new boolean[N][N];

        dfs(0, blocked);
        System.out.println(sum);
    }

    private static void dfs(int depth, boolean[][] blocked) {
        if (depth == N) {
            sum++;
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!blocked[i][j]) {
                    for (int k = 0; k < N; k++) {
                        blocked[i][k] = true;
                        blocked[k][j] = true;
                    }
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            if ((k + l) == (i + j) || Math.abs(k - l) == Math.abs(i - j)) {
                                blocked[k][l] = true;
                            }
                        }
                    }
                    dfs(depth + 1, blocked);
                }
            }
        }
    }
}
