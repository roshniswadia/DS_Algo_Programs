package com;

public class QuickFindAlgo {

	private static int id[];

	public QuickFindAlgo(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickFindAlgo qalgo = new QuickFindAlgo(9);
		connect(1, 3);
		connect(3, 7);
		connect(5, 1);
		connect(8, 6);
		connect(8, 4);
		connect(4, 0);

		System.out.println("1 and 4 connected:" + isConnected(1, 4));
		System.out.println("3 and 7 connected:" + isConnected(3, 7));
		System.out.println("4 and 0 connected:" + isConnected(4, 0));

		for (int i = 0; i < id.length; i++) {
			System.out.println(id[i]);
		}

	}

	public static boolean isConnected(int p, int q) {
		if (id[p] == id[q])
			return true;
		else
			return false;
	}

	public static void connect(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
	}

}
