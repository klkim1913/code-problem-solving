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
		boolean[] v = new boolean[m + 1];
		for (int i = n; i > n - m; i--) {
			result = result.multiply(BigInteger.valueOf(i));
			for (int j = 2; j <= m; j++) {
				if (!v[j] && result.remainder(BigInteger.valueOf(j)) == BigInteger.ZERO) {
					result = result.divide(BigInteger.valueOf(j));
					v[j] = true;
				}
			}
		}
		System.out.print(result);
		br.close();
	}

}