package problem.baekjoon.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No1012 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[m][n];
            List<Point> bugs = new ArrayList<>();
            int result = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = true;
                bugs.add(new Point(x, y));
            }

            int findBugs = 0;

            for (Point bug : bugs) {
                int find = dfs(map, bug, m, n);
                if (find > 0) {
                    result++;
                    findBugs += find;
                    if (findBugs >= bugs.size()) {
                        break;
                    }
                }
            }

            sb.append(result).append("\n");
        }
        br.close();

        System.out.println(sb);
    }

    private static int dfs(boolean[][] map, Point bug, int m, int n) {
        if (!map[bug.x][bug.y]) {
            return 0;
        }
        map[bug.x][bug.y] = false;
        int findBugs = 1;

        for (int[] dir : dirs) {
            int moveX = bug.x + dir[0];
            int moveY = bug.y + dir[1];

            if (moveX < 0 || moveY < 0 || moveX >= m || moveY >= n || !map[moveX][moveY]) {
                continue;
            }
            findBugs += dfs(map, new Point(moveX, moveY), m, n);
        }

        return findBugs;
    }

}