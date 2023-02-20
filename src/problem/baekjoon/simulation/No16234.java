package problem.baekjoon.simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16234 {
    static int N, L, R;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMoveCount(map));
    }

    private static int getMoveCount(int[][] map) {
        int[][] visited = new int[N][N];

        int count;
        for (count = 1; count <= 2000; count++) {
            boolean isMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != count && bfs(map, visited, count, i, j)) {
                        isMoved = true;
                    }
                }
            }

            if (!isMoved) {
                break;
            }
        }

        return count - 1;
    }

    private static boolean bfs(int[][] map, int[][] visited, int count, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = count;
        Queue<Point> coalition = new LinkedList<>();
        coalition.add(queue.peek());
        int population = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            population += map[cur.x][cur.y];

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y] == count) {
                    continue;
                }
                int diff = Math.abs(map[cur.x][cur.y] - map[x][y]);
                if (diff >= L && diff <= R) {
                    Point point = new Point(x, y);
                    coalition.add(point);
                    queue.add(point);
                    visited[x][y] = count;
                }
            }
        }

        if (coalition.size() == 1) {
            return false;
        }

        population /= coalition.size();
        for (Point point : coalition) {
            map[point.x][point.y] = population;
        }
        return true;
    }

}