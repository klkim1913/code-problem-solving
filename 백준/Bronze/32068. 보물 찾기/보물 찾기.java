import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            if (Math.abs(S - R) <= Math.abs(S - L)) {
                System.out.println(Math.abs(S - R) * 2);
            } else {
                System.out.println(Math.abs(S - L) * 2 + 1);
            }
        }
        br.close();
    }
}