package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotatingNumericArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] arr90 =new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr90[i][j]=arr[N-1-j][i];
                }
            }
            int[][] arr180 =new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr180[i][j]=arr[N-1-i][N-1-j];
                }
            }
            int[][] arr270 =new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr270[i][j]=arr[j][N-1-i];
                }
            }

            System.out.println("#"+tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(arr270[i][j]);
                }
                System.out.println();
            }
        }
    }
}
