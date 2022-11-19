package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day5GNS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        List<String> strList =
                Arrays.asList("ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN");
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            int cnt = 0;
            while (cnt < len) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
                    arr[cnt] = strList.indexOf(str);
                    cnt++;
                }
            }
            Arrays.sort(arr);
            System.out.printf("#%d\n", t);
            for (int i = 0; i < len; i++) {
                System.out.print(strList.get(arr[i]) + " ");
            }
            System.out.println();
        }
    }
}
