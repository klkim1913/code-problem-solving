import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] arr = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i) - '0'));
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (Integer n : arr) {
            System.out.print(n);
        }
        br.close();
    }

}