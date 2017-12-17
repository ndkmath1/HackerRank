package algorithms;

import java.util.Scanner;

public class XORSequence {
	
	Scanner sc = new Scanner(System.in);
	int n;
	int[] rec = new int[100000];
	boolean[] m = new boolean[100000];
	
	void init() {
		n = sc.nextInt();
		rec[0] = 0;
		m[0] = true;
	}
	
	int recursive(int i) {
		if (!m[i]) {
			rec[i] = recursive(i - 1) ^ i;
			m[i] = true;
			return rec[i];
		} else {
			return rec[i];
		}
	}
	
	void handle() {
		for (int i = 0; i < n; ++i) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int res = recursive(l);
			for (int j = l + 1; j <= r; ++j) {
				res ^= recursive(j);
			}
			System.out.println(res);
		}
	}
	
	void test() {
		init();
		handle();
	}
	
	public static void main(String[] args) {
		new XORSequence().test();
	}

}
