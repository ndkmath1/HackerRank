package codinginterview;

import java.util.Scanner;

public class Primality {
	
	static void handle() {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for (int i = 0; i < p; ++i) {
			int n = sc.nextInt();
			if (isPrime(n)) {
				System.out.print("Prime\n");
			} else {
				System.out.print("Not prime\n");
			}
		}
	}
	
	static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		} else if (n == 2) {
			return true;
		} else { // n >= 2
			for (int k1 = 2; k1 * k1 <= n; ++k1) {
				if (n % k1 == 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		handle();
	}
	
}
