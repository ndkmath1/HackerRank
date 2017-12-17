package algorithms;

import java.util.Scanner;

public class MaximizingXOR {
	
	int min, max;
	int res;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		min = sc.nextInt();
		max = sc.nextInt();
	}
	
	void handle() {
		int maxValue = min ^ min;
		for (int i = min; i <= max; ++i) {
			for (int j = i; j <= max; ++j) {
				int temp = i ^ j;
				if (temp > maxValue) {
					maxValue = temp;
				}
			}
		}
		System.out.println(maxValue);
	}
	
	void test() {
		init();
		handle();
	}
	
	public static void main(String[] args) {
		new MaximizingXOR().test();
	}

}
