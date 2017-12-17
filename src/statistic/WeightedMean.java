package statistic;

import java.io.*;
import java.util.*;

public class WeightedMean {
    
    static float handle() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; ++i) {
        	x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
        	w[i] = sc.nextInt();
        }
        float f = 0f;
        float g = 0f;
        for (int i = 0; i < n; ++i) {
            f += x[i] * w[i];
            g += w[i];
        }
        f /= g;
        return Float.valueOf(String.format("%.1f", f));
    }

    public static void main(String[] args) {
        System.out.print(handle());
    }
}
