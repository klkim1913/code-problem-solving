import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int cnt = 1;  // 첫번째에 발견은 불가능
            boolean buho = true;
            while (S != L && S != R) {
                if (buho) {
                    S += cnt;
                } else {
                    S -= cnt;
                }
                buho = !buho;
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}