package hiringcontest;

import java.util.*;

public class WinningLotteryTicket {

    static final int MAX = 1 << 10;

    static long winningLotteryTicket(String[] tickets) {
        int len = tickets.length;
        System.out.println("len = " + len);
        long[] a = new long[MAX];
        for (int i = 0; i < len; ++i) {
            int x = tickets[i].length();
            int v = 0;
            for (int j = 0; j < x; ++j) {
                v |= (1 << (tickets[i].charAt(j) - '0'));
            }
            ++a[v];
        }
        long s = 0;
        for (int v1 = 0; v1 < MAX; ++v1) {
            for (int v2 = v1; v2 < MAX; ++v2) {
                if ((v1 | v2) == MAX - 1) {
                    if (v1 == v2) {
                        s += (a[v1] * (a[v1] - 1)) / 2;
                    } else {
                        s += (a[v1] * a[v2]);
                    }
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for (int tickets_i = 0; tickets_i < n; tickets_i++) {
            tickets[tickets_i] = in.next();
        }
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }

}