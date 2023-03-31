import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 1. 테이블: i번을 끝으로 하는 LIS의 길이
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] LIS = new int[N];
			int max = 1;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && LIS[j] + 1 > LIS[i]) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if (max < LIS[i])
					max = LIS[i];
			}
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.print(sb);
		br.close();
	}

}