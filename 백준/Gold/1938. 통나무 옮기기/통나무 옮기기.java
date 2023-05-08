import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	// 기둥이 세로로 있는지 가로로 있는지
	static final int ud = 0;
	static final int lr = 1;
	static int N;
	static int[][] map;

	// 기둥 중앙좌표 및 모양
	static class Gidung {
		int i;
		int j;
		int shape;
		int d;

		public Gidung() {
		};

		public Gidung(int i, int j, int shape, int d) {
			this.i = i;
			this.j = j;
			this.shape = shape;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// 출발지와 도착지 좌표 및 모양 저장할 객체 생성
		Gidung st = new Gidung();
		Gidung ds = new Gidung();
		// 시작좌표와 도착좌표 찾았는지 검사
		boolean sfind = false, dfind = false;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				// 첫 발견시 중앙 B는 오른쪽에 있거나 아래에 있음
				if (!sfind && s.charAt(j) == 'B') {
					// 오른쪽에 있는 경우
					if (j + 1 < N && s.charAt(j + 1) == 'B') {
						st.i = i;
						st.j = j + 1;
						st.shape = lr;
						// 아래쪽에 있는 경우
					} else if (i + 1 < N) {
						st.i = i + 1;
						st.j = j;
						st.shape = ud;
					}
					sfind = true;
				} else if (!dfind && s.charAt(j) == 'E') {
					if (j + 1 < N && s.charAt(j + 1) == 'E') {
						ds.i = i;
						ds.j = j + 1;
						ds.shape = lr;
					} else if (i + 1 < N) {
						ds.i = i + 1;
						ds.j = j;
						ds.shape = ud;
					}
					dfind = true;
				} else if (s.charAt(j) == '1')
					map[i][j] = 1;
			}
		}
		// 현재 기둥이 이동한 거리
		st.d = 0;
		final int[] di = { -1, 0, 1, 0 };
		final int[] dj = { 0, 1, 0, -1 };
		// 각 좌표에서 상태별 방문처리를 위한 3차원 배열
		boolean[][][] v = new boolean[N][N][2];
		ArrayDeque<Gidung> q = new ArrayDeque<>();
		v[st.i][st.j][st.shape] = true;
		q.offer(st);
		int answer = 0;
		while (!q.isEmpty()) {
			Gidung g = q.poll();
			if (g.i == ds.i && g.j == ds.j && g.shape == ds.shape) {
				answer = g.d;
				break;
			}
			// 사방 이동
			for (int d = 0; d < 4; d++) {
				int ni = g.i + di[d];
				int nj = g.j + dj[d];
				// 기둥이 가로 모양일때
				if (g.shape == lr && 0 <= ni && ni < N && 0 <= nj - 1 && nj + 1 < N && !v[ni][nj][g.shape]) {
					if (map[ni][nj - 1] != 1 && map[ni][nj] != 1 && map[ni][nj + 1] != 1) {
						v[ni][nj][g.shape] = true;
						q.offer(new Gidung(ni, nj, g.shape, g.d + 1));
					}
					// 기둥이 세로 모양일 때
				} else if (g.shape == ud && 0 <= nj && nj < N && 0 <= ni - 1 && ni + 1 < N && !v[ni][nj][g.shape]) {
					if (map[ni - 1][nj] != 1 && map[ni][nj] != 1 && map[ni + 1][nj] != 1) {
						v[ni][nj][g.shape] = true;
						q.offer(new Gidung(ni, nj, g.shape, g.d + 1));
					}
				}
			}
			// 회전 이동
			if (!v[g.i][g.j][(g.shape + 1) % 2] && isRoatate(g)) {
				v[g.i][g.j][(g.shape + 1) % 2] = true;
				q.offer(new Gidung(g.i, g.j, (g.shape + 1) % 2, g.d + 1));
			}
		}
		System.out.print(answer);
		br.close();
	}

	// 회전이 가능한지 여부를 체크하는 함수
	private static boolean isRoatate(Gidung g) {
		// 가로일 경우
		if (g.shape == lr) {
			// 공간이 없으면 불가
			if (0 > g.i - 1 || g.i + 1 >= N)
				return false;
			// 위아래가 공간이 있고 1이 없을 경우
			if (0 <= g.i - 1 && g.i + 1 < N) {
				for (int c = g.j - 1; c <= g.j + 1; c++) {
					if (map[g.i - 1][c] == 1 || map[g.i + 1][c] == 1)
						return false;
				}
			}
			// 세로일 경우
		} else {
			// 공간이 없으면 불가
			if (0 > g.j - 1 || g.j + 1 >= N)
				return false;
			// 양옆이 공간이 있고 1이 없을 경우
			if (0 <= g.j - 1 && g.j + 1 < N) {
				for (int c = g.i - 1; c <= g.i + 1; c++) {
					if (map[c][g.j - 1] == 1 || map[c][g.j + 1] == 1)
						return false;
				}
			}
		}
		return true;
	}

}