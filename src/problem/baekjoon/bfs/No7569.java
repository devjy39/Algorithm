package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7569 {
    static class Tomato {
        int x;
        int y;
        int h;

        public Tomato(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    static int[][][] map;
    static int[][] dirs = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        Queue<Tomato> queue = new LinkedList<>();
        int unripeTomato = 0;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        visited[k][i][j] = true;
                        queue.add(new Tomato(i, j, k));
                    } else if (map[k][i][j] == 0) {
                        unripeTomato++;
                    }
                }
            }
        }
        br.close();

        System.out.println(bfs(m, n, h, queue, unripeTomato, n * m * h));
    }

    private static int bfs(int m, int n, int h, Queue<Tomato> queue, int tomato, int range) {
        for (int i = 0; i < range; i++) {
            Queue<Tomato> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Tomato cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;
                    int z = dir[2] + cur.h;

                    if (x < 0 || y < 0 || z < 0 ||
                            x >= n || y >= m || z >= h ||
                            visited[z][x][y] || map[z][x][y] != 0) {
                        continue;
                    }

                    visited[z][x][y] = true;
                    next.add(new Tomato(x, y, z));
                }
            }
            queue = next;
            tomato -= queue.size();

            if (queue.isEmpty()) {
                if (tomato > 0) {
                    break;
                }
                return i;
            }
        }

        return -1;
    }

}