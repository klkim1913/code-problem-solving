import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static char[][] map;
	static int N, M;
	static final char now = 'S';
	static final char god = 'D';
	static final char stone = 'X';
	static final char devil = '*';
	static final char area = '.';

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0, sj = 0;
        int desi = 0, desj = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == now) {
                    si = i;
                    sj = j;
                    map[i][j] = area;
                } else if (map[i][j] == god) {
                    desi = i;
                    desj = j;
                }
            }
        }
        int answer = -1;
        boolean[][] v = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[si][sj] = true;
        q.offer(new int[] { si, sj, 0 });
        int distance = 0;
        while (!q.isEmpty()) {
            int[] ijd = q.poll();
            int i = ijd[0];
            int j = ijd[1];
            int dis = ijd[2];
            if (i == desi && j == desj) {
                answer = dis;
                break;
            }
            // 거리가 똑같을때 악마를 퍼뜨림
            if (dis == distance) {
                spread();
                distance++;
            }
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj]
                        && (map[ni][nj] == area || map[ni][nj] == god)) {
                    v[ni][nj] = true;
                    q.offer(new int[] { ni, nj, dis + 1 });
                }
            }
		}
        sb.append(answer == -1 ? "KAKTUS" : answer);
		System.out.print(sb);
		br.close();
	}

	private static void spread() {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == devil) {
					list.add(new int[] { i, j });
				}
			}
		}
		for (int[] is : list) {
			for (int d = 0; d < 4; d++) {
				int ni = is[0] + di[d];
				int nj = is[1] + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == area) {
					map[ni][nj] = devil;
				}
			}
		}
	}

}