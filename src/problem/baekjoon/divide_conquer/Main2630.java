package problem.baekjoon.divide_conquer;

import java.util.Scanner;

public class Main2630 {
    static int blue;
    static int white;
    static int[][] board;

    static void di_con(int x, int y, int l) {
        if(count(x,y,l))
            return;
        l/=2;
        for (int i=0;i<4;i++)
            di_con(x+((i%2)*l),y+((i/2)*l), l);
    }

    static boolean count(int x, int y, int l) {
        int value = board[x][y];
        for (int i = x; i < x+l; i++) {
            for (int j = y; j < y+l; j++) {
                if(board[i][j]!=value)
                    return false;
            }
        }
        if(value==1)
            blue++;
        else
            white++;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        di_con(0, 0, n);
        System.out.println(white+"\n"+blue);

        sc.close();
    }
}