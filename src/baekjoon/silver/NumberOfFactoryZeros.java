package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. N팩 저장해서 재귀 최적화
 * 2. 뒤에서 문자열 서칭
 * - N!이 int범위 넘어서 안됨
 */
/*
 * 1. 2x5의 짝에 의해 0의 개수가 결정됨
 * 2. 5의 배수마다 +1
 * 3. 5의 제곱마다 추가로 +1
 */
public class NumberOfFactoryZeros {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }
        System.out.println(cnt);
    }
}
