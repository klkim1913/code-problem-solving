import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder Ssb = new StringBuilder(br.readLine());
        StringBuilder Tsb = new StringBuilder(br.readLine());
        while (Ssb.length() != Tsb.length()) {
            if (Tsb.charAt(Tsb.length() - 1) == 'A') {
                Tsb.deleteCharAt(Tsb.length() - 1);
            } else {
                Tsb.deleteCharAt(Tsb.length() - 1);
                Tsb.reverse();
            }
        }
        if (Ssb.toString().equals(Tsb.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

}