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
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        if (sum <= M) {
            System.out.print(arr[N - 1]);
        } else {
            int right = arr[N - 1];
            int left = 1;
            int mid = 0;
            while (left <= right) {
                mid = (right + left) / 2;
//                System.out.println("left: " + left + " right: " + right + " mid: " + mid + "가능 여부: "
//                        + check(mid, arr, M));
                if (check(mid, arr, M)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.print(right);
        }
        br.close();
    }

    private static boolean check(int mid, int[] arr, int M) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                sum += mid;
            } else {
                sum += arr[i];
            }
        }
        if (sum <= M)
            return true;
        else
            return false;
    }

}