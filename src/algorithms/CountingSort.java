package algorithms;

import java.util.Scanner;

public class CountingSort {
	
	int n;
	int[] a;
	final int MAX = 100;
	int[] b = new int[MAX];
	
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
		count();
//		printArray(sort());
		printArray(sort(), a);
	}
	
	void count() {
		for (int i = 0; i < n; ++i) {
			++b[a[i]];
		}
		// caculate rank of all element
		for (int i = 1; i < MAX; ++i) {
			b[i] += b[i - 1];
		}
	}
	
	int[] sort() {
		int[] c = new int[n];
		for (int i = 0; i < n; ++i) {
//			c[b[a[i]] - 1] = a[i];
			c[b[a[i]] - 1] = i;
			--b[a[i]];
		}
		return c;
	}
	
	void printArray(int[] index, int[] value) {
		for (int i = 0; i < n; ++i) {
			System.out.print(value[index[i]] + " ");
		}
	}
	
	void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		new CountingSort().handle();
	}

}
