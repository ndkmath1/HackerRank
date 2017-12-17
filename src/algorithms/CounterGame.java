package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {
	
	String value;
	int nTest;
	String[] a;
	Scanner sc = new Scanner(System.in);
	
	void init() {
		nTest = sc.nextInt();
		a = new String[nTest];
		for (int i = 0; i < nTest; ++i) {
			a[i] = sc.next();
		}
	}
	
	void handle() {
		BigInteger bi1 = new BigInteger(1 + "");
		for (int i = 0; i < nTest; ++i) {
			String res = "";
			BigInteger bi = new BigInteger(a[i]);
			if (bi.compareTo(bi1) == 0) {
				res = "Louise";
			} else {
				while (true) {
					bi = getNextStep(bi);
					if (bi.compareTo(bi1) == 0) {
						res =  "Louise";
						break;
					}
					bi = getNextStep(bi);
					if (bi.compareTo(bi1) == 0) {
						res =  "Richard";
						break;
					}
				}
			}
			System.out.println(res);
		}
	}
	
	BigInteger getNextStep(BigInteger bi) {
		String biBase2 = bi.toString(2);
		int len = biBase2.length();
		boolean found = false;
		BigInteger bi2 = new BigInteger(2 + "");
		for (int i = 1; i < len; ++i) {
			if (biBase2.charAt(i) != '0') {
				found = true;
				break;
			}
		}
		if (!found) {
			return bi.divide(bi2);
		} else {
//			return bi2.pow(len - 1).divide(bi2);
			return new BigInteger((len - 1) + "");
		}
	}
	
	void test() {
		init();
		handle();
	}
	
	public static void main(String[] args) {
		new CounterGame().test();
	}

}
