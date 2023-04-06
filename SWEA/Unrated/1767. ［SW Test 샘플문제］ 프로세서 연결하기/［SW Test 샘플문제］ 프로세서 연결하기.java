import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static int maxCore, minWire;
	static List<int[]> list;
	static boolean[] v;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			maxCore = 0;
			minWire = N * N;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1)
						list.add(new int[] { i, j });
				}
			}
			v = new boolean[list.size()];
			// 코어 인덱스, 코어 개수, 전선 길이
			dfs(0, 0, 0);
			sb.append('#').append(tc).append(' ').append(minWire).append('\n');
		}
		System.out.print(sb);
		br.close();
	}

	private static void dfs(int cnt, int coreNum, int wireLength) {
		if (cnt == list.size()) {
			if (maxCore < coreNum) {
				maxCore = coreNum;
				minWire = wireLength;
			} else if (maxCore == coreNum)
				minWire = Math.min(minWire, wireLength);
			return;
		}
		int[] ij = list.get(cnt);
		for (int d = 0; d < 4; d++) {
			int count = 0;
			int orgI = ij[0];
			int orgJ = ij[1];
			int ni = ij[0];
			int nj = ij[1];

			while (true) {
				ni += di[d];
				nj += dj[d];

				if (ni < 0 || nj < 0 || ni >= N || nj >= N)
					break;
				if (map[ni][nj] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			for (int i = 0; i < count; i++) {
				orgI += di[d];
				orgJ += dj[d];

				map[orgI][orgJ] = 1;
			}

			if (count == 0) {
				dfs(cnt + 1, coreNum, wireLength);
			} else {
				dfs(cnt + 1, coreNum + 1, wireLength + count);

				orgI = ij[0];
				orgJ = ij[1];
				for (int i = 0; i < count; i++) {
					orgI += di[d];
					orgJ += dj[d];
					map[orgI][orgJ] = 0;
				}
			}
		}
	}

}