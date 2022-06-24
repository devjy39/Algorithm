package algorithm.backtracking;
// Practice4
// 2차원 배열 board 가 주어졌다.
// 해당 배열 데이터에는 'o', '#', '.' 의 정보가 기입되어 있다.
// 'o': 동전을 의미
// '#': 벽을 의미
// '.': 빈칸을 의미

// 동전은 항상 두개가 주어진다.
// 두 동전이 함께 이동하다가 하나가 보드에서 떨어지는 경우의 최소 이동 횟수를 출력하는 프로그램을 작성하세요.
// 단, 이동 규칙은 다음과 같다.
    // 동전은 좌, 우, 위, 아래로 이동 가능하며 같은 방향으로 함께 이동
    // 빈칸이나 동전이 있는 칸으로는 이동 가능
    // 벽일 때는 아닌 넘만 움직임
    // 이동 횟수가 10번을 넘으면 중지하고 -1 반환

// 입출력 예시
// board: {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}}
// 결과: 4


import java.util.*;

public class Practice4 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Set<String> visited;
    static int min;

    public static void solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        min = Integer.MAX_VALUE;
        visited = new HashSet<>();
        List<int[]> coin = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'o') {
                    coin.add(new int[]{i, j});
                    if (coin.size() == 2) {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(coin.get(0)[0]).append(coin.get(0)[1]).append(coin.get(1)[0]).append(coin.get(1)[1]);
        visited.add(sb.toString());

        backTracking(board, 0, coin.get(0), coin.get(1));
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void backTracking(char[][] board, int cnt, int[] c1, int[] c2) {
        if (cnt > 10 || cnt >= min) {
            return;
        }

        dirLoop:
        for (int[] dir : dirs) {
            int[][] arr = {{c1[0] + dir[0], c1[1] + dir[1]}, {c2[0] + dir[0], c2[1] + dir[1]}};

            int success = 0;

            if (isSuccess(board, arr[0][0], arr[0][1])) {
                success++;
            } else {
                if (board[arr[0][0]][arr[0][1]] == '#') {
                    arr[0][0] = c1[0];
                    arr[0][1] = c1[1];
                }
            }
            if (isSuccess(board, arr[1][0], arr[1][1])) {
                success++;
            } else {
                if (board[arr[1][0]][arr[1][1]] == '#') {
                    arr[1][0] = c2[0];
                    arr[1][1] = c2[1];
                }
            }

            if (success == 1) {
                min = Math.min(min, cnt + 1);
            } else if (success == 0){
                StringBuilder sb = new StringBuilder();
                sb.append(arr[0][0]).append(arr[0][1]).append(arr[1][0]).append(arr[1][1]);
                if (!visited.contains(sb.toString())) {
                    visited.add(sb.toString());
                    backTracking(board, cnt + 1, arr[0], arr[1]);
                }
            }
        }
    }

    private static boolean isSuccess(char[][] board, int x,int y) {
        return x < 0 || y < 0 || x == board.length || y == board[x].length;
    }

    public static void main(String[] args) {
        // Test code
        char[][] board = {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '.', '#'},
                {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);
    }
}
