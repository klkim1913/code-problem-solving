import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "<>&|() ", true);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals(" ")) {
                if (token.equals("&") || token.equals("|")) {
                    sb.append(token).append(token).append(" ");
                    st.nextToken();
                } else {
                    sb.append(token).append(" ");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

}