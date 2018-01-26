package hiringcontest;

import java.util.Scanner;

public class ProgrammingCompetition {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String wName = "";
        int score = -1;
        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            int d = in.nextInt();
            int j = in.nextInt();
            int v = j - d;
            if (v > score) {
                wName = name;
                score = v;
            }
        }
        System.out.print(wName + " " + score);
        in.close();
    }
    
}