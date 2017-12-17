package algorithms;

import java.util.Scanner;

public class LonelyInteger {
	
	int n;
	int[] a;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
	}
	
	int handle() {
		int n = a.length;
		quickSort(a, 0, n - 1);
		// n odd
		int last = n - 2;
		for (int i = 0; i < last; i += 2) {
			if ((a[i] ^ a[i + 1]) != 0) {
				return i;
			}
		}
		return n - 1;
	}
	
	void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = partition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}
	
	int partition(int[] a, int left, int right) {
		int pivot = a[right];
		int i = left - 1;
		for (int j = left; j < right; ++j) {
			if (a[j] < pivot) {
				++i;
				swap(a, j, i);
			}
		}
		++i;
		swap(a, right, i);
		return i;
	}
	
	void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] ^= a[j];
			a[j] ^= a[i];
			a[i] ^= a[j];
		}
	}
	
	void printArray(int[] a) {
		int n = a.length;
		System.out.println("QuickSort:");
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	void test() {
		init();
		System.out.print(a[handle()]);
	}
	
	public static void main(String[] args) {
		new LonelyInteger().test();
	}

}
