package hiringcontest;

import java.util.*;

public class TheSimplestSum {
    
    static final int MAX = 1000000007;

    static int simplestSum(int k, long a, long b) {
        long s = 0, x = 0;
        for (long i = a; i <= b; i += x) {
            long h = h(k, i);
            long f = f(k, i, h);
            x = getStep(h, i, k);
            if (i + x > b) {
            	s += f * (b - i + 1);
            } else {
            	s += f * x;
            }
            s %= MAX;
        }
        return (int) s;
    }
    
    static long getStep(long h, long i, long k) {
    	long step = 0;
    	double d = (Math.pow(k, h + 1) - 1) / (k - 1) - i;
    	if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
    		step = (long) d;
    	} else {
    		step = (long) (d + 1);
    	}
    	return step;
    }
    
    static long h(int k, long a) {
        return (long) (Math.log(1 + a * (k - 1)) / Math.log(k));
    }
    
    static long f(int k, long n, long m) {
        int v = k - 1;
        return (long) (((double) k * (Math.pow(k, m) - 1)) / (v * v) - ((double) m) / v);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            long a = in.nextLong();
            long b = in.nextLong();
            int result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
    }
}

