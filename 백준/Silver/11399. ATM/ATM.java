import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] sums = new int[N];
        sums[0] = arr[0];
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += sums[i];
        }
        System.out.println(answer);
        br.close();
    }

}