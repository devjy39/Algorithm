package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        System.out.println(moveCount(map, new Point(x, y), r, c));
    }

    static final int[][] dirs = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

    private static int moveCount(int[][] map, Point start, int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        map[start.x][start.y] = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] > 0) {
                    continue;
                }

                map[x][y] = map[cur.x][cur.y] + 1;
                if (x == r && y == c) {
                    return map[x][y] - 1;
                }
                queue.add(new Point(x, y));
            }
        }

        return -1;
    }

}
