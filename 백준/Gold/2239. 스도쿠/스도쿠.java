import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 행, 열, 사각형에서 넣을 수 있는 수의 집합을 차례로 넣어보다가 
 * 넣을 수 있는 집합이 없을경우 백트래킹 해서 다른 수를 넣는 방식
 * 행과 열은 각각 탐색하여 1~9에서 제외한 집합 남기기
 * 행이 123중에 있으면 행 start=1하고 +3<까지 열도 마찬가지 검사.
*/
public class Main {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				if (map[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}

		dfs(0);
		br.close();
	}

	private static void dfs(int idx) {
		if (list.size() == idx) {
			print();
			System.exit(0);
		}

		int r = list.get(idx)[0];
		int c = list.get(idx)[1];

		boolean[] check = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (map[r][i] != 0) {
				check[map[r][i]] = true;
			}
			if (map[i][c] != 0) {
				check[map[i][c]] = true;
			}
		}
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				map[r][c] = i;
				dfs(idx + 1);
				map[r][c] = 0;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}