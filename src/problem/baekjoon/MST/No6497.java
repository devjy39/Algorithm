package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No6497 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        StringBuilder result = new StringBuilder();

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        while (!"0 0".equals(read = br.readLine())) {
            StringTokenizer st = new StringTokenizer(read);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Edge(a, b, w));
                sum += w;
            }

            result.append(kruskal(n, pq, sum)).append("\n");
        }

        System.out.print(result);
    }

    private static int kruskal(int n, PriorityQueue<Edge> pq, int sum) {
        int save = 0;
        parents = new int[n];
        for (int i = 1; i < n; i++) {
            parents[i] = i;
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                save += edge.w;
                if (--n == 0) {
                    break;
                }
            }
        }

        return sum - save;
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