package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2583 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            draw(map, x1, y1, x2, y2);
        }

        printAreaCount(getAreaList(n, m, map));
    }

    private static void printAreaCount(List<Integer> areas) {
        StringBuilder result = new StringBuilder();

        result.append(areas.size()).append("\n");
        for (Integer area : areas) {
            result.append(area).append(" ");
        }

        System.out.println(result);
    }

    private static List<Integer> getAreaList(int n, int m, boolean[][] map) {
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) {
                    areas.add(visitedCheck(map, i, j));
                }
            }
        }

        Collections.sort(areas);
        return areas;
    }

    private static int visitedCheck(boolean[][] map, int i, int j) {
        map[i][j] = true;
        int area = 1;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y]) {
                continue;
            }

            area += visitedCheck(map, x, y);
        }

        return area;
    }

    private static void draw(boolean[][] map, int x1, int y1, int x2, int y2) {
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                map[x][y] = true;
            }
        }
    }


}
