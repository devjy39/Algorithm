package problem.baekjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;
import java.util.stream.Collectors;

public class No18405 {
    static class Virus {
        int number;
        Point point;

        public Virus(int number, int x, int y) {
            this.number = number;
            this.point = new Point(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][n + 2];
        List<Virus> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new Virus(map[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < map.length; i++) {
            map[i][0] = map[i][n + 1] = map[0][i] = map[n + 1][i] = -1;
        }

        Queue<Point> virus = list.stream()
                .sorted(Comparator.comparingInt(v -> v.number))
                .map(v -> v.point)
                .collect(Collectors.toCollection(LinkedList::new));

        spread(map, virus, s);
        System.out.println(map[x][y]);
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static void spread(int[][] map, Queue<Point> queue, int time) {
        while (!queue.isEmpty()) {
            if (time-- <= 0) {
                break;
            }
            Queue<Point> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];

                    if (map[x][y] == 0) {
                        map[x][y] = map[cur.x][cur.y];
                        next.add(new Point(x, y));
                    }
                }
            }

            queue = next;
        }

    }

}

