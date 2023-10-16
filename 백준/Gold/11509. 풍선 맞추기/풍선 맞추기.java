import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[1_000_001];
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (height[h] >= 1) {
                height[h]--;
            } else {
                sum++;
            }
            height[h - 1]++;
        }
        System.out.println(sum);
        br.close();
    }
}