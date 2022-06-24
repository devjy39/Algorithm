package algorithm.backtracking;
/*  알고리즘 - 백트래킹
*   모든 경우의 수를 탐색하다가 유망하지 않은 쪽은 더 이상 구하지 않는 방법
*   돌다리도 두드려보고 가는 느낌!
*   가지치기(pruning) 을 자주 쓰기 때문에 DFS 와 자주 사용
* */


import java.util.Arrays;

public class Main {
    static int n = 4;
    static int[] board = new int[n];

    public static int nQueen(int row) {
        if (row == n) {
            System.out.println(Arrays.toString(board));
            return 1;
        }
        int sum = 0;

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < row; j++) {
                if (board[j] == i || row - j == Math.abs(board[j] - i)) {
                    continue loop;
                }
            }
            board[row] = i;
            sum += nQueen(row + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}
