package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14500 {
    static int[][] map;
    static int result;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                spacialCase(i, j);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int i, int j, int depth, int sum) {
        sum += map[i][j];
        if (depth >= 3) {
            result = Math.max(result, sum);
            return;
        }
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) {
                continue;
            }
            dfs(x, y, depth + 1, sum);
        }

        visited[i][j] = false;
    }
    static Queue<Integer> queue;

    private static void spacialCase(int i, int j) {
        int sum = map[i][j];

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= n || y >= m) {
                continue;
            }
            sum += map[x][y];
            queue.add(map[x][y]);
        }

        if (queue.size() == 3) {
            result = Math.max(result, sum);
        } else if (queue.size() == 4) {
            while (!queue.isEmpty()) {
                result = Math.max(result, sum - queue.poll());
            }
        }
        queue.clear();
    }

}