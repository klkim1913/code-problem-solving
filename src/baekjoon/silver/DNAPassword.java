package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class DNAPassword {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        char[] arr = {'A', 'C', 'G', 'T'};
        int[] ch = new int['T' - 'A' + 1]; // 저장 편하게 하기 위해
        int[] min = new int[ch.length];
        String s = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[arr[i] - 'A'] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < S; i++) {
            ch[s.charAt(i) - 'A']++;
        }
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (min[arr[i] - 'A'] > ch[arr[i] - 'A']) {
                flag = false;
                break;
            }
        }
        int sum = 0;
        if (flag) {
            sum++;
        }
        int prev = 0, next = S - 1; // 삭제할 포인터와 다음 포인터
        while (next < P - 1) { // 다음이동한 끝까지가 P범위 안쪽이면
            ch[s.charAt(prev++) - 'A']--;
            ch[s.charAt(++next) - 'A']++;
            flag = true;
            for (int i = 0; i < 4; i++) {
                if (min[arr[i] - 'A'] > ch[arr[i] - 'A']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum++;
            }
        }
        System.out.println(sum);
    }

}
