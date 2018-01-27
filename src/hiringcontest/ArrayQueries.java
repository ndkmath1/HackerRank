package hiringcontest;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQueries {

	static final int MAX = 1000000007;// 10^9 + 7

	static int arrayAndQueries(int[] A, int[][] queries) {
		int len = queries.length;
		int s = 0;
		for (int i = 0; i < len; ++i) {
			A[queries[i][0] - 1] = queries[i][1];
			System.out.println("qa = " + q(A));
			s += q(A) * (i + 1);
			s %= MAX;
		}
		return s;
	}

	static void printArray(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; ++i) {
			System.out.print(a[i] + " ");
		}
	}

	static int[] copy(int[] a, int len) {
		int[] b = new int[len];
		for (int i = 0; i < len; ++i) {
			b[i] = a[i];
		}
		return b;
	}

	static int q(int[] A) {
		int len = A.length;
		int[] a = copy(A, len);
		Arrays.sort(a);
		// printArray(a);
		int sum = 0;
		int startIndex = 0;
		int c1 = 0, c2 = 0;
		while (startIndex < len) {
			c1 = count(a, startIndex, len);
			startIndex += c1; // new startIndex
//			if (a[0] == 2 && a[1] == 5) {
//				System.out.println("c1 = " + c1);
//				System.out.println("new start index = " + startIndex);
//			}
			sum += c1;
			while (startIndex < len) {
				if (a[startIndex] - a[startIndex - 1] == 1) {
					c2 = count(a, startIndex, len);
					if (c2 > c1) {
						sum += c2 - c1;
					}
					c1 = c2;
					startIndex += c2;
				} else {
					break;
				}
			}
		}
		return sum;
	}

	static int count(int[] a, int startIndex, int len) {
		int c = 1;
		for (int i = startIndex + 1; i < len; ++i) {
			if (a[i] == a[startIndex]) {
				++c;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int q = in.nextInt();
		int[][] queries = new int[q][2];
		for (int queries_i = 0; queries_i < q; queries_i++) {
			for (int queries_j = 0; queries_j < 2; queries_j++) {
				queries[queries_i][queries_j] = in.nextInt();
			}
		}
		int result = arrayAndQueries(A, queries);
		System.out.println(result);
		in.close();
	}

}
