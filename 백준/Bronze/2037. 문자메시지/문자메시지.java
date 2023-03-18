import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        char[][] pad = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'},
                {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int pre = -1;
        int sum = 0;
        to: for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sum += p;
                pre = -1;
            } else {
                for (int j = 0; j < pad.length; j++) {
                    for (int k = 0; k < pad[j].length; k++) {
                        if (arr[i] == pad[j][k]) {
                            sum += (k + 1) * p;
                            if (i != 0 && pre == j) {
                                sum += w;
                            }
                            pre = j;
                            continue to;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
        br.close();
    }

}