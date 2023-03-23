package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1922 {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a != b) {
                pq.add(new Edge(a, b, c));
            }
        }

        System.out.println(getMST(n, pq));
    }

    private static int getMST(int n, PriorityQueue<Edge> pq) {
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int mstPrice = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(parents,edge.to) != find(parents,edge.from)) {
                union(parents, edge.to, edge.from);
                mstPrice += edge.w;
            }
        }

        return mstPrice;
    }

    private static void union(int[] parents, int to, int from) {
        to = find(parents, to);
        from = find(parents, from);

        parents[from] = to;
    }

    private static int find(int[] parents, int node) {
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = find(parents, parents[node]);
    }

}
