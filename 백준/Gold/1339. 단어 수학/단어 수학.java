import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[27];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[s.charAt(j) - 'A' + 1] += (int) Math.pow(10, s.length() - 1 - j);
			}
		}
		int sum = 0;
		int n = 9;
		while (true) {
			int maxi = 0;
			for (int i = 1; i <= 26; i++) {
				if (arr[maxi] < arr[i])
					maxi = i;
			}
			if (maxi == 0)
				break;
			else {
				sum += arr[maxi] * n;
				arr[maxi] = 0;
				n--;
			}
		}
		System.out.println(sum);
		br.close();
	}

}