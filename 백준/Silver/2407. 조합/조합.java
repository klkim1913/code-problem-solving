import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger result = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;
		for (int i = n; i > n - m; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		for (int j = 2; j <= m; j++) {
			div = div.multiply(BigInteger.valueOf(j));
		}
		System.out.print(result.divide(div));
		br.close();
	}

}