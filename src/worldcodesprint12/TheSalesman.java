package worldcodesprint12;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheSalesman {

    static int minimumTime(int[] x) {
        //  Return the minimum time needed to visit all the houses.
        Arrays.sort(x);
        int l = x.length;
        int s = 0;
        int n = l - 1;
        for (int i = 0; i < n; ++i) {
            s += x[i + 1] - x[i];
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int x_i = 0; x_i < n; x_i++){
                x[x_i] = in.nextInt();
            }
            int result = minimumTime(x);
            System.out.println(result);
        }
        in.close();
    }
}
