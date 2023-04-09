import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    q.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer num = q.pollFirst();
                    if (num == null)
                        num = -1;
                    sb.append(num).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    num = q.peek();
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