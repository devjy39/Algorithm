package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2468 {
    static final int MAX_HEIGHT = 100;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getSafeAreaCount(map, N));
    }

    private static int getSafeAreaCount(int[][] map, int n) {
        int maxCount = 1;

        int[][] visited = new int[n][n];
        for (int water = 1; water <= MAX_HEIGHT; water++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] != water && map[i][j] > water) {
                        findSafeArea(map, visited, water, i, j);
                        count++;
                    }
                }
            }
            if (count == 0) {
                break;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private static void findSafeArea(int[][] map, int[][] visited, int water, int i, int j) {
        visited[i][j] = water;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= map.length || y >= map[x].length || map[x][y] <= water || visited[x][y] == water) {
                continue;
            }

            findSafeArea(map, visited, water, x, y);
        }
    }
}

