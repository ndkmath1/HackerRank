package algorithms;

import java.util.Scanner;

public class RunningTimeOfInsertionSort {
	
	int n;
	int[] a;
	int totalShift;
	
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
		insertionSort(a);
		System.out.print(totalShift);
	}
	
	void insertionSort(int[] a) {
		for (int i = 1; i < n; ++i) {
			insert(a, i);
		}
	}
	
	void insert(int[] a, int i) {
		int temp = a[i];
		int j = i - 1;
		for (; j >= 0 && a[j] > temp; --j) {
			++totalShift;
			a[j + 1] = a[j];
		}
		a[j + 1] = temp;
	}
	
	public static void main(String[] args) {
		new RunningTimeOfInsertionSort().handle();
	}
	
}
