package statistic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeanMedianMode {
	
	static void handle() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		double mean = 0, median = 0;
		int mode = 0;
		for (int i = 0; i < n; ++i) {
			mean += a[i];
		}
		mean /= n;
		Arrays.sort(a);
		if (n % 2 == 1) {
			median = a[n/2];
		} else {
			median = (a[n/2] + a[n/2 - 1]) / 2.0;
		}
		mode = getMode(a, n);
		System.out.printf("%.1f\n", mean);
		System.out.printf("%.1f\n", median);
		System.out.printf("%d", mode);
	}
	
	static int getMode(int[] a, int n) {
		int[][] r = new int[n][2];
		int j = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (a[i] == a[i + 1]) {
				r[j][0] = a[i];
				r[j][1] += 1;
			} else {
				r[j][0] = a[i];
				r[j][1] += 1;
				++j;
			}
		}
		int min = 0;
		for (int i = 1; i < n; ++i) {
			if (r[i][0] == 0) {
				break;
			} else {
				if (r[i][1] > r[min][1]) {
					min = i;
				}
			}
		}
		return r[min][0];
	}
	
	public static void main(String[] args) {
		handle();
	}

}
