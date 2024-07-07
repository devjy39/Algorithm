package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No20046 {
    static class Road{
        int x, y;
        int cost;

        public Road(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = map[i][m + 1] = -1;
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = map[n + 1][i] = -1;
        }

        System.out.println(getMinRoadCost(map, n, m));
    }

    private static int getMinRoadCost(int[][] map, int n, int m) {
        PriorityQueue<Road> queue = new PriorityQueue<>(Comparator.comparingInt(r -> r.cost));
        int[][] costs = new int[n + 1][m + 1];
        for (int[] cost : costs) {
            Arrays.fill(cost, Integer.MAX_VALUE);
        }

        if (map[1][1] != -1 && map[n][m] != -1) {
            queue.add(new Road(1, 1, map[1][1]));
            costs[1][1] = map[1][1];
        }

        while (!queue.isEmpty()) {
            Road road = queue.poll();

            if (road.cost > costs[road.x][road.y]) {
                continue;
            } else if (road.x == n && road.y == m) {
                break;
            }

            for (int[] dir : dirs) {
                int x = dir[0] + road.x;
                int y = dir[1] + road.y;

                if (map[x][y] == -1 || costs[x][y] <= road.cost + map[x][y]) {
                    continue;
                }

                costs[x][y] = road.cost + map[x][y];
                queue.add(new Road(x, y, costs[x][y]));
            }
        }

        return costs[n][m] == Integer.MAX_VALUE ? -1 : costs[n][m];
    }

}

