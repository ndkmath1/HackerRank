package algorithms;

import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {
	
	static void handle() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < t; ++i) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; ++j) {
				a[j] = sc.nextInt();
			}
			s.append(insertionSort(a, n)  + "\n");
		}
		System.out.println(s.toString());
	}
	
	static int insertionSort(int[] a, int n) {
		int s = 0;
		for (int i = 1; i < n; ++i) {
			s += insert(a, i);
		}
		return s;
	}
	
	static int insert(int[] a, int i) {
		int temp = a[i];
		int j = i - 1;
		int s = 0;
		for (; j >= 0 && a[j] > temp; --j) {
			++s;
			a[j + 1] = a[j];
		}
		a[j + 1] = temp;
		return s;
	}
	
	public static void main(String[] args) {
		handle();
	}

}
