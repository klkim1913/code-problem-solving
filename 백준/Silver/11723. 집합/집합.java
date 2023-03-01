import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextElement().toString()) {
                case "add":
                    arr[Integer.parseInt(st.nextToken())] = 1;
                    break;
                case "remove":
                    arr[Integer.parseInt(st.nextToken())] = 0;
                    break;
                case "check":
                    if (arr[Integer.parseInt(st.nextToken())] == 1) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    int x = Integer.parseInt(st.nextToken());
                    arr[x] = (arr[x] == 1) ? 0 : 1;
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        arr[j] = 1;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        arr[j] = 0;
                    }
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

}