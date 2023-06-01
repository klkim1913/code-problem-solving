import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr= new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int max=0;
        for (int i = 0; i < K; i++) {
            max += arr[i];
        }
        int preSum=max;
        for (int i = K; i < N; i++) {
            preSum=preSum-arr[i-K]+arr[i];
            if(preSum>max){
                max=preSum;
            }
        }
        System.out.println(max);
        br.close();
    }
}