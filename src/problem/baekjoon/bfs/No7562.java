package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No7562 {

    static int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            String[] point = br.readLine().split(" ");
            Point cur = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
            point = br.readLine().split(" ");
            Point target = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));

            result.append(bfs(cur, target, l)).append("\n");
        }

        System.out.print(result);
    }

    private static int bfs(Point cur, Point target, int l) {
        boolean[][] visited = new boolean[l][l];
        int count = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur.x][cur.y] = true;

        while (!queue.isEmpty()) {
            Queue<Point> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                if (poll.equals(target)) {
                    return count;
                }

                for (int[] dir : dirs) {
                    int x = poll.x + dir[0];
                    int y = poll.y + dir[1];

                    if (x < 0 || y < 0 || x >= l || y >= l || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    next.add(new Point(x, y));
                }
            }

            count++;
            queue = next;
        }

        return count;
    }

}