import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int sum = 0;


        for (int i = 0; i < caseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n % 2 == 1) {
                    sum += n;
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
            sum = 0;
        }
    }
}