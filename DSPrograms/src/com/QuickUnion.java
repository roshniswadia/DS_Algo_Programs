package com;

public class QuickUnion {

	static int[] id;

	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public static void main(String[] args) {
		QuickUnion qunion = new QuickUnion(10);
		connect(3, 4);
		connect(2, 9);
		connect(4, 9);
		connect(5, 6);

		System.out.println("Is 1 and 2 connected" + isConnected(1, 2));
		System.out.println("Is 3 and 9 connected" + isConnected(3, 9));
	}

	public static void connect(int p, int q) {
		int rootp = checkRoot(p);
		int rootq = checkRoot(q);
		id[rootq] = rootp;
	}

	public static int checkRoot(int n) {
		while (n != id[n])
			n = id[n];

		return n;
	}

	public static boolean isConnected(int p, int q) {
		int rootp = checkRoot(p);
		int rootq = checkRoot(q);
		if (rootp == rootq)
			return true;
		else
			return false;
	}

}
