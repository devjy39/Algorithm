package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class No14502 {
    static List<Point> virus;
    static int[][] map;
    static int area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    area++;
                } else if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        br.close();

        combination(0, 0, 0);

        System.out.println(area - result - 3);
    }

    static int result = Integer.MAX_VALUE;

    private static void combination(int depth, int x, int y) {
        if (depth == 3) {
            if (isBlock(x, y)) {
                result = Math.min(result, bfs());
            }
            return;
        }

        for (int i = x; i < map.length; i++) {
            for (int j = (i == x ? y : 0); j < map[i].length; j++) {
                if (map[i][j] <= 0) {
                    map[i][j] = 1;
                    combination(depth + 1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static boolean isBlock(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= map.length || j >= map[0].length || (i == x && j == y)) {
                    continue;
                }
                if (map[i][j] > 0) {
                    return true;
                }
            }
        }

        return false;
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int check;
    private static int bfs() {
        check--;
        Queue<Point> queue = new LinkedList<>(virus);
        int count = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] > 0 || map[x][y] == check) {
                    continue;
                }
                map[x][y] = check;
                queue.add(new Point(x, y));
                count++;
            }

            if (count >= result) {
                return count;
            }
        }

        return count;
    }

}