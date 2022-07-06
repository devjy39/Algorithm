package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색2178 {
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            int k = 0;
            for (char c : br.readLine().toCharArray()) {
                map[i][k++] = c - '0';
            }
        }
        br.close();

        System.out.println(bfs(map, n, m));
    }

    private static int bfs(int[][] map, int n, int m) {
        int max = n * m;
        Queue<int[]> queue = new LinkedList<>(List.of(new int[]{0, 0}));
        boolean[][] visited = new boolean[n--][m--];
        visited[0][0] = true;

        for (int i = 1; i <= max; i++) {
            Queue<int[]> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == n && cur[1] == m) {
                    return i;
                }

                for (int[] dir : dirs) {
                    int[] p = {cur[0] + dir[0], cur[1] + dir[1]};

                    if (p[0] < 0 || p[1] < 0 || p[0] > n || p[1] > m || visited[p[0]][p[1]] || map[p[0]][p[1]] == 0) {
                        continue;
                    }
                    visited[p[0]][p[1]] = true;
                    next.add(p);
                }
            }
            queue = next;
        }

        return -1;
    }

}