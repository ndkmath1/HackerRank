package codinginterview;

import java.util.Scanner;

public class ArraysLeftRotation {

	static int[] handle() {
		int n, d;
		int[] a;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; ++i) {
//			a[(i + n - d) % n] = sc.nextInt();
			int q = i - d;
			q = q >= 0 ? q : (n - 1) * (-q) % n;
			a[q] = sc.nextInt();
		}
		return a;
	}

	static void printArray(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; ++i) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		printArray(handle());
	}

}
