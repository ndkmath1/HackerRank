package algorithms;

import java.util.Scanner;

public class TheFullCountingSort {

	int n;
	Map[] data;
	final int MAX = 100;
	int[] b = new int[MAX];

	void init() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		data = new Map[n];
		int half = n / 2;
		for (int i = 0; i < half; ++i) {
			data[i] = new Map(sc.nextInt(), "-");
			sc.next();
		}
		for (int i = half; i < n; ++i) {
			data[i] = new Map(sc.nextInt(), sc.next());
		}
	}

	void handle() {
		init();
		for (int i = 0; i < n; ++i) {
			++b[data[i].key];
		}
		int[] temp = new int[MAX];
		temp[0] = b[0];
		for (int i = 1; i < MAX; ++i) {
			temp[i] = b[i];
			b[i] += b[i - 1];
		}
		int[] result = new int[n];
		for (int i = 0; i < n; ++i) {
			result[b[data[i].key] - temp[data[i].key]] = i;
			++b[data[i].key];
		}
		printArray(result, data);
	}

	void printArray(int[] index, Map[] data) {
		for (int i = 0; i < n; ++i) {
			System.out.print(data[index[i]].value + " ");
		}
	}

	public static void main(String[] args) {
		new TheFullCountingSort().handle();
	}

	private class Map {
		private int key;
		private String value;

		public Map(int key, String value) {
			this.key = key;
			this.value = value;
		}

	}

}
