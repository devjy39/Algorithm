package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10026 {
    static char[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        boolean[][] weakVisited = new boolean[n][n];
        boolean[][] generalVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        br.close();
        int colorWeakness = 0;
        int normal = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                colorWeakness += weakDfs(i, j, weakVisited) ? 1 : 0;
                normal += generalDfs(i, j, generalVisited) ? 1 : 0;
            }
        }

        System.out.printf("%d %d", normal, colorWeakness);
    }

    private static boolean generalDfs(int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
                continue;
            }
            if (map[i][j] != map[x][y]) {
                continue;
            }
            generalDfs(x, y, visited);
        }

        return true;
    }

    private static boolean weakDfs(int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
                continue;
            }
            if (map[i][j] != map[x][y]) {
                if (map[i][j] == 'B' || map[x][y] == 'B') {
                    continue;
                }
            }
            weakDfs(x, y, visited);
        }

        return true;
    }

}