package codinginterview;

import java.util.Scanner;

public class DavisStaircase {

	static int numberTestCase;
	static int[] result;
	final static int N_MAX = 36; 

	static void handle() {
		Scanner sc = new Scanner(System.in);
		numberTestCase = sc.nextInt();
		result = new int[N_MAX + 1];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for (int i = 0; i < numberTestCase; ++i) {
			System.out.println(sum(sc.nextInt()));
		}
	}

	static int sum(int n) {
		if (result[n] == 0) {
			result[n] = sum(n - 1) + sum(n - 2) + sum(n - 3);
		}
		return result[n];
	}

	public static void main(String[] args) {
		handle();
	}

}
