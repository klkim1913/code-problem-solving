package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3String {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int base = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());
            int result = power(base, exp);
            System.out.printf("#%d %d\n", tc, result);
        }
    }

    static int power(int b, int e) {
        if (e < 2) {
            return b;
        }
        return b * power(b, e - 1);
    }
}
