import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static ArrayList<double[]> edges;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			Point2D[] points = new Point[N];
			edges = new ArrayList<>();
			p = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] xs = new int[N];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				xs[i] = x;
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int y = Integer.parseInt(st.nextToken());
				points[i] = new Point(xs[i], y);
			}
			double E = Double.parseDouble(br.readLine());
			int cnt = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double distance = points[i].distance(points[j]);
					edges.add(new double[] { i, j, distance });
				}
			}
			Collections.sort(edges, (o1, o2) -> Double.compare(o1[2], o2[2]));
			init();
			double result = 0.0;
			cnt = 0;
			for (double[] edge : edges) {
				if (!union(edge[0], edge[1])) {
					result += E * edge[2] * edge[2];
					if (cnt++ == N - 1)
						break;
				}
			}
			result = Math.round(result);
			BigDecimal b = new BigDecimal(result);
			sb.append("#" + tc + " " + b + "\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static boolean union(double a, double b) {
		int aRoot = find((int) a);
		int bRoot = find((int) b);
		if (aRoot == bRoot)
			return true;
		p[bRoot] = aRoot;
		return false;
	}

	private static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}

}