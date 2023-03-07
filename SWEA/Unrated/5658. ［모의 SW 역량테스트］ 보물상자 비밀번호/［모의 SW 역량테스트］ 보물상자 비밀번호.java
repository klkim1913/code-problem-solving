import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            String s = br.readLine();
            String sAdd = s + s.substring(0, N / 4 - 1);
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(sAdd.substring(i, i + N / 4), 16);
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            sb.append("#" + tc + " " + list.get(K - 1) + "\n");
        }
        System.out.println(sb);
        br.close();
    }

}