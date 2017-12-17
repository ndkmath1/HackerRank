package algorithms;

import java.util.Scanner;

public class TheGridSearch {

	static int getNextIndex(char[] t, char[] p, int firstIndex) {
		int n = t.length;
		int m = p.length;
		int max = n - m;
		int i = firstIndex;
		for (; i <= max; ++i) {
			int j = 0;
			for (; j < m && p[j] == t[i + j]; ++j);
			if (j == m) {
				return i;
			}
		}
		return -1;
	}

	static void handle() {
		Scanner sc = new Scanner(System.in);
		int totalTest = sc.nextInt();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < totalTest; ++i) {
			int R, C, r, c;
			R = sc.nextInt();
			C = sc.nextInt();
			String[] grid = new String[R];
			for (int j = 0; j < R; ++j) {
				grid[j] = sc.next();
			}
			r = sc.nextInt();
			c = sc.nextInt();
			String[] pattern = new String[r];
			for (int j = 0; j < r; ++j) {
				pattern[j] = sc.next();
			}
			int last = R - r;
			boolean check = false;
            char[] pc = pattern[0].toCharArray();
			for (int j = 0; j <= last; ++j) {
				int current = 0;
				char[] gc = grid[j].toCharArray();
				current = getNextIndex(gc, pc, current);
				while (current != -1) {
					int count = 1;
					for (int k = 1; k < r; ++k) {
						if (!grid[j + k].substring(current, current + c).equals(pattern[k])) {
							break;
						} else {
							++count;
						}
					}
					if (count == r) {
						check = true;
						break;
					}
					current = getNextIndex(gc, pc, current + 1);
				}
				if (check) {
					break;
				}
			}
			if (check) {
				result.append("YES\n");
			} else {
				result.append("NO\n");
			}
		}
		System.out.println(result.toString());
	}

	public static void main(String[] args) {
		handle();
	}

}
