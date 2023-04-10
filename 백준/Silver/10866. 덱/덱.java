import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> d = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    d.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    d.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    Integer num = d.pollFirst();
                    if (num == null)
                        num = -1;
                    sb.append(num).append('\n');
                    break;
                case "pop_back":
                    num = d.pollLast();
                    if (num == null)
                        num = -1;
                    sb.append(num).append('\n');
                    break;
                case "size":
                    sb.append(d.size()).append('\n');
                    break;
                case "empty":
                    sb.append(d.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    num = d.peekFirst();
                    if (num == null)
                        num = -1;
                    sb.append(num).append('\n');
                    break;
                case "back":
                    num = d.peekLast();
                    if (num == null)
                        num = -1;
                    sb.append(num).append('\n');
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }

}