package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No14461 {
    static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= n + 1; i++) {
            map[i][0] = map[0][i] = map[i][n + 1] = map[n + 1][i] = -1;
        }

        System.out.println(getMinTime(map, t));
    }

    static class Zone {
        int x;
        int y;
        int time;
        int count;

        public Zone(int x, int y, int time, int count) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.count = count;
        }
    }

    static final int MAX_DISTANCE = 1_000_000_000;
    private static int getMinTime(int[][] map, int t) {
        int n = map.length - 2;
        PriorityQueue<Zone> queue = new PriorityQueue<>(Comparator.comparingInt(z -> z.time));
        int[][][] times = new int[3][map.length][map[0].length];
        for (int i = 0; i < 3; i++) {
            for (int[] ints : times[i]) {
                Arrays.fill(ints, MAX_DISTANCE);
            }
        }
        queue.add(new Zone(1, 1, 0, 0));
        times[0][1][1] = times[1][1][1] = times[2][1][1] = 0;

        while (!queue.isEmpty()) {
            Zone cur = queue.poll();

            if (cur.time > times[cur.count % 3][cur.x][cur.y]) {
                continue;
            } else if (cur.x == n && cur.y == n) {
                break;
            }

            cur.count++;
            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (map[x][y] < 0) {
                    continue;
                }

                int spendTime = cur.time + (cur.count % 3 == 0 ? map[x][y] : 0) + t;
                if (spendTime < times[cur.count % 3][x][y]) {
                    times[cur.count % 3][x][y] = spendTime;
                    queue.add(new Zone(x, y, spendTime, cur.count));
                }
            }
        }

        return Math.min(times[0][n][n], Math.min(times[1][n][n], times[2][n][n]));
    }

}

