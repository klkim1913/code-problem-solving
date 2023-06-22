import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static String[][] map = new String[5][5];
    static Set<Integer> set = new HashSet<>();
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(map[i][j], i, j, 0);
            }
        }
        System.out.print(set.size());
        br.close();
    }

    private static void dfs(String num, int i, int j, int cnt) {
        if (cnt == 5) {
            set.add(Integer.parseInt(num));
            return;
        }
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < 5 && 0 <= nj && nj < 5) {
                dfs(num + map[ni][nj], ni, nj, cnt + 1);
            }
        }
    }
}