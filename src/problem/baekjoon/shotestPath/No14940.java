package problem.baekjoon.shotestPath;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14940 {
    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][m + 2];
        Point start = new Point();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 2) {
                    start.setLocation(i, j);
                } else if (number == 1) {
                    map[i][j] = -1;
                }
            }
        }

        bfs(map, start);

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                result.append(map[i][j]).append(' ');
            }
            result.append('\n');
        }
        System.out.print(result);
    }

    private static void bfs(int[][] map, Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        map[start.x][start.y] = 0;

        int distance = 0;

        while (!queue.isEmpty()) {
            Queue<Point> next = new LinkedList<>();
            distance++;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (map[x][y] == -1) {
                        map[x][y] = distance;
                        next.add(new Point(x, y));
                    }
                }
            }

            queue = next;
        }
    }

}

