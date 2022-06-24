package dataStructure.nonLinear.NonLinearDS_13_1.src;

public class Practice2 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void solution(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][board[i].length - 1] == 'O')
                dfs(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[board.length - 1][i] == 'O')
                dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        } else {
            return;
        }

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[x].length) {
                dfs(board, x, y);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solution(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
