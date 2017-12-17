package algorithms;

import java.util.Scanner;

public class SherlockAndValidString {
	
	char[] input;
	
	void init() {
		Scanner sc = new Scanner(System.in);
		input = sc.next().toCharArray();
	}
	
	boolean isValidString() {
		int n = input.length;
		quickSort(input, 0, n - 1);
		int f = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (input[i] == input[i + 1]) {
				++f;
			} else {
				break;
			}
		}
		++f;
		int g = 0;
		return false;
	}
	
	void quickSort(char[] a, int left, int right) {
		if (left < right) {
			int p = partition(a, left, right);
			quickSort(a, left, p - 1);
			quickSort(a, p + 1, right);
		}
	}
	
	int partition(char[] a, int left, int right) {
		char pivot = a[right];
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
	
	void swap(char[] a, int i, int j) {
		if (i != j) {
			char t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
	}
	
	void test() {
		
	}
	
	public static void main(String[] args) {
		
	}

}
