package hiringcontest;

import java.util.*;

public class WinningLotteryTicket {

    static int winningLotteryTicket(String[] tickets) {
        int len = tickets.length;
        int count = 0;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (check(tickets[i], tickets[j])) {
                    ++count;
                }
            }
        }
        return count;
    }
    
    static boolean check(String a, String b) {
        return (a + b).chars().distinct().count() == 10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }
        int result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }
}

