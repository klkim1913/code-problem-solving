import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, C;
	static int[][] arr;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();
	// 각 꿀통끼리 합산한 최대값
	static int maxProfit, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			a = new int[M];
			b = new int[M];
			maxProfit = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 시작점 두곳 선택
			selTwoStart();
			sb.append(maxProfit + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void selTwoStart() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				for (int c = 0; c < M; c++) {
					a[c] = arr[i][j + c];
				}
				for (int k = i; k < N; k++) {
					// 같은라인일경우 옆 담는 과정
					if (i == k) {
						for (int l = j + M; l <= N - M; l++) {
							// 각 꿀통에 담는다.
							for (int c = 0; c < M; c++) {
								b[c] = arr[k][l + c];
							}
							max = 0;
							calMaxSum(a, 0, 0, 0);
							int aSum = max;
							max = 0;
							calMaxSum(b, 0, 0, 0);
							int bSum = max;
							maxProfit = Math.max(maxProfit, aSum + bSum);
							if (maxProfit == 2 * C * C)
								return;
						}
					} else {
						// 같은 라인이 아니면 쭉 0부터
						for (int l = 0; l <= N - M; l++) {
							for (int c = 0; c < M; c++) {
								b[c] = arr[k][l + c];
							}
							max = 0;
							calMaxSum(a, 0, 0, 0);
							int aSum = max;
							max = 0;
							calMaxSum(b, 0, 0, 0);
							int bSum = max;
							maxProfit = Math.max(maxProfit, aSum + bSum);
							if (maxProfit == 2 * C * C)
								return;
						}
					}
				}
			}
		}
	}

	private static boolean calMaxSum(int[] tong, int numSum, int twoSum, int cnt) {
		// 꿀 합계가 C를 넘으면 안됨
		if (numSum > C)
			return false;
		// 합산의 최대치가 되면 아얘 종료
		if (twoSum == C * C) {
			max = twoSum;
			return true;
		}
		// 끝까지 다 돌았으면 합 계산
		if (cnt == M) {
			max = Math.max(max, twoSum);
			return false;
		}
		if (calMaxSum(tong, numSum + tong[cnt], twoSum + (tong[cnt] * tong[cnt]), cnt + 1))
			return true;
		if (calMaxSum(tong, numSum, twoSum, cnt + 1))
			return true;
		return false;
	}
}
// N*N 정사각형
// 1. 두명의 일꾼, 선택한 벌통은 겹치면 안됨
// 하나의 벌통은 하나의 용기에 담는다.
// 2. 각 일꾼당 채취할 수 있는 꿀의 최대 양은 C이다.
// 3. 확x: 맥시멈 채취 꿀의 양은 C^2*2이다.
// 4. 꿀의 범위는 1~9 정수

// 총 수익이 C^2*2면 백트래킹
// 시작지점으로 조합(2개니까 이중for로 가능)해서 +M이 범위를 넘어가면 다음줄로 시작점 넘김
// 각 꿀통에 저장 후 또 조합으로 M개를 선택해서 최대합 구함

// 1. 각 꿀통 선택
// 2. 각 꿀통당 부분집합으로 최대 점수 계산(백트래킹 가능)
// 3. 꿀통의 합으로 최대 점수 계산