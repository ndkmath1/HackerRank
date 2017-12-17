package algorithms;

import java.util.Scanner;

public class ProjectEuler197 {
	
	
	final int MAX = 1000000000; // a billion
	double u0, b;
	double[] r = new double[MAX + 2];
	boolean[] m = new boolean[MAX + 2];
	
	void init() {
		Scanner sc = new Scanner(System.in);
		u0 = sc.nextDouble();
		b = sc.nextDouble();
		r[0] = u0;
		m[0] = true;
	}
	
	double calc(int n) {
		if (m[n]) {
			return r[n];
		} else {
			r[n - 1] = calc(n - 1);
			m[n - 1] = true;
			r[n] =  Math.floor(Math.pow(2, b - r[n - 1] * r[n - 1])) * Math.pow(10, -9);
			m[n] = true;
			return r[n];
		}
	}
	
	void test() {
		System.out.print(calc(MAX) + calc(MAX + 1));
	}
	
	public static void main(String[] args) {
		new ProjectEuler197().test();
	}

}
