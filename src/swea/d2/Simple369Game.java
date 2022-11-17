package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Simple369Game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s=Integer.toString(i);
            boolean isClap=false;
            for (char sn : s.toCharArray()) {
                if(sn=='3'||sn=='6'||sn=='9') {
                    isClap=true;
                    System.out.print("-");
                }
            }
            if(!isClap) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
