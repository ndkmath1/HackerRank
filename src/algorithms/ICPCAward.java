package algorithms;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ICPCAward {
	
	int n;
	String[] uniTeam;
	Scanner sc = new Scanner(System.in);
	int nAward = 12;
	String[] res = new String[nAward];
	int[] resIndex = new int[nAward];
	String[] uni, team;
	
	void init() {
		n = sc.nextInt();
		uniTeam = new String[n];
		uni = new String[n];
		team = new String[n];
		for (int i = 0; i < n; ++i) {
			uni[i] = sc.next();
			team[i] = sc.next();
		}
	}
	
	void handle() {
		resIndex[0] = 0;
		int i = 0;
		while (i < nAward) {
			for (int j = i + 1; j < n; ++j) {
				boolean exist = false;
				for (int k = 0; k <= i; ++k) {
					if (uni[resIndex[k]].equals(uni[j])) {
						exist = true;
						break;
					}
				}
				if (!exist) {
					resIndex[++i] = j;
					if (i == nAward - 1) {
						i = nAward;
						break;
					}
				}
			}
		}
		
		for (int j = 0; j < nAward; ++j) {
			System.out.println(uni[resIndex[j]] +" "+ team[resIndex[j]]);
		}
		
	}
	
	
	void test() {
		init();
		handle();
	}
	
	public static void main(String[] args) {
		new ICPCAward().test();
	}
	
}
