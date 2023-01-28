package problem.baekjoon.MST;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1774 {
    static class Edge {
        int from;
        int to;
        double w;

        public Edge(int from, int to, double w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Point[] point = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.printf("%.2f", kruskal(n, m, br, point));
    }

    private static double kruskal(int n, int m, BufferedReader br, Point[] points) throws IOException {
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(parents, a) != find(parents, b)) {
                union(parents, a, b);
            }
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingDouble(e -> e.w));
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edges.add(new Edge(i, j, points[i].distance(points[j])));
            }
        }

        double distance = 0d;
        int count = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();

            if (find(parents, edge.from) != find(parents, edge.to)) {
                union(parents, edge.from, edge.to);
                distance += edge.w;
                if (++count == n) {
                    return distance;
                }
            }
        }
        return distance;
    }

    private static void union(int[] parents, int from, int to) {
        parents[find(parents, to)] = find(parents, from);
    }

    private static int find(int[] parents, int n) {
        if (parents[n] == n) {
            return n;
        }

        return parents[n] = find(parents, parents[n]);
    }

}