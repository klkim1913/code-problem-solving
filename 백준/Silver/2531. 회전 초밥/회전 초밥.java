import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다.
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		// 현재 집합에서 인덱스 초밥이 몇개 들어있냐
		int[] dv = new int[d + 1];
		// 슬라이딩 윈도우 활용(앞에 빠졌을때 0이면 가지수 빼고, 1이면 가지수 안빼고,
		// 뒤에꺼 넣을때도 넣었을때 1이면 가지수 추가하고 2 이상이면 안추가하고.
		// 쿠폰번호 추가했을때도 1이면 가지수 추가하고 2 이상이면 안추가하고.
		// max값이 k+1이 나오면 바로 종료
		int kind = 0, max = 0;
		int left = 0;
		int right = k - 1;
		dv[belt[left]]++;
		kind++;
		if (dv[belt[right]] == 0)
			kind++;
		dv[belt[right++]]++;
		for (int i = 1; i < k - 1; i++) {
			// 그 음식이 현재 들어있지 않다면 종류가 추가
			if (dv[belt[i]] == 0)
				kind++;
			dv[belt[i]]++;
			if (max < kind)
				max = kind;
		}
		while (left < N) {
			if (max == k + 1)
				break;
			// 앞에꺼 뺐는데 0이되면 1종류 빼기
			if (--dv[belt[left % N]] == 0)
				kind--;
			// 뒤에꺼 추가했는데 처음이면 종류 추가
			if (++dv[belt[right % N]] == 1)
				kind++;
			// 쿠폰 처음 추가이면 종류 추가
			if (++dv[c] == 1)
				kind++;
			if (max < kind)
				max = kind;
			right++;
			left++;
		}
		System.out.print(max);
		br.close();
	}

}