import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] plus = new int[10_000_001];
        int[] minus = new int[10_000_000];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n >= 0)
                plus[n]++;
            else {
                minus[-n]++;
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n >= 0 && plus[n] == 1)
                sb.append(1).append(' ');
            else if (n < 0 && minus[-n] == 1) {
                sb.append(1).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }
        System.out.println(sb);
        br.close();
    }

}