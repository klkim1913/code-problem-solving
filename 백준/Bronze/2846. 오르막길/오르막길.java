import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max, start, prev;
        max = 0;
        start = prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (prev < n) {
                max = Math.max(max, n - start);
                prev = n;
            } else {
                start = n;
                prev = n;
            }

        }
        System.out.print(max);
        br.close();
    }

}