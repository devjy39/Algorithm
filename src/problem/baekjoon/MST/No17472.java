package problem.baekjoon.MST;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.*;

public class No17472 {
    private static final int MAX_DIST = 1_000_000_000;

    static class Edge {
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static int[] parents;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().equals("1") ? -1 : 0;
            }
        }

        int seq = separateIsland(n, m, map);

        System.out.println(kruskal(seq, getEdges(n, m, map, seq)));
    }

    private static int separateIsland(int n, int m, int[][] map) {
        int seq = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    bfs(map, i, j, ++seq);
                }
            }
        }

        return seq;
    }

    private static void bfs(int[][] map, int i, int j, int seq) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        map[i][j] = seq;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;

                if (x < 0 || y < 0 || x >= map.length || y >= map[x].length || map[x][y] != -1) {
                    continue;
                }

                queue.add(new Point(x, y));
                map[x][y] = seq;
            }
        }
    }

    private static PriorityQueue<Edge> getEdges(int n, int m, int[][] map, int seq) {
        int[][] dist = new int[seq + 1][seq + 1];
        for (int[] d : dist) {
            Arrays.fill(d, MAX_DIST);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    distance(dist, map, i, j);
                }
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        for (int i = 1; i <= seq; i++) {
            for (int j = i + 1; j <= seq; j++) {
                int w = Math.min(dist[i][j], dist[j][i]);
                if (w != MAX_DIST) {
                    pq.add(new Edge(i, j, w));
                }
            }
        }

        return pq;
    }

    private static void distance(int[][] dist, int[][] map, int x, int y) {
        int cur = map[x][y];
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] != 0) {
                if (x - i > 2) {
                    dist[map[i][y]][cur] = Math.min(dist[map[i][y]][cur], x - i - 1);
                }
                break;
            }
        }

        for (int i = x + 1; i < map.length; i++) {
            if (map[i][y] != 0) {
                if (i - x > 2) {
                    dist[map[i][y]][cur] = Math.min(dist[map[i][y]][cur], i - x - 1);
                }
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] != 0) {
                if (y - i > 2) {
                    dist[map[x][i]][cur] = Math.min(dist[map[x][i]][cur], y - i - 1);
                }
                break;
            }
        }

        for (int i = y + 1; i < map[x].length; i++) {
            if (map[x][i] != 0) {
                if (i - y > 2) {
                    dist[map[x][i]][cur] = Math.min(dist[map[x][i]][cur], i - y - 1);
                }
                break;
            }
        }

    }

    private static int kruskal(int n, PriorityQueue<Edge> pq) {
        int distance = 0;
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                distance += edge.w;
                if (--n == 1) {
                    return distance;
                }
            }
        }

        return -1;
    }

    private static void union(int from, int to) {
        from = find(from);
        to = find(to);

        parents[from] = to;
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return n;
        }

        return parents[n] = find(parents[n]);
    }
}