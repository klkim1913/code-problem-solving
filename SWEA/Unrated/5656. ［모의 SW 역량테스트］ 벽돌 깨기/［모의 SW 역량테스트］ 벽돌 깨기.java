import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int H, W, N;
    static int[][] arr;
    static int min;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            pi(0, arr);
            sb.append(min).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private static void pi(int cnt, int[][] copy) {
        if (min == 0)
            return;
        if (cnt == N) {
            calNum(copy);
            return;
        }
        for (int j = 0; j < W; j++) {
            pi(cnt + 1, drop(copy, j));
        }
    }

    private static int[][] drop(int[][] arr, int j) {
        int[][] copy = copyArray(arr);
        for (int i = 0; i < H; i++) {
            if (copy[i][j] > 0) {
                int si = i;
                int sj = j;
                boom(si, sj, copy);
                down(copy);
                break;
            }
        }
        return copy;
    }

    private static void boom(int si, int sj, int[][] copy) {
        int r = copy[si][sj] - 1;
        copy[si][sj] = 0;
        if (r == 0)
            return;
        for (int d = 0; d < 4; d++) {
            for (int b = 1; b <= r; b++) {
                int ni = si + (b * di[d]);
                int nj = sj + (b * dj[d]);
                if (0 <= ni && ni < H && 0 <= nj && nj < W && copy[ni][nj] > 0) {
                    boom(ni, nj, copy);
                }
            }
        }
    }

    private static void down(int[][] copy) {
        for (int j = 0; j < W; j++) {
            int i = H - 1;
            while (i > 0) {
                if (copy[i][j] == 0) {
                    int ni = i - 1;
                    while (ni > 0 && copy[ni][j] == 0)
                        ni--;
                    copy[i][j] = copy[ni][j];
                    copy[ni][j] = 0;
                }
                i--;
            }
        }
    }

    private static void calNum(int[][] copy) {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copy[i][j] > 0) {
                    cnt++;
                    if (cnt >= min)
                        return;
                }
            }
        }
        min = Math.min(min, cnt);
    }
}