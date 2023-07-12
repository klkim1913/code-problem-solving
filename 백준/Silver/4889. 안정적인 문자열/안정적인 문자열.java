import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            String s = br.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int sum = 0;
            if (s.charAt(0) == '-') break;
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if (stack.isEmpty()) {
                    if (now == '}') {
                        sum++;
                    }
                    stack.push('{');
                    continue;
                }
                char peek = stack.peek();
                if (peek == '{') {
                    if (now == '}') {
                        stack.pop();
                    } else {
                        stack.push(now);
                    }
                }
            }
            sum += stack.size() / 2;
            sb.append(tc++).append('.').append(' ').append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
