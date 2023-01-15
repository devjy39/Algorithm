package problem.baekjoon.dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class No27211 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        int result = 0;
        visited = new boolean[n][m];
        for (Point point : list) {
            if (!visited[point.x][point.y] && map[point.x][point.y] == 0) {
                dfs(point.x, point.y);
                result++;
            }
        }

        System.out.print(result);
    }

    private static void dfs(int i, int j) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(i, j));
        visited[i][j] = true;

        while (!stack.isEmpty()) {
            Point cur = stack.pop();
            for (int[] dir : dirs) {
                int x = (cur.x + dir[0] + n) % n;
                int y = (cur.y + dir[1] + m) % m;

                if (!visited[x][y] && map[x][y] == 0) {
                    stack.push(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }

    }

}