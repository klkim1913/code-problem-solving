package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class FindMostFrequentNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            int caseNum = Integer.parseInt(br.readLine());
            int[] cntArr = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                cntArr[Integer.parseInt(st.nextToken())]++;
            }
            int maxCnt = Arrays.stream(cntArr).max().getAsInt();
            int most = Arrays.stream(cntArr).boxed().collect(Collectors.toList()).lastIndexOf(maxCnt);
            System.out.println("#" + caseNum + " " + most);
        }
    }
}
