package codinginterview;

import java.util.Arrays;
import java.util.Scanner;

public class MakingAnagrams {

	static int handle() {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0, j = 0;
		int la = a.length, lb = b.length;
		// find C set such that C is subset of A and C is subset of B
		int lc = 0;
		for (; i < la && j < lb;) {
			if (a[i] < b[j]) {
				++i;
			} else if (a[i] > b[j]) {
				++j;
			} else {
				++i;
				++j;
				++lc;
			}
		}
		return la + lb - 2 * lc;
	}

	public static void main(String[] a) {
		System.out.print(handle());
	}

}
