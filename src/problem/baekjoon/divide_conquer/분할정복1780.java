package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 분할정복 문제 9분할, 입력이 많아 bufferedReader 사용
 *  */
public class 분할정복1780 {
    static int[][] board;
    static int cnt[] = new int[3];

    static void di_con(int x, int y, int l) {
        if(count(x,y,l))
            return;
        l/=3;
        for (int i = 0; i < 9; i++)
            di_con(x + l * (i / 3), y + l * (i % 3), l);
    }

    static boolean count(int x, int y, int l) {
        int value = board[x][y];
        for (int i = x; i < x+l; i++) {
            for (int j = y; j < y+l; j++) {
                if(board[i][j] !=value)
                    return false;
            }
        }
        cnt[value+1]++;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        di_con(0,0,n);
        System.out.println(cnt[0]+"\n"+cnt[1]+"\n"+cnt[2]);
        br.close();
    }
}