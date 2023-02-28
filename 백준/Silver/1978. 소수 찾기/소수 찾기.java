import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                cnt--;
                continue;
            }
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

}