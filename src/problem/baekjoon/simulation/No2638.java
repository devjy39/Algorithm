package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2638 {
    static class Cheese {
        int x;
        int y;

        public Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] isCheese = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (st.nextToken().equals("1")) {
                    isCheese[i][j] = true;
                }
            }
        }

        System.out.println(getRemoveDayCount(n, m, isCheese));
    }

    private static int getRemoveDayCount(int n, int m, boolean[][] isCheese) {
        int count = 0;
        Queue<Cheese> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new Cheese(0, 0));
        visited[0][0] = true;
        Queue<Cheese> remove = new LinkedList<>();

        while (!queue.isEmpty()) {
            getRemoveCheeses(n, m, isCheese, queue, visited, remove);
            if (remove.size() == 0) {
                break;
            }
            removeCheese(n, m, isCheese, queue, visited, remove);
            count++;
        }

        return count;
    }

    private static void removeCheese(int n, int m, boolean[][] isCheese, Queue<Cheese> queue, boolean[][] visited, Queue<Cheese> remove) {
        for (Cheese cheese : remove) {
            int air = 0;
            for (int[] dir : dirs) {
                int x = dir[0] + cheese.x;
                int y = dir[1] + cheese.y;

                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }

                if (visited[x][y] && !isCheese[x][y]) { //방문한 공기면 ++
                    air++;
                }
            }

            if (air >= 2) {
                queue.add(cheese); // 다음 순회
            } else {
                visited[cheese.x][cheese.y] = false;
            }
        }

        while (!remove.isEmpty()) { // 치즈제거
            Cheese cheese = remove.poll();
            if (visited[cheese.x][cheese.y]) {
                isCheese[cheese.x][cheese.y] = false;
            }
        }

    }

    private static void getRemoveCheeses(int n, int m, boolean[][] isCheese, Queue<Cheese> queue, boolean[][] visited, Queue<Cheese> remove) {
        while (!queue.isEmpty()) {
            Cheese cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;

                if (isCheese[x][y]) {
                    remove.add(new Cheese(x, y));
                } else {
                    queue.add(new Cheese(x, y));
                }
            }
        }
    }

}

