package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class ArrayManipulation {
	
	static void handle() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BigInteger[] arr = new BigInteger[n];
        BigInteger n0 = new BigInteger(0 + "");
        for (int i = 0; i < n; ++i) {
        	arr[i] = n0;
        }
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            BigInteger nk = new BigInteger(k + "");
            for (int i = a - 1; i < b; ++i) {
            	arr[i] = arr[i].add(nk);
            }
        }
        in.close();
        System.out.print(arr[findMax(arr, n)]);
	}
	
	static int findMax(BigInteger[] a, int n) {
		int imax = 0;
		for (int i = 1; i < n; ++i) {
			if (a[imax].compareTo(a[i]) < 0) {
				imax = i;
			}
		}
		return imax;
	}
	
	public static void main(String[] args) {
		handle();
	}

}
