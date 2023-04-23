package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2636 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int cheeses = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeses++;
                }
            }
        }

        bfs(map, n, m, cheeses);
    }

    private static void bfs(int[][] map, int n, int m, int cheeses) {
        int start = 0;
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        int cheeseCount = 0;

        while (cheeses > 0) {
            cheeseCount = cheeses;
            queue.add(new Point(start, start));
            count++;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < start || y < start || x >= n || y >= m || map[x][y] == -count) {
                        continue;
                    }

                    if (map[x][y] == 1) {
                        cheeses--;
                    } else {
                        queue.add(new Point(x, y));
                    }
                    map[x][y] = -count;
                }
            }

            start++;
            n--;
            m--;
        }

        System.out.println(count + "\n" + cheeseCount);
    }

}

