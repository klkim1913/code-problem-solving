package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day4Power {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int base = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());
            int result = 1;
            for (int i = 0; i < exp; i++) {
                result *= base;
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
