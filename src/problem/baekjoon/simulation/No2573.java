package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2573 {
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getSeparationTime(map));
    }

    private static int getSeparationTime(int[][] map) {
        int time = 0;
        int[][] meltCount = new int[n][m];
        int icebergs = 1;

        while (icebergs == 1) {
            time++;
            countMelting(map, meltCount);
            melting(map, meltCount);

            icebergs = countIcebergs(map);
        }

        return icebergs > 1 ? time : 0;
    }

    private static int countIcebergs(int[][] map) {
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    if (!visited[i][j]) {
                        if (count > 0) {
                            return count + 1;
                        }
                        dfs(map, visited, i, j);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static void melting(int[][] map, int[][] meltCount) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    map[i][j] = Math.max(0, map[i][j] - meltCount[i][j]);
                }
            }
        }
    }

    private static void countMelting(int[][] map, int[][] meltCount) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] != 0) {
                            continue;
                        }

                        count++;
                    }

                    meltCount[i][j] = count;
                }
            }
        }
    }

    private static void dfs(int[][] map, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || visited[x][y] || map[x][y] == 0) {
                continue;
            }
            dfs(map, visited, x, y);
        }
    }

}

