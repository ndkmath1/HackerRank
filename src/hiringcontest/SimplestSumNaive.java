package hiringcontest;

import java.util.Scanner;

public class SimplestSumNaive {

	static final int MAX = 1000000007; // 10^9 + 7

	static int f(int k, int n) {
		int sum = 0;
		for (int i = 1; i <= n; i += 1) {
			sum += i;
			i *= k;
		}
		return sum;
	}

	static int simplestSum(int k, int a, int b) {
		long sum = 0;
		for (int i = a; i <= b; ++i) {
			sum += f(k, i);
			sum %= MAX;
		}
		return (int) sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int k = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int result = simplestSum(k, a, b);
			System.out.println(result);
		}
		in.close();
	}

}
