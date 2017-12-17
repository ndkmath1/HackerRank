package worldcodesprint12;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RedKnightShortestPath {
	
	static int[][] moves = {{-2, -1}, {-2, 1}, {0, 2}, {2, 1}, {2, -1}, {0, -2}};
	static String[] movesString = {"UL", "UR", "R", "LR", "LL", "L"};
	static boolean[][] matrix;
	static int movesSize = 6;
	static List<String> moveList = new ArrayList<>();
	static List<String> resultList = new ArrayList<>();
	
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
    	matrix = new boolean[n][n];
    	matrix[i_start][j_start] = true;
    	attempt(n, i_start, j_start, i_end, j_end);
    	if (resultList.isEmpty()) {
    		System.out.println("Impossible");
    	} else {
    		printResult(resultList);
    	}
    }
    
    static void attempt(int n, int iStart, int jStart, int iEnd, int jEnd) {
    	if (!resultList.isEmpty() && resultList.size() <= moveList.size()) {
    		return;
    	}
    	for (int i = 0; i < movesSize; ++i) {
    		int r = iStart + moves[i][0];
    		int c = jStart + moves[i][1];
    		if (r < n && r >= 0 && c < n && c >= 0 && !matrix[r][c]) {
    			moveList.add(movesString[i]);
    			if (r == iEnd && c == jEnd) {
    				if (resultList.isEmpty() || resultList.size() > moveList.size()) {
    					int z = moveList.size();
    					resultList.clear();
    					for (int k = 0; k < z; ++k) {
    						resultList.add(moveList.get(k));
    					}
    				}
    				moveList.remove(moveList.size() - 1);
    			} else {
    				matrix[r][c] = true;
    				attempt(n, r, c, iEnd, jEnd);
    				matrix[r][c] = false;
    				moveList.remove(moveList.size() - 1);
    			}
    		}
    	}
    }
    
    static void printResult(List<String> list) {
    	int len = list.size();
    	for (int i = 0; i < len; ++i) {
    		System.out.print(list.get(i) + " ");
    	}
    	System.out.println();
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
	}

}
