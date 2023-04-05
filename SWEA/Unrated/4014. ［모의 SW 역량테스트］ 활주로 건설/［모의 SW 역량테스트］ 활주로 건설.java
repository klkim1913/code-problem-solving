import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int total = N * 2;
			/*
			 * 1. 연속된 칸중에 2칸이상 차이나면 아웃 2. 1칸 이상 차이날때 그 칸이 X만큼 없으면 아웃(범위밖도 포함) - 앞보다 뒤가 큰경우,
			 * 뒤보다 앞이 큰경우 3. 경사로 설치된곳에 중복 설치 불가
			 */
			to: for (int i = 0; i < N; i++) {
				boolean[] v = new boolean[N];
				for (int j = 1; j < N; j++) {
					// 1번
					if (Math.abs(map[i][j - 1] - map[i][j]) > 1) {
						total--;
						continue to;
					}
					// 2-1번(뒤에가 큰경우(앞에다 활주로를 놔야할 경우)
					if (map[i][j - 1] - map[i][j] == -1) {
						for (int k = 1; k <= X; k++) {
							if (j - k < 0 || v[j - k] || (map[i][j - k] != map[i][j - 1])) {
								total--;
								continue to;
							}
							v[j - k] = true;
						}
						// 2-1번(앞에가 큰경우(뒤에다 활주로를 놔야할 경우)
					} 
					if (map[i][j-1] - map[i][j] == 1) {
						for (int k = 0; k < X; k++) {
							if (j + k >= N || v[j + k] || (map[i][j + k] != map[i][j])) {
								total--;
								continue to;
							}
							v[j + k] = true;
						}
					}
				}
			}
			to: for (int j = 0; j < N; j++) {
				boolean[] v = new boolean[N];
				for (int i = 1; i < N; i++) {
					// 1번
					if (Math.abs(map[i - 1][j] - map[i][j]) > 1) {
						total--;
						continue to;
					}
					// 2-1번(뒤에가 큰경우(앞에다 활주로를 놔야할 경우)
					if (map[i - 1][j] - map[i][j] == -1) {
						for (int k = 1; k <= X; k++) {
							if (i - k < 0 || v[i - k] || (map[i - k][j] != map[i - 1][j])) {
								total--;
								continue to;
							}
							v[i - k] = true;
						}
						// 2-1번(뒤에가 큰경우(앞에다 활주로를 놔야할 경우)
					} 
					if (map[i - 1][j] - map[i][j] == 1) {
						for (int k = 0; k < X; k++) {
							if (i + k >= N || v[i + k] || (map[i + k][j] != map[i][j])) {
								total--;
								continue to;
							}
							v[i + k] = true;
						}
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(total).append('\n');
		}
		System.out.print(sb);
		br.close();
	}

}