package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2589 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) == 'L';
            }
        }

        System.out.println(getMaxDistance(map, n, m));
    }

    private static int getMaxDistance(boolean[][] map, int n, int m) {
        int maxDistance = 0;
        int[][] visited = new int[n][m];
        int idx = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    maxDistance = Math.max(maxDistance, bfs(map, i, j, visited, idx++));
                }
            }
        }

        return maxDistance;
    }

    private static int bfs(boolean[][] map, int i, int j, int[][] visited, int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        int distance = -1;
        visited[i][j] = idx;

        while (!queue.isEmpty()) {
            distance++;
            Queue<Point> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || !map[x][y] || visited[x][y] == idx) {
                        continue;
                    }

                    visited[x][y] = idx;
                    next.add(new Point(x, y));
                }
            }

            queue = next;
        }

        return distance;
    }

}

