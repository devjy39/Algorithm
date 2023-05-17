package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1600 {
    static class Ape {
        int x;
        int y;
        int count;
        int moves;

        public Ape(int x, int y, int count, int moves) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.moves = moves;
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] jumps = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(map, n, m, k));
    }

    private static int bfs(int[][] map, int n, int m, int k) {
        Queue<Ape> queue = new LinkedList<>();
        queue.add(new Ape(0, 0, 0, 0));
        int[][] visited = new int[n][m];
        for (int[] ints : visited) {
            Arrays.fill(ints, k + 1);
        }
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            Ape cur = queue.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.moves;
            }
            move(map, n, m, queue, visited, cur);

            if (cur.count < k) {
                jump(map, n, m, queue, visited, cur);
            }
        }

        return -1;
    }

    private static void move(int[][] map, int n, int m, Queue<Ape> queue, int[][] visited, Ape cur) {
        cur.moves++;

        for (int[] dir : dirs) {
            int x = dir[0] + cur.x;
            int y = dir[1] + cur.y;

            if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 1 || visited[x][y] <= cur.count) {
                continue;
            }
            queue.add(new Ape(x, y, cur.count, cur.moves));
            visited[x][y] = cur.count;
        }
    }

    private static void jump(int[][] map, int n, int m, Queue<Ape> queue, int[][] visited, Ape cur) {
        cur.count++;

        for (int[] jump : jumps) {
            int x = jump[0] + cur.x;
            int y = jump[1] + cur.y;
            if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 1 || visited[x][y] <= cur.count) {
                continue;
            }
            queue.add(new Ape(x, y, cur.count, cur.moves));
            visited[x][y] = cur.count;
        }
    }


}


