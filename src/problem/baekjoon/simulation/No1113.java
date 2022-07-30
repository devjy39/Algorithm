package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1113 {
    static class Block {
        int x;
        int y;
        int height;

        public Block(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    static int[][] map;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        n = N - 1;
        m = M - 1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        br.close();

        PriorityQueue<Block> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.height));
        addBorder(N, M, visited, pq);

        System.out.println(priorityFirstSearch(visited, pq));
    }

    private static void addBorder(int N, int M, boolean[][] visited, PriorityQueue<Block> pq) {
        for (int i = 0; i < N; i++) {
            pq.add(new Block(i, 0, map[i][0]));
            visited[i][0] = true;
            pq.add(new Block(i, m, map[i][m]));
            visited[i][m] = true;
        }
        for (int i = 0; i < M; i++) {
            pq.add(new Block(0, i, map[0][i]));
            visited[0][i] = true;
            pq.add(new Block(n, i, map[n][i]));
            visited[n][i] = true;
        }
    }

    private static int priorityFirstSearch(boolean[][] visited, PriorityQueue<Block> pq) {
        int water = 0;
        
        while (!pq.isEmpty()) {
            Block cur = pq.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x > n || y > m || visited[x][y]) {
                    continue;
                }

                if (cur.height > map[x][y]) {
                    water += cur.height - map[x][y];
                    map[x][y] = cur.height;
                }
                visited[x][y] = true;
                pq.add(new Block(x, y, map[x][y]));
            }
        }
        
        return water;
    }

}