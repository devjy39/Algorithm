package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576 {
    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        int tomato = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Tomato(i, j));
                } else if (map[i][j] == 0) {
                    tomato++;
                }
            }
        }
        br.close();

        System.out.println(bfs(m, n, queue, tomato, n * m));
    }

    private static int bfs(int m, int n, Queue<Tomato> queue, int tomato, int range) {
        for (int i = 0; i < range; i++) {
            Queue<Tomato> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Tomato cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || map[x][y] != 0) {
                        continue;
                    }

                    visited[x][y] = true;
                    next.add(new Tomato(x,y));
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