package worldcodesprint12;

import java.util.Scanner;

public class FactorialArray {

	static final int MAX = 1000000000;

	static void op1(int[] a, int l, int r) {
		for (int i = l - 1; i < r; ++i) {
			++a[i];
		}
	}

	static void op2(int[] a, int l, int r) {
		int sum = 0;
		for (int i = l - 1; i < r; ++i) {
			sum += factorial(a[i], MAX);
			if (sum > MAX) {
				sum %= MAX;
			}
		}
		System.out.println(sum);
	}

	static void op3(int[] a, int i, int v) {
		a[i - 1] = v;
	}

	static long factorial(int n, int MAX) {
		long result = 1;
		while (n > 0) {
			for (int i = 2, m = n % MAX; i <= m; i++) {
				result = (result * i) % MAX;
			}
			if ((n /= MAX) % 2 > 0) {
				result = MAX - result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		for (int a0 = 0; a0 < m; a0++) {
			// Write Your Code Here
			int op = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			switch (op) {
			case 1:
				op1(A, l, r);
				break;
			case 2:
				op2(A, l, r);
				break;
			case 3:
				op3(A, l, r);
				break;
			}
		}
		in.close();
	}
}
