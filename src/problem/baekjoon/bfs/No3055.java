package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055 {
    static final char ME = 'S',WATER='*', WALL = 'X', EMPTY = '.', DESTINATION = 'D';
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        Queue<Point> waters = new LinkedList<>();
        Point hero = null;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == WATER) {
                    waters.add(new Point(i, j));
                } else if (map[i][j] == ME) {
                    hero = new Point(i, j);
                }
            }
        }

        int result = bfs(map, waters, hero);
        System.out.println(result >= 0 ? result : "KAKTUS");
    }

    private static int bfs(char[][] map, Queue<Point> waters, Point hero) {
        int n = map.length, m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        queue.add(hero);
        visited[hero.x][hero.y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Queue<Point> next = new LinkedList<>();
            waters = flowWaters(map, waters, n, m);

            if (moveToDestination(map, queue, next, visited, n, m)) {
                return count;
            }

            count++;
            queue = next;
        }

        return -1;
    }

    private static boolean moveToDestination(char[][] map, Queue<Point> queue, Queue<Point> next, boolean[][] visited, int n, int m) {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (map[cur.x][cur.y] == DESTINATION) {
                return true;
            }

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || (map[x][y] != EMPTY && map[x][y] != DESTINATION)) {
                    continue;
                }

                next.add(new Point(x, y));
                visited[x][y] = true;
            }
        }

        return false;
    }

    private static Queue<Point> flowWaters(char[][] map, Queue<Point> waters, int n, int m) {
        Queue<Point> nextWater = new LinkedList<>();

        while (!waters.isEmpty()) {
            Point water = waters.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + water.x;
                int y = dir[1] + water.y;

                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] != EMPTY) {
                    continue;
                }

                map[x][y] = WATER;
                nextWater.add(new Point(x, y));
            }
        }
        return nextWater;
    }

}

