package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18430 {
    static int n, m;
    static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMaxSum(map, new boolean[n][m], 0, 0));
    }

    private static int getMaxSum(int[][] map, boolean[][] visited, int x, int y) {
        if (x >= n) {
            return 0;
        }
        int nextX = x + (y + 1 >= m ? 1 : 0), nextY = (y + 1) % m;
        if (y >= m || visited[x][y]) {
            return getMaxSum(map, visited, nextX, nextY);
        }

        int maxSum = 0;
        for (int i = 0; i < dirs.length; i++) {
            int row1 = dirs[i][0] + x;
            int col1 = dirs[i][1] + y;
            if (isOutOfRange(visited, row1, col1)) {
                continue;
            }
            int row2 = dirs[(i + 1) % dirs.length][0] + x;
            int col2 = dirs[(i + 1) % dirs.length][1] + y;
            if (isOutOfRange(visited, row2, col2)) {
                i++;
                continue;
            }

            int sum = map[x][y] * 2 + map[row1][col1] + map[row2][col2];
            visited[x][y] = visited[row1][col1] = visited[row2][col2] = true;
            maxSum = Math.max(maxSum, sum + getMaxSum(map, visited, nextX, nextY));
            visited[x][y] = visited[row1][col1] = visited[row2][col2] = false;
        }

        return Math.max(maxSum, getMaxSum(map, visited, nextX, nextY));
    }

    private static boolean isOutOfRange(boolean[][] visited, int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m || visited[x][y];
    }

}

