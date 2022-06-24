package problem.baekjoon.backTracking;

import java.util.Scanner;

public class Main9663 {
	public static int n;
	public static int c;
	public static int[] board;

	public static void nQueen(int depth) {
		if (depth == n)
			c++;
		else {
			for (int i = 0; i < n; i++) {
				if (checkQueen(i, depth)) {
					board[depth] = i;
					nQueen(depth + 1);
				}
			}
		}
	}

	public static boolean checkQueen(int i, int depth) {
		for (int j = 0; j < depth; j++) {
			if (board[j] == i || Math.abs(board[j] - i) == Math.abs(j - depth))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		c = 0;
		board = new int[n];

		nQueen(0);
		System.out.println(c);
		sc.close();
	}
}