package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SimpleBinaryCode {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        List<String> strList = Arrays.asList("0001101", "0011001", "0010011", "0111101", "0100011",
                "0110001", "0101111", "0111011", "0110111", "0001011");
        for (int t = 1; t <= tc; t++) {
            int[] arr = new int[8];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                if (s.contains("1")) {
                    int start = s.indexOf("1");
                    int end = s.lastIndexOf("1");
                    s = s.substring(start, end + 1);
                    if (s.length() < 56) {
                        s = String.format("%56s", s).replace(" ", "0");
                        int idx = 0;
                        for (int k = 0; k < 56; k += 7) {
                            String ss = s.substring(k, k + 7);
                            arr[idx++] = strList.indexOf(ss);
                        }
                    }
                }
            }
            int sum = (arr[0] + arr[2] + arr[4] + arr[6]) * 3 + arr[1] + arr[3] + arr[5] + arr[7];
            if (sum % 10 == 0) {
                System.out.printf("#%d %d\n", t, Arrays.stream(arr).sum());
            } else {
                System.out.printf("#%d %d\n", t, 0);
            }
        }
    }
}
