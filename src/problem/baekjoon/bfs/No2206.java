package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2206 {
    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        br.close();

        System.out.println(bfs());
    }

    static class Path {
        int x;
        int y;
        boolean wall;

        public Path(int x, int y, boolean wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    private static int bfs() {
        Path[][] visited = new Path[n][m];
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(0, 0, false));
        visited[0][0] = queue.peek();
        int max = n-- * m--;

        for (int i = 1; i <= max; i++) {
            Queue<Path> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Path cur = queue.poll();

                if (cur.x == n && cur.y == m) {
                    return i;
                }

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;
                    if (x < 0 || y < 0 || x > n || y > m) {
                        continue;
                    }
                    if (visited[x][y] != null) {
                        if (map[x][y] == 0 && !cur.wall && visited[x][y].wall) {
                            visited[x][y].wall = false;
                            next.add(visited[x][y]);
                        }
                        continue;
                    }

                    if (map[x][y] == 1) {
                        if (!cur.wall) {
                            next.add(visited[x][y] = new Path(x, y, true));
                        }
                    } else {
                        next.add(visited[x][y] = new Path(x, y, cur.wall));
                    }
                }
            }

            queue = next;
            if (queue.isEmpty()) {
                return -1;
            }
        }

        return -1;
    }

}