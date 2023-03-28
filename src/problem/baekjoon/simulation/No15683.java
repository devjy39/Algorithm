package problem.baekjoon.simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class No15683 {
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int blindSpots = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> cctvList;
    static int emptySpace, m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cctvList = new ArrayList<>();
        List<Point> allTypeCctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 5) {
                    cctvList.add(new Point(i, j));
                } else if (map[i][j] == 5) {
                    allTypeCctv.add(new Point(i, j));
                } else if (map[i][j] == 0) {
                    emptySpace++;
                }
            }
        }

        checkAllTypeCctv(allTypeCctv);

        dfs(0, 0);

        System.out.println(blindSpots);
    }

    private static void checkAllTypeCctv(List<Point> allTypeCctv) {
        for (Point cctv : allTypeCctv) {
            for (int i = 0; i < 4; i++) {
                emptySpace -= check(cctv.x, cctv.y, i);
            }
        }
    }

    private static void dfs(int idx, int removedCount) {
        if (idx >= cctvList.size()) {
            blindSpots = Math.min(blindSpots, emptySpace - removedCount);
            return;
        }

        Point cctv = cctvList.get(idx);
        int cctvNumber = map[cctv.x][cctv.y];

        if (cctvNumber == 1) {
            for (int i = 0; i < 4; i++) {
                int count = check(cctv.x, cctv.y, i);
                dfs(idx + 1, removedCount + count);
                remove(cctv.x, cctv.y, i);
            }
        } else if (cctvNumber == 2) {
            for (int i = 0; i < 2; i++) {
                int count = check(cctv.x, cctv.y, i) + check(cctv.x, cctv.y, i + 2);
                dfs(idx + 1, removedCount + count);
                remove(cctv.x, cctv.y, i);
                remove(cctv.x, cctv.y, i + 2);
            }
        } else if (cctvNumber == 3) {
            for (int i = 0; i < 4; i++) {
                int count = check(cctv.x, cctv.y, i) + check(cctv.x, cctv.y, (i + 1) % 4);
                dfs(idx + 1, removedCount + count);
                remove(cctv.x, cctv.y, i);
                remove(cctv.x, cctv.y, (i + 1) % 4);
            }
        } else { // 4
            for (int i = 0; i < 4; i++) {
                int count = check(cctv.x, cctv.y, i) +
                        check(cctv.x, cctv.y, (i + 1) % 4) +
                        check(cctv.x, cctv.y, (i + 2) % 4);
                dfs(idx + 1, removedCount + count);
                remove(cctv.x, cctv.y, i);
                remove(cctv.x, cctv.y, (i + 1) % 4);
                remove(cctv.x, cctv.y, (i + 2) % 4);
            }
        }
    }

    private static void remove(int x, int y, int i) {
        while (true) {
            x += dirs[i][0];
            y += dirs[i][1];

            if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 6) {
                break;
            }

            if (map[x][y] <= 0) {
                map[x][y]++;
            }
        }
    }

    private static int check(int x, int y, int i) {
        int count = 0;

        while (true) {
            x += dirs[i][0];
            y += dirs[i][1];

            if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 6) {
                break;
            }

            if (map[x][y] <= 0) {
                if (map[x][y] == 0) {
                    count++;
                }
                map[x][y]--;
            }
        }

        return count;
    }

}
