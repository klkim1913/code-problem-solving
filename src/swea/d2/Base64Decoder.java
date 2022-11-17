package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Base64Decoder {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // StringBuilder로 개선해야함.
        for (int i = 0; i < T; i++) {
            String enc = br.readLine();
            String bin = "";
            for (int j = 0; j < enc.length(); j++) {
                if ('A' <= enc.charAt(j) && enc.charAt(j) <= 'Z') {
                    bin += String.format("%6s", Integer.toBinaryString(enc.charAt(j) - 'A'))
                            .replace(" ", "0");
                } else if ('a' <= enc.charAt(j) && enc.charAt(j) <= 'z') {
                    bin += String.format("%6s", Integer.toBinaryString(enc.charAt(j) - 'a' + 26))
                            .replace(" ", "0");
                } else if ('0' <= enc.charAt(j) && enc.charAt(j) <= '9') {
                    bin += String.format("%6s", Integer.toBinaryString(enc.charAt(j) - '0' + 52))
                            .replace(" ", "0");
                } else if (enc.charAt(j) == '+') {
                    bin += String.format("%6s", Integer.toBinaryString(62)).replace(" ", "0");
                } else if (enc.charAt(j) == '/') {
                    bin += String.format("%6s", Integer.toBinaryString(63)).replace(" ", "0");
                }
            }
            System.out.printf("#%d ", i + 1);
            String oneBin = "";
            int cnt = 0;
            for (int j = 0; j < bin.length(); j++) {
                oneBin += bin.charAt(j);
                cnt++;
                if (cnt == 8) {
                    System.out.printf("%c", Integer.parseInt(oneBin, 2));
                    oneBin = "";
                    cnt = 0;
                }
            }
            System.out.println();
        }
    }
}
