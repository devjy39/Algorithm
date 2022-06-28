package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main17086 {
    static int m,n;
    static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int[][] map = getInput();
        Queue<Point> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int cur = map[point.x][point.y];

            for (int[] dir : dirs) {
                int x = point.x + dir[0];
                int y = point.y + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n || map[x][y] > 0) {
                    continue;
                }
                map[x][y] = cur + 1;
                result = Math.max(result, map[x][y]);
                queue.add(new Point(x, y));
            }
        }

        System.out.println(result - 1);
    }

    public static int[][] getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = mn[0];
        n = mn[1];

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        return map;
    }
}