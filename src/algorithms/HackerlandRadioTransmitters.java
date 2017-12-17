package algorithms;

import java.util.Scanner;

public class HackerlandRadioTransmitters {
	
	static void handle() {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int k = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = sc.nextInt();
		}
		if (n == 1) {
			result = 1;
		} else {
			quickSort(x, 0, n - 1);
//			printArray(x);
			int i = 0;
			while (i <= n - 1) {
				++result;
				i = getNextPosition(x, i, n, k);
				if (i == -1) {
					break;
				}
			}
		}
		System.out.print(result);
	}
	
	static int getNextPosition(int[] x, int firstPosition, int n, int k) {
		if (firstPosition == n - 1) {
			return -1;
		}
		int radioPosition = firstPosition;
		int d = x[radioPosition] + k;
		while (radioPosition <= n - 1) {
			if (x[radioPosition] <= d) {
				++radioPosition;
			} else {
				break;
			}
		}
		--radioPosition;
		d = x[radioPosition] + k;
		while (radioPosition <= n - 1) {
			if (x[radioPosition] <= d) {
				++radioPosition;
			} else {
				break;
			}
		}
		--radioPosition;
		if (radioPosition == n - 1) {
			return -1;
		} else {
			return radioPosition + 1;
		}
	}
	
	static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int p = partition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}
	
	static int partition(int[] a, int left, int right) {
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
	
	static void swap(int[] a, int i, int j) {
		if (i != j) {
			a[i] ^= a[j];
			a[j] ^= a[i];
			a[i] ^= a[j];
		}
	}
	
	static void printArray(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		handle();
	}

}
