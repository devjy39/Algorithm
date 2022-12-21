package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13460 {

    static class Bead {
        Point red;
        Point blue;

        public Bead(Point red, Point blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        Point hole = null, red = null, blue = null;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == '#') {
                    map[i][j] = '#';
                } else {
                    map[i][j] = '.';
                    if (c == 'O') {
                        hole = new Point(i, j);
                    } else if (c == 'R') {
                        red = new Point(i, j);
                    } else if (c == 'B') {
                        blue = new Point(i, j);
                    }
                }
            }
        }

        System.out.print(bfs(map, hole, new Bead(red, blue)));
    }

    private static int bfs(char[][] map, Point hole, Bead bead) {
        Queue<Bead> queue = new LinkedList<>();
        queue.add(bead);
        boolean[][][][] visited = new boolean[map.length][map[0].length][map.length][map[0].length];
        visited[bead.red.x][bead.red.y][bead.blue.x][bead.blue.y] = true;

        for (int i = 1; i <= 10; i++) {
            Queue<Bead> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Bead cur = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    Bead newBead = move(map, dir, hole, cur);
                    if (newBead == null || visited[newBead.red.x][newBead.red.y][newBead.blue.x][newBead.blue.y]) {
                        continue;
                    }

                    if (hole.equals(newBead.red)) {
                        return i;
                    }
                    visited[newBead.red.x][newBead.red.y][newBead.blue.x][newBead.blue.y] = true;
                    next.add(newBead);
                }
            }

            if (next.isEmpty()) {
                break;
            }

            queue = next;
        }


        return -1;
    }

    private static Bead move(char[][] map, int dir, Point hole, Bead cur) {
        Bead next = new Bead(new Point(cur.red), new Point(cur.blue));
        int redSequence = cur.red.x + cur.red.y - cur.blue.x - cur.blue.y;
        moveBead(map, dirs[dir], hole, next.blue);
        if (next.blue.equals(hole)) {
            return null;
        }
        moveBead(map, dirs[dir], hole, next.red);

        if (next.blue.equals(next.red)) {
            if ((dir > 1) == (redSequence > 0)) {
                next.red.translate(-dirs[dir][0],-dirs[dir][1]);
            } else {
                next.blue.translate(-dirs[dir][0],-dirs[dir][1]);
            }
        }

        return next;
    }

    private static void moveBead(char[][] map, int[] dir, Point hole, Point bead) {
        do {
            bead.translate(dir[0], dir[1]);
            if (bead.equals(hole)) {
                return;
            }
        } while (map[bead.x][bead.y] == '.');

        bead.translate(-dir[0], -dir[1]);
    }

}