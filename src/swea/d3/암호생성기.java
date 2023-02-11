package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 암호생성기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) {
            int tc = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }
            end:
            while (true) {
                for (int j = 1; j <= 5; j++) {
                    int n = dq.pollFirst() - j;
                    if (n <= 0) {
                        dq.offerLast(0);
                        break end;
                    } else {
                        dq.offerLast(n);
                    }
                }
            }
            sb.append('#').append(tc).append(' ');
            for (int j = 0; j < 8; j++) {
                sb.append(dq.pollFirst()).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
