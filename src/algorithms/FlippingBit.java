package algorithms;

import java.util.Scanner;

public class FlippingBit {
	
	Scanner sc = new Scanner(System.in);
	int n;
	String[] a;
	
	void init() {
		n = sc.nextInt();
		a = new String[n];
		for (int i = 0; i < n; ++i) {
			a[i] = sc.next();
		}
	}
	
	void handle() {
		for (int i = 0; i < n; ++i) {
			System.out.println(Long.parseUnsignedLong(String.valueOf(~Long.parseLong(a[i])), 2));
		}
	}
	
	void test() {
		init();
		handle();
	}
	
	public static void main(String[] args) {
		new FlippingBit().test();
	}

}
