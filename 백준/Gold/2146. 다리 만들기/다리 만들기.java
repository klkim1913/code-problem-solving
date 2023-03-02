import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int num = 2;
	static int size = 0;
	static ArrayList<ArrayList<int[]>> list;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !v[i][j]) {
					list.add(new ArrayList<>());
					bfs(i, j);
					num++;
					size++;
				}
			}
		}
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < size - 1; i++) {
			ArrayList<int[]> land1 = list.get(i);
			for (int j = i + 1; j < size; j++) {
				ArrayList<int[]> land2 = list.get(j);
				for (int k = 0; k < land1.size(); k++) {
					int[] ij1 = land1.get(k);
					for (int l = 0; l < land2.size(); l++) {
						int[] ij2 = land2.get(l);
						minDistance = Math.min(minDistance, Math.abs(ij1[0] - ij2[0]) + Math.abs(ij1[1] - ij2[1]));
					}
				}
			}
		}
		System.out.println(minDistance - 1);
		br.close();
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		arr[i][j] = num;
		list.get(size).add(new int[] { i, j });
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = ij[0] + di[d];
				int nj = ij[1] + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && arr[ni][nj] == 1 && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
					arr[ni][nj] = num;
					for (int d2 = 0; d2 < 4; d2++) {
						int nni = ni + di[d2];
						int nnj = nj + dj[d2];
						if (0 <= nni && nni < N && 0 <= nnj && nnj < N && arr[nni][nnj] == 0) {
							list.get(size).add(new int[] { ni, nj });
							break;
						}
					}
				}
			}
		}
	}

}