package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2580 {
	public static int[][] board;
	public static ArrayList<int[]> pair;
	public static boolean clear;
	
	public static void printBoard() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void sudoku(int depth) {
		if (depth==pair.size()) {
			clear = true;
			return;
		}
		int[] valid = new int[10];
		search(pair.get(depth)[0],pair.get(depth)[1], valid);
		for(int i=1;i<10;i++) {
			if (valid[i]==0) {
				board[pair.get(depth)[0]][pair.get(depth)[1]]=i;
				sudoku(depth+1);
				if(clear) break;
				board[pair.get(depth)[0]][pair.get(depth)[1]]=0;
			}
		}
	}
	
	public static void search(int x, int y,int[] valid) {
		int sx = x/3*3;
		int sy = y/3*3;
		for(int i=0;i<9;i++) {
			valid[board[x][i]]=1;
			valid[board[i][y]]=1;
			valid[board[sx+i/3][sy+i%3]]=1;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		pair = new ArrayList<>();
		
		for (int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0;j<9;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j]==0)
					pair.add(new int[]{i,j});
			}
		}
		
		sudoku(0);
		printBoard();
		br.close();
	}
}