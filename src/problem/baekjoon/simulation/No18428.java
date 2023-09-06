package problem.baekjoon.simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No18428 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> teachers = new ArrayList<>();

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j += 2) {
                char c = str.charAt(j);
                map[i][j >> 1] = c;
                if (c == 'T') {
                    teachers.add(new Point(i, j >> 1));
                }
            }
        }

        System.out.println(dfs(map, teachers, 0, 0, 0) ? "YES" : "NO");
    }

    static final int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static final char BLOCK = 'O', STUDENT = 'S', EMPTY = 'X';

    private static boolean dfs(char[][] map, List<Point> teachers, int depth, int idx, int dir) {
        if (depth >= 3 || idx >= teachers.size()) {
            return isPossible(map, teachers);
        }

        Point teacher = teachers.get(idx);

        while (dir < dirs.length) {
            int count = needWall(map, teacher, dir);
            int x = teacher.x;
            int y = teacher.y;

            for (int j = 0; j < count; j++) {
                x += dirs[dir][0];
                y += dirs[dir][1];

                map[x][y] = BLOCK;
                if (dfs(map, teachers, depth + 1, idx + (dir == 3 ? 1 : 0), (dir + 1) % dirs.length)) {
                    return true;
                }
                map[x][y] = EMPTY;
            }
            dir++;
        }

        return dfs(map, teachers, depth, idx + 1, 0);
    }

    private static boolean isPossible(char[][] map, List<Point> teachers) {
        for (Point teacher : teachers) {
            for (int[] dir : dirs) {
                int x = dir[0] + teacher.x;
                int y = dir[1] + teacher.y;

                while (!(x < 0 || y < 0 || x >= map.length || y >= map.length || map[x][y] == BLOCK)) {
                    if (map[x][y] == STUDENT) {
                        return false;
                    }
                    x += dir[0];
                    y += dir[1];
                }

            }
        }

        return true;
    }

    private static int needWall(char[][] map, Point teacher, int dir) {
        int x = teacher.x + dirs[dir][0];
        int y = teacher.y + dirs[dir][1];

        int count = 0;

        while (!(x < 0 || y < 0 || x >= map.length || y >= map.length)) {
            if (map[x][y] != EMPTY) {
                if (map[x][y] == STUDENT) {
                    return count;
                }
                return 0;
            }
            count++;
            x += dirs[dir][0];
            y += dirs[dir][1];
        }

        return 0;
    }

}

