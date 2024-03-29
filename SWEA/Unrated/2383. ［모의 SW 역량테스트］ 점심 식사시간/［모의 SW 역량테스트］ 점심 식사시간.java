import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N, cnt, min;

	static class Person implements Comparable<Person> {
		int r, c, arrivalTime;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}

	}

	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<>(); // 사람리스트
			sList = new int[2][]; // 계단리스트
			min = Integer.MAX_VALUE;
			for (int i = 0, k = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) {
						pList.add(new Person(i, j));
					} else if (c > 1) { // 계단
						sList[k++] = new int[] { i, j, c };
					}
				}
			}
			cnt = pList.size();
			selected = new int[cnt]; // 선택한 계단 인덱스
			// 모든 사람에게 계단 배정
			divide(0);
			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.print(sb);
		br.close();
	}

	private static void divide(int index) {
		if (index == cnt) {
			int res = go();
			if (min > res)
				min = res;
			return;
		}
		// 계단0 선택
		selected[index] = 0;
		divide(index + 1);
		// 계단1 선택
		selected[index] = 1;
		divide(index + 1);
	}

	// 선택된 계단에 따라 사람들의 리스트 만들고 내려가기 처리 후 소요된 시간 리턴
	private static int go() {
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(), new ArrayList<Person>() };

		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			int no = selected[i];
			p.arrivalTime = Math.abs(p.r - sList[no][0]) + Math.abs(p.c - sList[no][1]);
			list[no].add(p);
		}

		int timeA = 0, timeB = 0;
		if (list[0].size() > 0) {
			timeA = processDown(list[0], sList[0][2]);
		}
		if (list[1].size() > 0) {
			timeB = processDown(list[1], sList[1][2]);
		}
		return timeA > timeB ? timeA : timeB;
	}

	static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);
		int size = list.size() + 3;
		int[] D = new int[size];
		for (int i = 3; i < size; i++) {
			Person p = list.get(i - 3);
			if (D[i - 3] <= p.arrivalTime + 1) {
				D[i] = p.arrivalTime + 1 + height;
			} else {
				D[i] = D[i - 3] + height;
			}
		}
		return D[size - 1];
	}

}