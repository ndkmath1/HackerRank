package codinginterview;

import java.util.Scanner;

public class DPCoinChange {
	
	static void handle() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] result = new int[n + 1]; // store result
		int m = in.nextInt();
		int[] coins = new int[m];
		for (int i = 0; i < n; ++i) {
			coins[i] = in.nextInt();
		}
		in.close();
	}
	
	static void attempt(int i) {
		
	}
	
	public static void main(String[] args) {
		
	}

}
