package codinginterview;

import java.util.Scanner;

public class DPCoinChange {

	static int[][] f;
	static int n, m;
	static int[] coins;

	static void handle() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		// int[] result = new int[n + 1]; // store result
		m = in.nextInt();
		coins = new int[m];
		for (int i = 0; i < m; ++i) {
			coins[i] = in.nextInt();
		}
		in.close();
		f = new int[n][m];
		for (int i = 1; i < n; ++i) {
			f[i][0] = 1;
		}
		for (int j = 0; j < m; ++j) {
			f[0][j] = 0;
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				f[i][j] = -1;
			}
		}
		System.out.print(calc(n, m));
	}

	static int calc(int n, int m) {
		if (f[n - 1][m - 1] == -1) {
			if (coins[m - 1] > n) {
				f[n - 1][m - 1] = calc(n, m - 1);
			} else {
				f[n - 1][m - 1] = calc(n, m - 1) + calc(n - coins[m - 1], m);
			}
		}
		return f[n - 1][m - 1];
	}

	public static void main(String[] args) {
		handle();
	}

}
