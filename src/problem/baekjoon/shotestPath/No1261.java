package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] wall = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    wall[i][j] = true;
                }
            }
        }

        System.out.println(findMinWallDestroyCount(wall, n, m));
    }

    static class Point {
        int x;
        int y;
        int destruction;

        public Point(int x, int y, int destruction) {
            this.x = x;
            this.y = y;
            this.destruction = destruction;
        }
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    private static int findMinWallDestroyCount(boolean[][] wall, int n, int m) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.destruction));
        pq.add(new Point(0,0,0));
        int[][] wallCount = new int[n][m];
        for (int[] v : wallCount) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        wallCount[0][0] = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }
                int destructCount = cur.destruction + (wall[x][y] ? 1 : 0);
                if (destructCount >= wallCount[x][y]) {
                    continue;
                }

                wallCount[x][y] = destructCount;
                pq.add(new Point(x, y, destructCount));
            }

        }

        return wallCount[n - 1][m - 1];
    }

}
