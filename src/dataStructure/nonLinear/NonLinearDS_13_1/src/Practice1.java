package dataStructure.nonLinear.NonLinearDS_13_1.src;

public class Practice1 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static boolean solution(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, new boolean[board.length][board[0].length], word, 1, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
        if (word.length() == idx) {
            return true;
        }
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && !visited[x][y]) {
                if (board[x][y] == word.charAt(idx) && dfs(board, visited, word, idx + 1, x, y)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED"));
        System.out.println(solution(board, "SEE"));
        System.out.println(solution(board, "ABCB"));
    }
}
