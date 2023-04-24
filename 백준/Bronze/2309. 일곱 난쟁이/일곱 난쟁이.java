import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		ArrayList<Integer> list = new ArrayList<>();
		end: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							list.add(arr[k]);
						}
					}
					break end;
				}
			}
		}
		Collections.sort(list);
		for (int n : list) {
			System.out.println(n);
		}

		br.close();
	}

}