package problem.Practice.ProblemSolving_01.src;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Practice3 {
    static int n, m;
    static List<Point> waters;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int minWater;

    public static int solution(int[][] roads) {
        waters = new ArrayList<>();
        n = roads.length;
        m = roads[0].length;
        map = roads;
        minWater = Integer.MAX_VALUE;
        int cleanRoad = -3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (roads[i][j] == 2) {
                    waters.add(new Point(i, j));
                } else if (roads[i][j] == 0) {
                    cleanRoad++;
                }
            }
        }

        dfs(0, 0);

        return cleanRoad - minWater;
    }

    static void dfs(int cnt, int is) {
        if (cnt == 3) {
            minWater = Math.min(minWater, waterSimulation());
            return;
        }

        for (int i = is; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1, i);
                    map[i][j] = 0;
                }
            }
        }
    }


    static int waterSimulation() {
        boolean[][] visited = new boolean[n][m];

        int sum = 0;
        for (Point water : waters) {
            sum += waterDfs(visited, water.x, water.y) - 1;
            if (sum >= minWater) {
                break;
            }
        }

        return sum;
    }

    static int waterDfs(boolean[][] visited, int x, int y) {
        int sum = 1;
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int _x = x + dir[0];
            int _y = y + dir[1];

            if (_x < 0 || _y < 0 || _x >= n || _y >= m) {
                continue;
            }
            if (map[_x][_y] == 0 && !visited[_x][_y]) {
                sum += waterDfs(visited, _x, _y);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test code
        int[][] roads = {{0, 0, 0},
                         {1, 2, 0},
                         {0, 0, 0}};
        System.out.println(solution(roads));

        roads = new int[][]{{2, 0, 0, 0, 1, 1, 0},
                            {0, 0, 1, 0, 1, 0, 0},
                            {0, 1, 1, 0, 1, 0, 0},
                            {0, 1, 0, 1, 1, 0, 0},
                            {0, 0, 0, 0, 0, 1, 1},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 1, 2, 0}};
        System.out.println(solution(roads));
    }
}
