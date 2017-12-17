package algorithms;

import java.util.Scanner;

public class QuickSortPartion {
	
	int n;
	int[] a;
	
	void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
	}
	
	void handle() {
		init();
		//quickSort(a);
//		partition(a, 0, n - 1);
//		printArray(a);
		quickSort(a, 0, n - 1);
		printArray(a);
	}
	
	void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = partition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}
	
	int partition(int[] a, int left, int right) {
		swap(a, left , right);
		return partitionRight(a, left , right);
	}
	
	int partitionRight(int[] a, int left, int right) {
		int pivot = a[right];
		int i = left - 1;
		for (int j = left; j < right; ++j) {
			if (a[j] < pivot) {
				++i;
				swap(a, i, j);
			}
		}
		++i;
		swap(a, i, right);
		return i;
	}
	
	void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] = (a[i] + a[j]) - (a[j] = a[i]);
		}
	}
	
	void printArray(int[] a) {
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		new QuickSortPartion().handle();
	}

}
