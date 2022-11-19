package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day3String {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String sentence = br.readLine();
            sentence = sentence.replace(word, " ");
            int sum = 0;
            for (char c : sentence.toCharArray()) {
                if (c == ' ') {
                    sum++;
                }
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
