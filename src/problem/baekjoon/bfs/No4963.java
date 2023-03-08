package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4963 {

    static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        StringBuilder result = new StringBuilder();

        while (!(read = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(read);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = st.nextToken().equals("1");
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j]) {
                        count++;
                        bfs(map, i, j, h, w);
                    }
                }
            }

            result.append(count).append("\n");
        }

        System.out.print(result);
    }

    private static void bfs(boolean[][] map, int i, int j, int h, int w) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        map[i][j] = false;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= h || y >= w || !map[x][y]) {
                    continue;
                }
                map[x][y] = false;
                queue.add(new Point(x, y));
            }
        }
    }


}

