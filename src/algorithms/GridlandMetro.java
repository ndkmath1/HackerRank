package algorithms;

import java.util.Scanner;

public class GridlandMetro {
	
	static void handle() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[][] a  = new int[n][m];
		for (int i = 0; i < k; ++i) {
			int r = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			for (int j = c1 - 1; j < c2; ++j) {
				if (a[r-1][j] == 0) {
					a[r-1][j] = 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (a[i][j] == 0) {
					++count;
				}
			}
		}
		System.out.print(count);
	}
	
	public static void main(String[] args) {
		handle();
	}

}
