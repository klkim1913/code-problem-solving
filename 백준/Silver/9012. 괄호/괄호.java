import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        to: for (int i = 0; i < T; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                    stack.offer(s.charAt(j));
                else {
                    Character c = stack.pollLast();
                    if (c == null || c == ')') {
                        sb.append("NO").append('\n');
                        continue to;
                    }
                }
            }
            if (!stack.isEmpty()) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }

}