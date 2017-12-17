package statistic;

import java.util.Scanner;

public class StandardDeviation {
	
	static float handle() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		float median = 0;
		for (int i = 0; i < n; ++i) {
			x[i] = sc.nextInt();
			median += x[i];
		}
		median /= n;
		float g = 0;
		for (int i = 0; i < n; ++i) {
			float u  = x[i] - median;
			g += u * u;
		}
		g /= n;
		return Float.valueOf(String.format("%.1f", Math.sqrt(g)));
	}
	
	public static void main(String[] args) {
		System.out.print(handle());
	}

}
