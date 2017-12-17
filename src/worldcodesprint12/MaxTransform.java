package worldcodesprint12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxTransform {
	
    static int solve(int[] a) {
    	return getSum(transform(transform(a)));
    }
    
    static int[] transform(int[] a) {
    	int n = a.length;
    	List<Integer> b = new ArrayList<>();
    	for (int k = 0; k < n; ++k) {
    		int maxi = n - k;
    		for (int i = 0; i < maxi; ++i) {
    			int j = i + k;
    			b.add(a[findMax(a, i, j)]);
    		}
    	}
    	int[] array = b.stream().mapToInt(i->i).toArray();
    	return array;
    }
    
    static int getSum(int[] a) {
    	int MAX = 1000000007;
    	int sum = 0;
    	int n = a.length;
    	for (int i = 0; i < n; ++i) {
    		sum += a[i];
    		if (sum >= MAX) {
        		sum %= MAX;
    		}
    	}
    	return sum;
    }
    
    static int findMax(int[] a, int i, int j) {
    	int max = i;
    	for (int k = i + 1; k <= j; ++k) {
    		if (a[k] > a[max]) {
    			max = k;
    		}
    	}
    	return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = solve(a);
        System.out.println(result);
        in.close();
    }

}
