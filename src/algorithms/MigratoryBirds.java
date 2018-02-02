package algorithms;

import java.util.Scanner;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] a) {
        int[] b = new int[5];
        for (int i = 0; i < n; ++i) {
            ++b[a[i] - 1];
        }
        int max = 4;
        for (int i = 3; i >= 0; --i) {
            if (b[i] >= b[max]) {
                max = i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
