package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FilmDirectorShom {
    /*
     * 1. 666, 1666~5666, 6660~6669, 7666~9666/19개 10666~15666
     *
     */
    // 1. 그냥 초기값부터 쭉 탐색
    // or 자리수로 666검색해서 하기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int num = 666;
        while (true) {
            if (String.valueOf(num).contains("666")) {
                if (cnt == N) {
                    System.out.println(num);
                    return;
                }
                cnt++;
            }
            num++;
        }
    }
}
