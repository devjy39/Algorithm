package problem.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        System.out.println(getMaxSize(n, m, map));
    }

    private static int getMaxSize(int n, int m, boolean[][] map) {
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j]) {
                    maxSize = Math.max(maxSize, getSize(map, i, j));
                }
            }
        }
        return maxSize;
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int getSize(boolean[][] map, int i, int j) {
        int size = 1;
        map[i][j] = false;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= map.length || y >= map[x].length || !map[x][y]) {
                continue;
            }
            size += getSize(map, x, y);
        }

        return size;
    }

}

