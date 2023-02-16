package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 규영이와_인영이의_카드게임 {
    static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] you, my;
        boolean[] myVisited;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            you = new int[9];
            my = new int[9];
            win = lose = 0;
            myVisited = new boolean[9];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 9; i++) {
                you[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(you); // 정렬해도 모든 조합 보기때문에 승패 횟수 상관 없음
            for (int i = 0, j = 0, num = 1; num <= 18; num++) {
                if (j < 9 && you[j] == num) {
                    j++;
                    continue;
                }
                my[i++] = num;
            }
            perm(0, you, my, myVisited, 0, 0); // 마지막 두개는 각각 총점
            sb.append(win).append(' ').append(lose).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    private static void perm(int cnt, int[] you, int[] my, boolean[] myVisited, int youSum,
                             int mySum) {
        if (cnt == 9) {
            if (mySum < youSum) {
                win++;
            } else if (mySum > youSum) {
                lose++;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (myVisited[i])
                continue;
            myVisited[i] = true;
            if (you[cnt] > my[i]) {
                perm(cnt + 1, you, my, myVisited, youSum + you[cnt] + my[i], mySum);
            } else {
                perm(cnt + 1, you, my, myVisited, youSum, mySum + you[cnt] + my[i]);
            }
            myVisited[i] = false;
        }
    }

}
