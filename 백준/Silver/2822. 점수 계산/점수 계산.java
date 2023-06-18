import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] copy = new int[8];
        for (int i = 0; i < 8; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int sum = 0;
        for (int i = 7; i >= 3; i--) {
            sum += copy[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 3; j < 8; j++) {
                if (arr[i] == copy[j]) {
                    sb.append(i + 1).append(' ');
                }
            }
        }
        System.out.println(sum);
        System.out.println(sb);
        br.close();
    }
}